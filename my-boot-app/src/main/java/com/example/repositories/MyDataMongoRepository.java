package com.example.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.MyDataMongo;

@Repository
public interface MyDataMongoRepository extends MongoRepository<MyDataMongo, String> {
	
	public List<MyDataMongo> findByName(String str);

}
