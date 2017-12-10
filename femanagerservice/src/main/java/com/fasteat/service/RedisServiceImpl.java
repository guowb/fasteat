package com.fasteat.service;


import com.fasteat.server.util.SerializeUtil;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisServiceImpl implements  RedisService{
   private static Jedis jedis;
   static {
//120.78.184.134
       jedis=new Jedis("47.95.195.248",6379);
       //判断是否 能通
       String ping = jedis.ping();
       System.out.println(ping);
   }
    @Override
    public void set(String key, String value) {
     jedis.set(key,value);
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }

    @Override
    public void setObject(String key, Object value) {
        jedis.set(key.getBytes(), SerializeUtil.serialize(value));
    }

    @Override
    public Object getObject(String key) {
        Object value=SerializeUtil.unserialize(jedis.get(key.getBytes()));
        return value;
    }

    @Override
    public void del(String key) {
    jedis.del(key);
    }



    @Override
    public void lpush(String key, String value) {
               jedis.lpush(key,value);
    }

    @Override
    public String rpop(String key) {
        return jedis.rpop(key);
    }

    @Override
    public void hset(String key, String item, String value) {
        jedis.hset(key,item,value);

    }

    @Override
    public String hget(String key, String item) {
        return jedis.hget(key,item);
           }

    @Override
    public Long incr(String key) {
     return  jedis.incr(key);
    }

    @Override
    public Long decr(String key) {
     return jedis.decr(key);
    }

    @Override
    public void expire(String key, int time) {
        jedis.expire(key,time);
           }

    @Override
    public Long ttl(String key) {
        return jedis.ttl(key);
    }
}
