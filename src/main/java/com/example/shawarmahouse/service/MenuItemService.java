package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.MenuItem;

import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();

    MenuItem createNewItem(MenuItem item);

    MenuItem getMenuItemByName(String name);
}
