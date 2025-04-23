package com.xj.bm.service.impl;

import com.xj.bm.model.pojo.User;
import com.xj.bm.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    void searchUserByTags() {
        List<String> tagNameList = Arrays.asList("java", "mysql");
        List<User> users = userService.searchUsersByTags(tagNameList);
        Assertions.assertNotNull(users);
    }
}