package com.itheima.springboot_jpa1.Controller;

import com.itheima.springboot_jpa1.domain.User;
import com.itheima.springboot_jpa1.repository.UserRespiratory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Administrator
 * @CreateTime: 2019-01-19 15:55
 * @Description: ${Description}
 */
@RestController
public class UserController {
    @Autowired
    private UserRespiratory userRespiratory ;
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userRespiratory.findAll();
    }
}
