package com.jjh.sky.beanCopy.dozer;

import com.jjh.sky.beanCopy.utils.User;
import com.jjh.sky.beanCopy.utils.UserVo;
import org.dozer.DozerBeanMapper;

/**
 * Created by jiajianhong on 16/9/9.
 */
public class DozerCopy {

    public static void main(String[] args) {
        DozerBeanMapper mapper = new DozerBeanMapper();

        User user = new User();
        user.setId(1);
        user.setName("jjh");

        UserVo userVo = mapper.map(user, UserVo.class);

        System.out.println(userVo.getId());
        System.out.println(userVo.getName());

        UserVo userVo1 = new UserVo();
        userVo1.setId(2);
        userVo1.setName("xiaosong");

        User user1 = mapper.map(userVo1, User.class);
        System.out.println(user1.getId());
        System.out.println(user1.getName());
    }

}
