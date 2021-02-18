package com.springcloudt1.managerconsumer.Service;

import com.springcloudt1.managerapi.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "manager-addProvider")
public interface AddDeptService {

    @RequestMapping(value = "/dept/del")
    void del (@RequestParam("id") int id);

    @RequestMapping(value = "/dept/add")
    List add (@RequestBody Dept data);

    @RequestMapping(value = "/dept/update")
    List update (@RequestBody Dept data);

    @RequestMapping(value = "/dept/delAll")
    void delAll (@RequestBody int[] id);
}

         
