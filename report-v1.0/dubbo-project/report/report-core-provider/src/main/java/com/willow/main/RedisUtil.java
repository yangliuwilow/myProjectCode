package com.willow.main;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis�����ӿ�
 */
public class RedisUtil {
    private static JedisPool pool = null;

    /**
     * ����redis���ӳ�
     * @return JedisPool
     */
    public static JedisPool getPool() {
        if (pool == null) {
            JedisPoolConfig config = new JedisPoolConfig();
            //����һ��pool�ɷ�����ٸ�jedisʵ����ͨ��pool.getResource()����ȡ��
            //�����ֵΪ-1�����ʾ�����ƣ����pool�Ѿ�������maxActive��jedisʵ�������ʱpool��״̬Ϊexhausted(�ľ�)��
            config.setMaxActive(500);
            //����һ��pool����ж��ٸ�״̬Ϊidle(���е�)��jedisʵ����
            config.setMaxIdle(5);
            //��ʾ��borrow(����)һ��jedisʵ��ʱ�����ĵȴ�ʱ�䣬��������ȴ�ʱ�䣬��ֱ���׳�JedisConnectionException��
            config.setMaxWait(1000 * 100);
            //��borrowһ��jedisʵ��ʱ���Ƿ���ǰ����validate���������Ϊtrue����õ���jedisʵ�����ǿ��õģ�
            config.setTestOnBorrow(true);
            pool = new JedisPool(config, "localhost", 6379,1000,"admin");
        }
        return pool;
    }

    /**
     * ���������ӳ�
     *
     * @param pool
     * @param redis
     */
    public static void returnResource(JedisPool pool, Jedis redis) {
        if (redis != null) {
            pool.returnResource(redis);
        }
    }

    /**
     * ��������
     */
    public static void set(String key,String value){
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource();
            jedis.set(key,value);
        } catch (Exception e) {
            //�ͷ�redis����
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //���������ӳ�
            returnResource(pool, jedis);
        }
    }

    /**
     * ��ȡ����
     *
     * @param key
     * @return
     */
    public static String get(String key){
        String value = null;

        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            //�ͷ�redis����
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //���������ӳ�
            returnResource(pool, jedis);
        }

        return value;
    }

    /**
     * ��������
     */
    public static void setex(String key,String value,int time){
        JedisPool pool = null;
        Jedis jedis = null;
        try {
            pool = getPool();
            jedis = pool.getResource();
            jedis.setex(key, time,value);
        } catch (Exception e) {
            //�ͷ�redis����
            pool.returnBrokenResource(jedis);
            e.printStackTrace();
        } finally {
            //���������ӳ�
            returnResource(pool, jedis);
        }
    }

    public static void main(String[] args) {
        setex("abcef","20",15);
    }

}