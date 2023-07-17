package com.example.sleepercommon.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.userdetails.User;

/**
 * @author zhouxz
 * @date 2023/7/15 16:39
 * @description
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthUser extends User {
    private static final long serialVersionUID = -1748289340320186418L;

    private String username;

    private String password;

    private boolean accountNonExpired = true;

    private boolean accountNonLocked= true;

    private boolean credentialsNonExpired= true;

    private boolean enabled= true;

}
