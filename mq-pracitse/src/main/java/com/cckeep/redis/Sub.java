package com.cckeep.redis;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class Sub {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.199.239",6379);

        String bbb = jedis.lpop("bbb");
        System.out.println(bbb);


        jedis.subscribe(new JedisPubSub(){
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("channel:"+channel+",message:"+message);
            }
        },"aaa");
    }

}
