package com.example.joseph.auditservice.repository;

import com.example.joseph.auditservice.model.CustomerBehavior;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "customer-behaviors", path = "customer-behaviors")
public interface CustomerBehaviorRepository extends MongoRepository<CustomerBehavior, Long> {
}
