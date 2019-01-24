package com.itheima.springboot_jpa1;

import com.itheima.springboot_jpa1.domain.User;
import com.itheima.springboot_jpa1.repository.UserRespiratory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: Administrator
 * @CreateTime: 2019-01-19 15:50
 * @Description: ${Description}
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpa1Application.class)
public class SpringBootJpaTest {
    @Autowired
    private UserRespiratory userRespiratory;
    @Test
    public  void test(){
        List<User> all = userRespiratory.findAll();
        all.stream().forEach(user -> System.out.println(user));

    }

}
