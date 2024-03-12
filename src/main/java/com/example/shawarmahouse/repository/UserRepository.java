package com.example.shawarmahouse.repository;

import com.example.shawarmahouse.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findByPhone(String phone);
    User findByName(String Name);
}
