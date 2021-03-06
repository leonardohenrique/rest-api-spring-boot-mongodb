package com.leonardohenrique.mongodb.event;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ReflectionUtils;

import com.leonardohenrique.mongodb.annotation.CascadeSave;

public class CascadeCallback implements ReflectionUtils.FieldCallback {

	private Object source;
	private MongoOperations mongoOperations;

	CascadeCallback(final Object source, final MongoOperations mongoOperations) {
		this.source = source;
		this.setMongoOperations(mongoOperations);
	}

	@Override
	public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {
		ReflectionUtils.makeAccessible(field);

		if (!field.isAnnotationPresent(DBRef.class) || !field.isAnnotationPresent(CascadeSave.class)) {
			return;
		}

		final Object fieldValue = field.get(getSource());

		if (fieldValue == null) {
			return;
		}

		if (fieldValue instanceof List<?> == false) {
			saveFieldValue(fieldValue);
			return;
		}

		for (Object o : (List<?>) fieldValue) {
			saveFieldValue(o);
		}
	}

	private void saveFieldValue(final Object fieldValue) {
		final FieldCallback callback = new FieldCallback();

		ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

		getMongoOperations().save(fieldValue);
	}

	private Object getSource() {
		return source;
	}

	public void setSource(final Object source) {
		this.source = source;
	}

	private MongoOperations getMongoOperations() {
		return mongoOperations;
	}

	private void setMongoOperations(final MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}
}