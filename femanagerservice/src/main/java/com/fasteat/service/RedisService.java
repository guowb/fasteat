package com.fasteat.service;

public interface RedisService {

    void set(String key, String value);

    String get(String key);

    void setObject(String key, Object value);

    Object getObject(String key);

    void del(String key);

    void lpush(String key, String value);

    String rpop(String key);

    void hset(String key, String item, String value);

    String hget(String key, String item);

    Long incr(String key);

    Long decr(String key);

    void expire(String key, int time);

    Long ttl(String key);
}
