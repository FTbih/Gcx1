package com.gcx.ssm.dao;

import com.gcx.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberDao {
    @Select("select * from member where id=#{id}")
    public List<Member> findById(String id);
}
