package com.example.shawarmahouse.controller;

import com.example.shawarmahouse.model.MenuItem;
import com.example.shawarmahouse.service.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(
        origins = {"http://localhost:3000/"},
        methods = {
                RequestMethod.GET,
                RequestMethod.DELETE,
                RequestMethod.POST,
                RequestMethod.OPTIONS,
                RequestMethod.PUT
        }
)
@RestController
@RequestMapping("/shawarmahouse/v1")
public class MenuItemController {


    private final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("/getAllMenuItems")
    public ResponseEntity<List<MenuItem>>getAllMenuItems(){
        List<MenuItem> itemList=menuItemService.getAllMenuItems();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }
    @PostMapping("/addMenuItem")
    public ResponseEntity<MenuItem> addNewMenuItem( @RequestBody MenuItem item){
        MenuItem newMenuItem=menuItemService.createNewItem(item);
        return new ResponseEntity<>(newMenuItem,HttpStatus.CREATED);
    }
}
