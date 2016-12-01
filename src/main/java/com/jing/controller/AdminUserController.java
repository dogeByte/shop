package com.jing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Title: SystemUserController</p>
 * <p>Description: </p>
 * 
 * @version 1.0.0
 * @author  JingBo
 */
@Controller
@RequestMapping("/manage")
public class AdminUserController {

    @RequestMapping("/login")
    public String login() {
        return "manage/login";
    }

    @RequestMapping("/loginSubmit")
    public void loginSubmit(String username, String password, String rememberMe) {
        System.out.println(username);
        System.out.println(password);
        System.out.println(rememberMe);
    }

}
