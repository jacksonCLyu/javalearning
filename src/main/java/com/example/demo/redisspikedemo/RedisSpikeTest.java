package com.example.demo.redisspikedemo;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class RedisSpikeTest {

    public static void main(String[] args) {

        final String watchkeys = "watchkeys";
        // 20 个线程池并发数
        ExecutorService executor = Executors.newFixedThreadPool(20);

        final Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set(watchkeys, "100"); // 设置起始抢购数
        // jedis.del("setsucc", "setfail");
        jedis.close();

        for (int i = 0; i < 1000; i++) {
            executor.execute(new MyRunnable("user" + getRandomString(6)));
        }

        executor.shutdown();
    }

    public static String getRandomString(int length) { //length是随机字符串长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
