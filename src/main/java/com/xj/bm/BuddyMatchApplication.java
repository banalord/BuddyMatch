package com.xj.bm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BuddyMatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuddyMatchApplication.class, args);
    }

}
