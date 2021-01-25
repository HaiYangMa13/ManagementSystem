package com.springcloudt1.managerprovider.Controller;


import com.springcloudt1.managerprovider.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping(value = "/login")
    public Object login (String name,String pwd,String role) {

        Map map = new HashMap();
        Object loginUser;
        if ("管理员".equals(role)) {
            map.put("name", name);
            map.put("pwd", pwd);
            loginUser = userService.loadManager(map);
        } else {
            map.put("name", name);
            map.put("pwd", pwd);
            loginUser = userService.loadOthers(map);
        }
        return loginUser;
    }
}
