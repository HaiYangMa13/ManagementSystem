package com.springcloudt1.managerconsumer.Service;

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
public interface SelectEmpService {
    @RequestMapping(value = "/emp/pager")
    List pager (@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);

    @RequestMapping(value = "/emp/loadRole")
    List loadRole ();
    
    @RequestMapping(value = "/emp/loadDept")
    List loadDept();
    
    @RequestMapping(value = "/emp/count")
    List count();

    @RequestMapping(value = "/emp/search")
    List search(@RequestParam("name") String name);
}

         
