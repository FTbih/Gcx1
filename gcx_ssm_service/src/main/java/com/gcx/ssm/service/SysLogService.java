package com.gcx.ssm.service;

import com.gcx.ssm.domain.SysLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface SysLogService {

    public void save(SysLog sysLog);
}
