package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.MenuItem;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MenuItemService {
    List<MenuItem> getAllMenuItems();

    MenuItem createNewItem(MenuItem item);

    MenuItem getMenuItemByName(String name);

    MenuItem addMenuItem(String name, String description, int price, String category, String photolink, String subCategory) throws IOException, IOException;
}
