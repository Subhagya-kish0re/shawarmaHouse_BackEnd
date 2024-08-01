package com.example.shawarmahouse.service;

import com.example.shawarmahouse.dto.UserRequest;
import com.example.shawarmahouse.model.User;
import com.example.shawarmahouse.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByPhoneNumber(String number){
        return userRepository.findByPhone(number);
    }



    @Override
   public User createUserIfNotPresent(@Valid UserRequest userRequest){
        log.info("Attempt to save user:",userRequest);
    User existingUser=userRepository.findByPhone(userRequest.getPhoneNumber());
    if(existingUser==null){
        return userRepository.save(toUserData(userRequest));
    }else{
        return existingUser;
    }

   }


    @Override
    public List<User> getUserList() {
        log.info("Getting all users");

        return (List<User>) userRepository.findAll();
    }

    @Override
    public long getTokens(String phoneNumber) {
        log.info("Fetching tokens for "+phoneNumber);
        User user=userRepository.findByPhone(phoneNumber);
        return user.getTokens();
    }

    @Override
    public User updateTokens(String phoneNumber,Long token) {
        log.info("Setting new token"+token);
        User user=userRepository.findByPhone(phoneNumber);
        user.setTokens(token);
        return userRepository.save(user);
    }

    @Override
    public User updateUserName(String username, String phoneNumber) {
        log.info("updating username");
        User user=userRepository.findByPhone(phoneNumber);
        user.setName(username);
        return userRepository.save(user);
    }

    private User toUserData(UserRequest userRequest) {
        log.info("Converting request to User Data:",userRequest);
        return User.builder()
                .name(userRequest.getName())
                .phone(userRequest.getPhoneNumber())
                .tokens(0)
                .build();
    }
}
