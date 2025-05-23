package com.xj.bm.service.impl;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;
    @Test
    void test(){
        //list
        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(list.get(0));
        list.remove(0);

        RList<String> rlist = redissonClient.getList("test-list");
        rlist.add("oll");
        System.out.println(rlist.get(0));
        rlist.remove(0);
    }

}
