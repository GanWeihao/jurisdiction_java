package org.item.jurisdiction.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String arg[]){
        Jedis jedis = new Jedis("127.0.0.1");
        jedis.set("ms","马松");
        jedis.set("zyx","注意熊");
        jedis.hset("lanqiao","id","01");
        jedis.hset("lanqiao","name","甘伟浩");
        String ms = jedis.get("ms");
        Map map = jedis.hgetAll("lanqiao");
        System.out.println(map);
        jedis.close();
    }
}
