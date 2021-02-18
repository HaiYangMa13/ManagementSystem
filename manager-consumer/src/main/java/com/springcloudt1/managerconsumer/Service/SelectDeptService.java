package com.springcloudt1.managerconsumer.Service;

import com.springcloudt1.managerapi.entity.Dept;
import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerconsumer.util.fallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "manager-selectProvider")
public interface SelectDeptService {
    @RequestMapping(value = "/dept/pager")
    List pager (@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);

    @RequestMapping(value = "/dept/show")
    List show ();

    @RequestMapping(value = "/dept/search")
    List check (@RequestParam("name") String name);
}

         
