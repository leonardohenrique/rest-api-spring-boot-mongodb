package com.leonardohenrique.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.leonardohenrique.mongodb.model.Hero;

public interface HeroRepository extends MongoRepository<Hero, String> {

}
