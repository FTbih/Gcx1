package com.gcx.ssm.service.impl;

import com.gcx.ssm.dao.SysLogDao;
import com.gcx.ssm.domain.SysLog;
import com.gcx.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);
    }
}
