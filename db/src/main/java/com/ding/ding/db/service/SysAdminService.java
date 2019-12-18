package com.ding.ding.db.service;

import com.ding.ding.db.dao.SysAdminMapper;
import com.ding.ding.db.domain.SysAdmin;
import com.ding.ding.db.domain.SysAdminExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysAdminService {

    @Resource
    private SysAdminMapper adminMapper;

    public List<SysAdmin> findAdmin(String username) {
        SysAdminExample example = new SysAdminExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }

    public void save(SysAdmin admin) {
        if (admin.getId() == null) {
            adminMapper.insertSelective(admin);
        } else {
            adminMapper.updateByPrimaryKeySelective(admin);
        }
    }

}
