package com.example.shawarmahouse.repository;

import com.example.shawarmahouse.model.Orders;
import com.example.shawarmahouse.util.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,String> {
    List<Orders> findByStatus(String status);
}
