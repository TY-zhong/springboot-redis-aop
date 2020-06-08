package cn.zhongguochu.springbootredisaop.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private JedisPoolConfig jedisPoolConfig;
    @Autowired
    private Jedis jedis;

    @Bean
    @ConfigurationProperties("redis")
    public JedisPoolConfig jedisPoolConfig() {
        return new JedisPoolConfig();
    }

    @Bean(destroyMethod = "close")
    public JedisPool jedisPool(@Value("${redis.host}") String host,
            @Value("${redis.port}") int port,
            @Value("${redis.timeout}") int timeout,
            @Value("${redis.password}") String password) {
        return new JedisPool(jedisPoolConfig(), host, port, timeout, password);
    }

    @Bean
    public Jedis jedis() {
        return jedisPool.getResource();
    }

    @Override
    public void set(String key, String value) {
        jedis.set(key, value);
    }

    @Override
    public String get(String key) {
        return jedis.get(key);
    }

    @Override
    public void hset(String key, String mapKey, Object mapValue) {
        jedis.hset(key, mapKey, JSON.toJSONString(mapValue));
    }

    @Override
    public String hget(String key, String mapKey) {
        return jedis.hget(key, mapKey);
    }

    @Override
    public void hmset(String key, Map<String, String> hash) {
        jedis.hmset(key, hash);
    }

    @Override
    public void hdel(String key, String ...mapKey) {
        jedis.hdel(key, mapKey);
    }

    @Override
    public void lpush(String key, String... value) {
        jedis.lpush(key, value);
    }

    @Override
    public List<String> lrange(String key, int start, int stop) {
        return jedis.lrange(key, start, stop);
    }

    @Override
    public String lpop(String key) {
        return jedis.lpop(key);
    }

    @Override
    public String rpop(String key) {
        return rpop(key);
    }

    @Override
    public String lindex(String key, int index) {
        return lindex(key, index);
    }

    @Override
    public Long llen(String key) {
        return jedis.llen(key);
    }

    @Override
    public void sadd(String key, String value) {
        jedis.sadd(key, value);
    }

    @Override
    public Long scard(String key) {
        return jedis.scard(key);
    }

    @Override
    public Set<String> smembers(String key) {
        return jedis.smembers(key);
    }

    @Override
    public Boolean sismember(String key, String member) {
        return jedis.sismember(key, member);
    }

    @Override
    public String spop(String key) {
        return jedis.spop(key);
    }
}
