package cn.zhongguochu.springbootredisaop.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

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
     * @return
     */
    String hget(String key, String mapKey);

    /**
     * 批量设置
     * @param key
     * @param hash
     */
    void hmset(String key, Map<String, String> hash);

    /**
     * 删除key对应的map中value的值
     * @param key
     * @param value
     */
    void hdel(String key, String ...value);

    /**
     * push一个或多个值到头部
     * @param key
     * @param value
     */
    void lpush(String key, String ...value);

    /**
     * 获取列表指定范围内的元素
     * @param key
     * @param start 开始下标
     * @param stop 结束下标
     * @return
     */
    List<String> lrange(String key, int start, int stop);

    /**
     * 移出并获取列表的第一个元素
     * @param key
     * @return
     */
    String lpop(String key);

    /**
     * 移出并获取列表的最后一个元素
     * @param key
     * @return
     */
    String rpop(String key);

    /**
     * 根据下标获取元素
     * @param key
     * @param index
     * @return
     */
    String lindex(String key, int index);

    /**
     * 获取列表的长度
     * @param key
     * @return
     */
    Long llen(String key);

    /**
     * 向集合添加一个成员
     * @param key
     * @param value
     */
    void sadd(String key, String value);

    /**
     * 获取集合的成员数量
     * @param key
     * @return
     */
    Long scard(String key);

    /**
     *获取集合的所有元素
     * @param key
     * @return
     */
    Set<String> smembers(String key);

    /**
     * 判断集合中是否包含成员
     * @param key 集合key
     * @param member 成员
     * @return
     */
    Boolean sismember(String key, String member);

    /**
     * 移除并返回集合中的一个随机元素
     * @param key
     * @return
     */
    String spop(String key);
}
