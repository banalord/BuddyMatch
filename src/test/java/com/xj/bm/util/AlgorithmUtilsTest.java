package com.xj.bm.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlgorithmUtilsTest {
    @Test
    void minDistance() {
        String word1 = "香蕉是狗";
        String word2 = "香蕉不是狗";
        int distance = AlgorithmUtils.minDistance(word1, word2);
        System.out.println(distance);
    }
    @Test
    void minDistance2() {
        List<String> list1 = Arrays.asList("Java", "大四", "男");
        List<String> list2 = Arrays.asList("Java", "毕业", "男");
        List<String> list3 = Arrays.asList("男","Java", "毕业");
        int distance1 = AlgorithmUtils.minDistance(list1, list2);
        int distance2 = AlgorithmUtils.minDistance(list3, list2);
        System.out.println(distance1);
        System.out.println(distance2);
    }

}