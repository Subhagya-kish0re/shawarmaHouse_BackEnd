package com.example.shawarmahouse.service;

import com.example.shawarmahouse.model.MenuItem;
import com.example.shawarmahouse.repository.MenuItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
