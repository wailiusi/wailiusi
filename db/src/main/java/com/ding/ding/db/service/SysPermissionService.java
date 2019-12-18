package com.ding.ding.db.service;

import com.ding.ding.db.dao.SysPermissionMapper;
import com.ding.ding.db.domain.SysPermission;
import com.ding.ding.db.domain.SysPermissionExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysPermissionService {

    @Resource
    private SysPermissionMapper permissionMapper;

    public Set<String> queryByRoleIds(Integer[] roleIds) {
        Set<String> permissions = new HashSet<String>();
        if (roleIds.length == 0) {
            return permissions;
        }

        SysPermissionExample example = new SysPermissionExample();
        example.or().andRoleIdIn(Arrays.asList(roleIds)).andDeletedEqualTo(false);
        List<SysPermission> permissionList = permissionMapper.selectByExample(example);

        for (SysPermission permission : permissionList) {
            permissions.add(permission.getPermission());
        }

        return permissions;
    }

}
