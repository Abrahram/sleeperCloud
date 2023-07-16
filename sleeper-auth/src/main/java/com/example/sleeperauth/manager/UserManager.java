package com.example.sleeperauth.manager;

import com.example.sleeperauth.mapper.MenuMapper;
import com.example.sleeperauth.mapper.SystemUserMapper;
import com.example.sleepercommon.entity.system.Menu;
import com.example.sleepercommon.entity.system.SystemUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhouxz
 * @date 2023/7/16 20:05
 * @description
 */
@Service
public class UserManager {
    @Autowired
    private SystemUserMapper userMapper;
    @Autowired
    private MenuMapper menuMapper;

    public SystemUser findByName(String username) {
        return userMapper.findByName(username);
    }

    public String findUserPermissions(String username) {
        List<Menu> userPermissions = menuMapper.findUserPermissions(username);
        return userPermissions.stream().map(Menu::getPerms).collect(Collectors.joining(","));
    }
}
