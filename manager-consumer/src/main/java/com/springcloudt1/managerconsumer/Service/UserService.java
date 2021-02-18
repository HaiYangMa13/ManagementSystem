package com.springcloudt1.managerconsumer.Service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "manager-selectProvider")
public interface UserService {
    @RequestMapping(value = "/user/login")
    Object login(@RequestParam("name") String name, @RequestParam("pwd") String pwd, @RequestParam("role") String role);
}
