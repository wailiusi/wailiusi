package com.ding.ding.db.service;

import com.ding.ding.db.dao.SysLogMapper;
import com.ding.ding.db.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    public Integer save(SysLog sysLog) {
        if (sysLog.getId() == null) {
            sysLogMapper.insert(sysLog);
        }
        return sysLogMapper.updateByPrimaryKey(sysLog);
    }
}
