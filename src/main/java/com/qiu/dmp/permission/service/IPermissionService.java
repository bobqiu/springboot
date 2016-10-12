package com.qiu.dmp.permission.service;


import com.qiu.dmp.model.Dept;

import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
public interface IPermissionService {

    public int inserPermission(String id, String pid, String name, String note);

    public List<Dept> listPermission(String id);

    public int updatePermission(String id);

    public int deletePermission(String id);
}

