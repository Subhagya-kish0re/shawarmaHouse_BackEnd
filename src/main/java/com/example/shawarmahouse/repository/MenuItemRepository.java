package com.example.shawarmahouse.repository;

import com.example.shawarmahouse.model.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem,String> {

    Optional<MenuItem> findByName(String name);
}
