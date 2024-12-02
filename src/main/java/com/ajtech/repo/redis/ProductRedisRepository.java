package com.ajtech.repo.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ajtech.entity.Product;

@Repository
public interface ProductRedisRepository extends CrudRepository<Product, String> {
}
