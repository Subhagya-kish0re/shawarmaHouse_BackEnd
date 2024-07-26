package com.example.shawarmahouse.service;

import com.example.shawarmahouse.dto.UserRequest;
import com.example.shawarmahouse.model.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    User findByPhoneNumber(String number);


    User createUserIfNotPresent(@Valid UserRequest userRequest);

    List<User> getUserList();

    long getTokens(String phoneNumber);

    User updateTokens(String phoneNumber,Long token);
}
