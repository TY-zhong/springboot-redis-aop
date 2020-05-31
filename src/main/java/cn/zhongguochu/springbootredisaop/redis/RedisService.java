package cn.zhongguochu.springbootredisaop.redis;

public interface RedisService {
    /**
     * 字符串的设置值
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 字符串的获取值
     * @param key redis获取key的值
     * @return 获取的值
     */
    String get(String key);

    /**
     * 设置key对应的map中mapKey的值
     * @param key redis中获取hashmap的key
     * @param mapKey hashmap中设置value的key
     * @param mapValue hashmap中key设置的值
     */
    void hset(String key, String mapKey, Object mapValue);

    /**
     * 获取key对应的map中mapKey的值
     * @param key redis中获取hashmap的key
     * @param mapKey hashmap中设置value的key
     * @param t 需要返回的对象类型
     * @param <T>
     * @return
     */
    <T> T hget(String key, String mapKey, Class<T> t);

    /**
     * 批量设置
     * @param key
     * @param params
     */
    void hmset(String key, String ...params);
}
