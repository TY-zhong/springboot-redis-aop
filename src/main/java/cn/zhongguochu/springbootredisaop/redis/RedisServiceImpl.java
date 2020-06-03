package cn.zhongguochu.springbootredisaop.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Service
public class RedisServiceImpl implements RedisService {
    public Jedis getJedis() {
        JedisPoolConfig config = new JedisPoolConfig();
        System.out.println("初始化jedis");
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool jedisPool = new JedisPool(config, "49.233.168.202", 6379, 2000, "yMEKq5IzoAUyqBl1");
        Jedis jedis = jedisPool.getResource();
        return jedis;
    }

    @Override
    public void set(String key, String value) {
        getJedis().set(key, value);
    }

    @Override
    public void setObject(String key, Object object) {
        getJedis().set(key, JSON.toJSONString(object));
    }

    @Override
    public String get(String key) {
        return getJedis().get(key);
    }

    @Override
    public <T> T getObject(String key, Class<T> t) {
        String value = getJedis().get(key);
        JSONObject jsonObject = JSON.parseObject(value);
        return JSON.toJavaObject(jsonObject, t);
    }

    @Override
    public void hset(String key, String mapKey, Object mapValue) {

    }

    @Override
    public <T> T hget(String key, String mapKey, Class<T> t) {
        return null;
    }

    @Override
    public void hmset(String key, String... params) {

    }
}
