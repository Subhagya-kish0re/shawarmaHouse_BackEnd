package com.example.shawarmahouse.controller;

import com.example.shawarmahouse.model.MenuItem;
import com.example.shawarmahouse.service.MenuItemService;
import jakarta.validation.Valid;
import org.bson.types.Binary;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(
        origins = {"*"},
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
//    @PostMapping(value = "/addMenuItem", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_OCTET_STREAM_VALUE},
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<MenuItem> createMenuItem(@RequestPart("menuItem") @Valid MenuItem menuItem, @RequestPart("photo") MultipartFile photo) throws IOException {
//        menuItem.setPhoto(new Binary(photo.getBytes()));
//        MenuItem savedMenuItem = menuItemService.addMenuItem(menuItem.getName(), menuItem.getDescription(), menuItem.getPrice(), menuItem.getCategory(), photo, menuItem.getSubCategory());
//        return new ResponseEntity<>(savedMenuItem, HttpStatus.CREATED);
//    }

    @PostMapping("/addMenuItem")
    public ResponseEntity<MenuItem> createMenuItem(@RequestParam("name") String name,
    @RequestParam("description")String description,
    @RequestParam("price") int price,
    @RequestParam("category")String category,
    @RequestParam("photolink")String photolink,
    @RequestParam("subCategory") String subCategory)
            throws IOException {
        MenuItem savedMenuItem = menuItemService.addMenuItem(name, description, price, category, photolink, subCategory);
        return new ResponseEntity<>(savedMenuItem, HttpStatus.CREATED);
    }



}
