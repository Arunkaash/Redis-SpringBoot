package com.redis.Redis.springboot.Controller;

import com.redis.Redis.springboot.Entity.User;
import com.redis.Redis.springboot.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    //save user
    @PostMapping
    public User createUser(@RequestBody User user){
        user.setUserId(user.getUserId());
        return userRepository.save(user);
    }

    //read user
    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId){
        return userRepository.get(userId);
    }

    //readAll user
    @GetMapping
    public Map<Object, Object> getAllUser(){
        return userRepository.getAll();
    }

    //update user
    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userRepository.update(user);
    }
    //delete user
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        userRepository.delete(userId);
        return "Successfully deleted";
    }

}
