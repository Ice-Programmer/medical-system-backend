package com.chen.medical.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chen.medical.model.entity.User;
import com.chen.medical.service.UserService;
import com.chen.medical.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author chenjiahan
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2023-04-05 10:08:55
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




