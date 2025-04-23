package com.xj.bm.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xj.bm.model.pojo.User;
import com.xj.bm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 缓存预热
 */
@Component
@Slf4j
public class PreCacheJob {
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private RedissonClient redissonClient;

    // 重点用户
    private List<Long> mainUserList = Arrays.asList(1L,2L,3L);

    //@Scheduled(cron = "0 20 */2 * * ?")
    @Scheduled(cron = "0 46 16 * * ?")
    public void doCacheRecommendUser(){
        RLock lock = redissonClient.getLock("bm:precachejob:docache:lock");
        try {
            //只有一个线程能获取到锁，其它线程的等待时间为0，这样没获取到锁就不再等待
            if (lock.tryLock(0,3000, TimeUnit.MILLISECONDS)) {
                System.out.println("getLock: " + Thread.currentThread().getId());
                for (Long userId : mainUserList) {
                    String redisKey = String.format("bm:user:recommend:%s",userId);
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    queryWrapper.select("avatarUrl", "username", "planetCode", "tags");
                    Page<User> page = userService.page(new Page<>(1, 8), queryWrapper);
                    redisTemplate.opsForValue().set(redisKey,page,60*2, TimeUnit.MINUTES);
                }
            }
        } catch (InterruptedException e) {
            log.error("doCacheRecommendUser error:", e);
        }finally {
            if (lock.isHeldByCurrentThread()) {
                System.out.println("unLock: " + Thread.currentThread().getId());
                lock.unlock();
            }
        }

    }
}
