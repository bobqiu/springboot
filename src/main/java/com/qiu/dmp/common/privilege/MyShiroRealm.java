package com.qiu.dmp.common.privilege;


import com.qiu.dmp.common.privilege.service.IUserDao;
import com.qiu.dmp.model.User;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/8/29.
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroRealm.class);
    @Autowired
    private IUserDao userDao;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LOGGER.info("##########执行shiro权限认证#############");
        System.out.println("##########执行shiro权限认证11111#############");
        String loginName = (String) super.getAvailablePrincipal(principalCollection);
        User user = userDao.findUserByName(loginName);
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.setRoles(userDao.findRoles(loginName));
            info.setStringPermissions(userDao.findPermissions(loginName));

           /* List<Role> roleList = user.getRoleList();
            for (Role role : roleList) {
                info.addStringPermissions(role.getPermissionName());
            }*/
            return info;
        } else {
            return null;
        }

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        LOGGER.info("验证当前用户获取到的token为：" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        User user = userDao.findUserByName(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        } else {
            return null;
        }
    }
}
