package com.qiu.dmp.controller;


import com.qiu.dmp.common.privilege.service.IUserDao;
import com.qiu.dmp.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/24.
 */
@Controller
public class LoginController {


    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private IUserDao userDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        //String username = user.getName();
        String username = request.getParameter("username");
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());

        Subject currentUser = SecurityUtils.getSubject();


        // String exception = (String) request.getAttribute("shiroLoginFailure");

        try {
            LOGGER.info("对用户[" + username + "]进行验证");
            currentUser.login(token);
            LOGGER.info("对用户[" + username + "]进行验证,验证通过");

        } catch (UnknownAccountException uae) {
            LOGGER.info("对用户[" + username + "]进行验证,用户名不存在");
            redirectAttributes.addFlashAttribute("message", "未知账户");
            token.clear();
            return "redirect:/login";
        } catch (IncorrectCredentialsException ice) {
            LOGGER.info("对用户[" + username + "]进行验证,错误的凭证");
            redirectAttributes.addFlashAttribute("message", "密码不正确");
            token.clear();
            return "redirect:/login";
        } catch (LockedAccountException lae) {
            LOGGER.info("对用户[" + username + "]进行验证，用户已锁定");
            redirectAttributes.addFlashAttribute("message", "用户帐号锁定");
            token.clear();
            return "redirect:/login";
        } catch (ExcessiveAttemptsException eae) {
            LOGGER.info("对用户[" + username + "]进行验证，登录次数过多");
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
            token.clear();
            return "redirect:/login";
        } catch (AuthenticationException ae) {
            LOGGER.info("对用户[" + username + "]进行验证，错误信息如下：");
            ae.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
            token.clear();
            return "redirect:/login";
        }

        if (currentUser.isAuthenticated()) {
            LOGGER.info("用户[" + username + "]登录认证成功");
            return "redirect:/test";
        } else {
            token.clear();
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(RedirectAttributes redirectAttributes) {
        SecurityUtils.getSubject().logout();
        redirectAttributes.addFlashAttribute("message", "你已经安全退出");
        return "redirect:/login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        LOGGER.info("------没有权限-------");
        return "403";
    }

    @RequestMapping("/user")
    public String getUserList(Map<String, Object> model) {
        // model.put("userList", userDao());
        return "user";
    }

    @RequestMapping("/user/edit/{userid}")
    public String getUserList(@PathVariable int userid) {
        LOGGER.info("------进入用户信息修改-------");
        return "user_edit";
    }

    private String expout(UsernamePasswordToken token, String string) {
        token.clear();
        return string;
    }


}