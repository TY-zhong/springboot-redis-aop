package cn.zhongguochu.springbootredisaop.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisUtils {
    @Bean
    @ConfigurationProperties("redis")
    public static JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public static JedisPool jedisPool() {
        return new JedisPool(jedisPoolConfig(), "49.233.168.202", 6379, 2000, "yMEKq5IzoAUyqBl1");
    }

    @Bean
    public static Jedis jedis() {
        return jedisPool().getResource();
    }

    public static void set(String key, String value) {
        jedis().set(key, value);
    }

    public static String get(String key) {
        return jedis().get(key);
    }

    public static void hset(String key, String mapKey, Object mapValue) {
        jedis().hset(key, mapKey, JSON.toJSONString(mapValue));
    }

    public static String hget(String key, String mapKey) {
        return jedis().hget(key, mapKey);
    }

    public static void hmset(String key, Map<String, String> hash) {
        jedis().hmset(key, hash);
    }

    public static void hdel(String key, String ...mapKey) {
        jedis().hdel(key, mapKey);
    }

    public static void lpush(String key, String... value) {
        jedis().lpush(key, value);
    }

    public static List<String> lrange(String key, int start, int stop) {
        return jedis().lrange(key, start, stop);
    }

    public static String lpop(String key) {
        return jedis().lpop(key);
    }

    public static String rpop(String key) {
        return rpop(key);
    }

    public static String lindex(String key, int index) {
        return lindex(key, index);
    }

    public static Long llen(String key) {
        return jedis().llen(key);
    }

    public static void sadd(String key, String value) {
        jedis().sadd(key, value);
    }

    public static Long scard(String key) {
        return jedis().scard(key);
    }

    public static Set<String> smembers(String key) {
        return jedis().smembers(key);
    }

    public static Boolean sismember(String key, String member) {
        return jedis().sismember(key, member);
    }

    public static String spop(String key) {
        return jedis().spop(key);
    }
}