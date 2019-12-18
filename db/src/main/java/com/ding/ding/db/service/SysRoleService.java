package com.ding.ding.db.service;

import com.ding.ding.db.dao.SysRoleMapper;
import com.ding.ding.db.domain.SysRole;
import com.ding.ding.db.domain.SysRoleExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleService {

    @Resource
    private SysRoleMapper roleMapper;


    public Set<String> queryByIds(Integer[] roleIds) {
        Set<String> roles = new HashSet<String>();
        if (roleIds.length == 0) {
            return roles;
        }
        SysRoleExample example = new SysRoleExample();
        example.or().andIdIn(Arrays.asList(roleIds)).andEnabledEqualTo(true).andDeletedEqualTo(false);
        List<SysRole> roleList = roleMapper.selectByExample(example);

        for (SysRole role : roleList) {
            roles.add(role.getName());
        }
        return roles;
    }

}
