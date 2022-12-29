package com.springreactive.springreactivemongodbcrud.repository;

import com.springreactive.springreactivemongodbcrud.entity.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<Product> findByPriceBetween(Double lowPrice, Double highPrice);
}
