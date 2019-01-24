package com.itheima.springboot_jpa1.repository;

import com.itheima.springboot_jpa1.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: Administrator
 * @CreateTime: 2019-01-19 15:49
 * @Description: ${Description}
 */
public interface UserRespiratory extends JpaRepository<User,Long> {
    public List<User> findAll();
}
