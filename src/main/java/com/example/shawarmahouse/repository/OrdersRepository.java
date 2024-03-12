package com.example.shawarmahouse.repository;

import com.example.shawarmahouse.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,String> {
}
