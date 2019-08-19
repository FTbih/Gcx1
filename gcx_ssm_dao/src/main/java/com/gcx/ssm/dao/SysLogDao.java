package com.gcx.ssm.dao;

import com.gcx.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;

public interface SysLogDao {
    @Insert("insert into syslog (VISITTIME, USERNAME, IP, URL, EXECUTIONTIME, METHOD) values (#{visitTime}, #{username}, #{ip}, #{url}, #{executionTime}, #{method})")
    public void save(SysLog sysLog);
}
