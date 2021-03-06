package com.yiyi.farm;

import com.yiyi.farm.service.invite.TempInviteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 启动任务，程序启动时运行，好像现在不需要了
 */
@Component
public class AfterStartRun implements CommandLineRunner {
    @Autowired
    TempInviteServiceImpl inviteService;
    @Autowired
    RedisTemplate redisTemplate;
    @Override
    public void run(String... args) throws Exception {
//        String cacheOrNot = (String) redisTemplate.opsForValue().get("cacheOrNot");
//        if(cacheOrNot == null){
//            inviteService.initCache();
//        }
    }
}
