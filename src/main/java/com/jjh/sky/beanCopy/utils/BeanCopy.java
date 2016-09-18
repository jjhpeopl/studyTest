package com.jjh.sky.beanCopy.utils;

import org.springframework.beans.BeanUtils;

/**
 * Created by jiajianhong on 16/9/9.
 */
public class BeanCopy {

    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setName("jjh");
        System.out.println(user.getId());
        System.out.println(user.getName());

        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        System.out.println(userVo.getId());
        System.out.println(userVo.getName());
    }

}
