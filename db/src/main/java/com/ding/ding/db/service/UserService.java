package com.ding.ding.db.service;

import com.ding.ding.db.dao.UserMapper;
import com.ding.ding.db.domain.UserExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public Long count() {
        UserExample e = new UserExample();
        e.or().andDeletedEqualTo(Boolean.FALSE);
        return userMapper.countByExample(e);
    }
}
