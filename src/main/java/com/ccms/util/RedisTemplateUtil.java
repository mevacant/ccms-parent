package com.ccms.util;

import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Lazy(false)
public class RedisTemplateUtil {

    @Resource
    private RedisTemplate redisTemplate;

    private static RedisTemplate staticRedisTemplate;

    @PostConstruct
    public void init() {
        staticRedisTemplate = redisTemplate;
        RedisSerializer stringSerializer = new StringRedisSerializer();
        staticRedisTemplate.setKeySerializer(stringSerializer);
        staticRedisTemplate.setValueSerializer(stringSerializer);
        staticRedisTemplate.setHashKeySerializer(stringSerializer);
        staticRedisTemplate.setHashValueSerializer(stringSerializer);
    }

    /**
     * 建议使用带过期时间的set方法
     * @param key
     * @param value
     */
    @Deprecated
    public static void set(String key,Object value){
        staticRedisTemplate.opsForValue().set(key,value);
    }

    public static void set(String key,Object value, Long seconds){
        staticRedisTemplate.opsForValue().set(key,value, seconds, TimeUnit.SECONDS);
    }


    public static String get(String key){
        return objectToStirng(staticRedisTemplate.opsForValue().get(key));
    }

    /**
     * 设置过期时间，单位秒
     * @param key
     * @param seconds
     * @return
     */
    public static boolean expire(String key, int seconds) {
        return staticRedisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public static boolean exists(String key) {
        return staticRedisTemplate.hasKey(key);
    }

    /**
     * 设置带过期时间的缓存key
     * @param key
     * @param value
     * @param expireTime 单位秒
     */
    public static void setKeyAndExpire(String key,Object value,int expireTime){
        staticRedisTemplate.opsForValue().set(key,value,expireTime,TimeUnit.SECONDS);
    }

    /**
     * 删除key
     * @param key
     */
    public static void del(String key) {
        staticRedisTemplate.delete(key);
    }

    /**
     * 获取key存活时间
     * @param key
     * @return
     */
    public static Long ttl(String key){
        Long expireTime = staticRedisTemplate.getExpire(key);
        return expireTime == null ? 0L : expireTime;
    }

    /**
     * hash表获取所有字段值
     * @param table
     * @return
     */
    public static Map<String, String> hGetAll(String table){
        return staticRedisTemplate.opsForHash().entries(table);
    }

    /**
     * hash表设置
     * @param key
     * @param hash
     * @return
     */
    public static void hSetAll(String key, Map<String, String> hash){
        staticRedisTemplate.opsForHash().putAll(key, hash);
    }

    /**
     * hash表获取指定字段值
     * @param table
     * @param field
     * @return
     */
    public static String hGet(String table,String field){
        return objectToStirng(staticRedisTemplate.opsForHash().get(table,field));
    }

    /**
     * hash表获取多个字段的值
     * @param table
     * @param fields
     * @return
     */
    public static List<String> hmGet(String table,List<String> fields){
        List<String> valueList = staticRedisTemplate.opsForHash().multiGet(table,fields);
        return valueList;
    }

    /**
     * hash表设置指定字段值
     * @param table
     * @param field
     * @param value
     */
    public static void hSet(String table,String field,String value){
        staticRedisTemplate.opsForHash().put(table,field,value);
    }

    /**
     * 为哈希表中的字段值加上指定值(+,-)
     * @param key
     * @param hashKey
     * @param num
     */
    public static void increment(String key,String hashKey,long num){
        staticRedisTemplate.opsForHash().increment(key,hashKey,num);
    }
    /**
     * hash表为指定字段自增
     * @param table
     * @param field
     * @param incrbyNum
     * @return
     */
    public static Long hIncrby(String table,String field,Integer incrbyNum){
        return staticRedisTemplate.opsForHash().increment(table,field,incrbyNum);
    }
    /**
     * 通过key给指定的value加值
     *
     * @param key
     * @param integer
     * @return
     */
    public static Long incrBy(String key,int integer) {
        return staticRedisTemplate.opsForValue().increment(key, Long.valueOf(integer));
    }

    public static Long incrBy(String key) {
        return staticRedisTemplate.opsForValue().increment(key);
    }

    /**
     * 若key不存在，则把key设置为新的value。若设置成功返回true，否则false
     *
     * @author
     * @param key
     * @param value
     * @return
     */
    public static boolean setnx(String key, String value) {
        return staticRedisTemplate.opsForValue().setIfAbsent(key, value);
    }

    private static String objectToStirng(Object v) {
        return null == v ? null : (String) v;
    }
}
