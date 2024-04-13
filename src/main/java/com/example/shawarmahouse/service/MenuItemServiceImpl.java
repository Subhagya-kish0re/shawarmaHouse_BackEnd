package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.MenuItem;
import com.example.shawarmahouse.repository.MenuItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
public class MenuItemServiceImpl implements MenuItemService{
    private final MenuItemRepository menuItemRepository;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public List<MenuItem> getAllMenuItems(){
        log.info("Fetching all Menu items");
        return (List<MenuItem>) menuItemRepository.findAll();
    }

    @Override
    public MenuItem createNewItem(MenuItem item){
        log.info("creating a new menu item");
        MenuItem newItem=MenuItem.builder()
                .name(item.getName())
                .category(item.getCategory())
                .description(item.getDescription())
                .price(item.getPrice())
                .build();
        return menuItemRepository.save(newItem);
    }
    @Override
    public MenuItem getMenuItemByName(String name){
        log.info("getting menu item by name");
     return menuItemRepository.findByName(name).orElseThrow(()->new NullPointerException(name));
    }

    @Override
    public MenuItem addMenuItem(String name, String description, int price, String category, String photolink, String subCategory) throws IOException, IOException {
        log.info("creating a new menu item");
        MenuItem menuItem=MenuItem.builder()
                .name(name)
                .description(description)
                .category(category)
                .subCategory(subCategory)
                .photo(photolink)
                .price(price)
                .build();
        return menuItemRepository.save(menuItem);
    }

}
