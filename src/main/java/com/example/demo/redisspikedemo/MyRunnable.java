package com.example.demo.redisspikedemo;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

@Slf4j
public class MyRunnable implements Runnable {

    String watchkeys = "watchkeys";
    Jedis jedis = new Jedis("127.0.0.1", 6379);
    String userInfo;

    public MyRunnable() {

    }

    public MyRunnable(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public void run() {
        try {
            jedis.watch(watchkeys);
            String val = jedis.get(watchkeys);
            int valInt = Integer.valueOf(val);
            if (valInt <= 100 && valInt >= 1) {
                Transaction tx = jedis.multi();// 开启事务
                tx.incrBy("watchkeys", -1);
                List<Object> list = tx.exec();// 提交事务， 如果此时 watchkeys 被改动了， 则返回 null
                if (null == list || list.size() == 0) {
                    String failUser = "fail-" + userInfo;
                    String failInfo = "用户： " + failUser + "秒杀失败！谢谢您的参与，请下次再接再厉！";
                    log.info(failInfo);
                    jedis.setnx(userInfo, failInfo);
                } else {
                    for (Object succ : list) {
                        String succUser = "succ-" + succ.toString() + userInfo;
                        String succinfo = "用户： " + succUser + "恭喜您，秒杀成功！当前抢购人数： " + (1-(valInt - 100));
                        log.info(succinfo);
                        /* 抢购成功业务逻辑 */
                        jedis.setnx(succUser, succinfo);
                    }
                }
            } else {
                String failUser = "kcfail-" + userInfo;
                String failInfo = "用户： " + failUser + "来晚一步，商品已被秒杀一空！";
                log.info(failInfo);
                jedis.setnx(failUser, failInfo);
            }
        } catch (Exception e) {
            log.info("exception: {}", e.getMessage());
        } finally {
            jedis.close();
        }
    }
}
