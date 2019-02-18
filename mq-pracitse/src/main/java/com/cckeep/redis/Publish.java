package com.cckeep.redis;

import redis.clients.jedis.Jedis;

public class Publish {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.30.127.14",6379);


        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
        /*String channel = "orderchannel";
        for (int i = 0; i < 100; i++) {
            jedis.publish(channel,"message_"+i);
        }
        jedis.shutdown();*/

        Long publish = jedis.publish("aaa", "ccc");
        System.out.println(publish);


    }


}
