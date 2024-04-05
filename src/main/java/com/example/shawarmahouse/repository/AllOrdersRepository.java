package com.example.shawarmahouse.repository;

import com.example.shawarmahouse.model.AllOrders;
import com.example.shawarmahouse.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllOrdersRepository extends CrudRepository<AllOrders,String> {
    AllOrders save(Orders order);
    int countByPhoneNumber(String phoneNumber);
    List<AllOrders> findByPhoneNumber(String phoneNumber);
}
