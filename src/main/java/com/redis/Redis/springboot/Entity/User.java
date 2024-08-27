package com.redis.Redis.springboot.Entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
// Redis, being a key-value store, handles data as byte streams.
// Java objects, however, can't be directly stored in this format.
// Therefore, serialization converts Java objects into byte streams so they can be stored in Redis,
// and deserialization converts those byte streams back into Java objects when retrieved.


    private String userId;
    private String name;
    private String phone;
    private String email;
}
