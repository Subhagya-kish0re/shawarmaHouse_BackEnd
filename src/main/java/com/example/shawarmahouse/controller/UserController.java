package com.example.shawarmahouse.controller;

import com.example.shawarmahouse.dto.UserRequest;
import com.example.shawarmahouse.model.User;
import com.example.shawarmahouse.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public ResponseEntity<String> getTest(){
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserRequest userRequest){
        User user=userService.createUserIfNotPresent(userRequest);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/findbynumber")
    public ResponseEntity<User>getUserByNumber(@RequestParam String number){
        User user=userService.findByPhoneNumber(number);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>>getAllUsers(){
        List<User> users=userService.getUserList();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }


}
