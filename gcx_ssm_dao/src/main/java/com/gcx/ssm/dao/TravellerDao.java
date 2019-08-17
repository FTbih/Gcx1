package com.gcx.ssm.dao;

import com.gcx.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TravellerDao {
    @Select("select * from TRAVELLER where id in(select TRAVELLERID from ORDER_TRAVELLER where orderid=#{id})")
    public List<Traveller> findById(String id);
}
