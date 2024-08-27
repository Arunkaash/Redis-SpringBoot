package com.redis.Redis.springboot.Repository;

import com.redis.Redis.springboot.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String KEY = "USER121";

    //save
    public User save(User user){
        redisTemplate.opsForHash().put(KEY,user.getUserId(), user);
        return user;
    }

    //read
    public User get(String userId){
        return (User) redisTemplate.opsForHash().get(KEY, userId);
    }

    //readAll
    public Map<Object,Object> getAll(){
        return redisTemplate.opsForHash().entries(KEY);
    }

    //update
    public User update(User user){
        redisTemplate.opsForHash().put(KEY,user.getUserId(), user);
        return user;
    }

    //delete
    public Long delete(String userId){
        return redisTemplate.opsForHash().delete(KEY, userId);
    }
}
