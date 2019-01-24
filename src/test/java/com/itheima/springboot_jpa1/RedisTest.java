package com.itheima.springboot_jpa1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.springboot_jpa1.domain.User;
import com.itheima.springboot_jpa1.repository.UserRespiratory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: Administrator
 * @CreateTime: 2019-01-19 16:07
 * @Description: ${Description}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpa1Application.class)
public class RedisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserRespiratory userRespiratory;
    @Test
    public  void test() throws JsonProcessingException {
        //先从redis中查询如果没有再从数据库中查询
        String userListJson = redisTemplate.boundValueOps("user").get();
        if(null==userListJson){
            List<User> userList = userRespiratory.findAll();
            //将list转为json格式用Jackson转换
            ObjectMapper objectMapper=new ObjectMapper();
             userListJson = objectMapper.writeValueAsString(userList);
             //将数据库中查询出来的数据放入redis
            redisTemplate.boundValueOps("user").set(userListJson);
            System.out.println("从数据库中查询数据");
        }else {
            System.out.println("从redis中查询数据");
        }


    }
}

