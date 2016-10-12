package com.qiu.dmp.permission.service.impl;

import com.qiu.dmp.model.Dept;
import com.qiu.dmp.permission.dao.IPermissionDao;
import com.qiu.dmp.permission.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/7.
 */
@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao permissionDao;

    @Override
    public int inserPermission(String id, String pid, String name, String note) {
        return permissionDao.inserPermission(id, pid, name, note);
    }

    @Override
    public List<Dept> listPermission(String id) {
        return null;
    }

    @Override
    public int updatePermission(String id) {
        return 0;
    }

    @Override
    public int deletePermission(String id) {
        return 0;
    }
}
