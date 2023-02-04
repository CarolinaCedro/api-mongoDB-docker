package io.CarolinaCedro.apimongoDB.repository;

import io.CarolinaCedro.apimongoDB.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends MongoRepository<User,String> {
}
