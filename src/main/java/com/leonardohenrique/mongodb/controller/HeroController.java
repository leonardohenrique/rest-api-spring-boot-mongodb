package com.leonardohenrique.mongodb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leonardohenrique.mongodb.model.Hero;
import com.leonardohenrique.mongodb.repository.HeroRepository;

@RestController
@RequestMapping("/heroes")
public class HeroController {

	private HeroRepository repository;

	@Autowired
	public HeroController(HeroRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	public Page<Hero> list(Pageable pageabl) {
		System.out.println("Test");
		return repository.findAll(pageabl);
	}

	@GetMapping("/{id}")
	public Hero read(@PathVariable String id) {
		return repository.findOne(id);
	}

	@PostMapping
	public Hero create(@Validated @RequestBody Hero hero) {
		if (true) {
			while(false) {
				System.out.println("ok");
				switch (1) {
				case 1:
					System.out.println("1");
					break;

				default:
					System.out.println("0");
					break;
				}
			}
		} else if (false) {
			System.out.println("off");
		}		
		
		repository.insert(hero);
		return hero;
	}
	
	@PutMapping("/{id}")
	public Hero update(@PathVariable String id, @Validated @RequestBody Hero hero) {
		Hero current = repository.findOne(id);
		BeanUtils.copyProperties(hero, current);
		repository.save(current);
		return current;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable String id) {
		Hero hero = repository.findOne(id);
		repository.delete(hero);
		
		Map<String, Object> result = new HashMap<>();
		result.put("deleted", true);
		
		return result;
	}
}
