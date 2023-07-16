package com.example.sleeperauth.mapper;

import com.example.sleepercommon.entity.system.SystemUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);

    SystemUser findByName(String username);
}