package com.leonardohenrique.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.leonardohenrique.mongodb.model.Villain;

public interface VillainRepository extends MongoRepository<Villain, String> {

}
