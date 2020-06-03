package cn.zhongguochu.springbootredisaop.redis;

import cn.zhongguochu.springbootredisaop.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisServiceImpl implements RedisService{
    public void set(String key, String value) {

    }

    public String get(String key) {
        return null;
    }

    public void hset(String key, String mapKey, Object mapValue) {

    }

    public <T> T hget(String key, String mapKey, Class<T> t) {
        return null;
    }

    public void hmset(String key, String... params) {

    }

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        JedisPool jedisPool = new JedisPool(config, "49.233.168.202", 6379, 2000, "yMEKq5IzoAUyqBl1");
        Jedis jedis = jedisPool.getResource();
        User user = new User("1", "张三", 12, "1954654632", 1);
        jedis.set("key", JSON.toJSONString(user));
        String value = jedis.get("key");
        JSONObject jsonObject = JSON.parseObject(value);
        System.out.println(jsonObject);
        User user1 = JSON.toJavaObject(jsonObject, User.class);
        System.out.println(user1.getName());
    }
}
