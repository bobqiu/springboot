package com.qiu.dmp.common.privilege.service;


import com.qiu.dmp.model.User;

import java.util.Set;

/**
 * Created by Administrator on 2016/8/31.
 */
public interface IUserDao {
    public User findUserByName(String loginName);

    public Set<String> findRoles(String loginName);

    public Set<String> findPermissions(String loginName);
}
