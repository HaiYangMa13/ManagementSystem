package com.springcloudt1.managerconsumer.Controller;

import com.springcloudt1.managerconsumer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final static String REST_URI_PRIFIX = "http://localhost:8888";
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login")
    public Object login (String name,String pwd, String role, HttpServletRequest request) {
        Object loginUser =userService.login(name,pwd,role);
        request.getSession().setAttribute("loginUser",loginUser);
        return loginUser;
    }
}
