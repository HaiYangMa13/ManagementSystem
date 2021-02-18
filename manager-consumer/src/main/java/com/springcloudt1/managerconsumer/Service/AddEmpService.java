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
@FeignClient(name = "manager-addProvider",fallbackFactory = fallbackFactory.class)
public interface AddEmpService {

    @RequestMapping(value = "/emp/del")
    void del (@RequestParam("id") int id);

    @RequestMapping(value = "/emp/add")
    List add (@RequestBody Emp data);

    @RequestMapping(value = "/emp/update")
    List update (@RequestBody Emp data);

    @RequestMapping(value = "/emp/delAll")
    void delAll (@RequestBody int[] id);

}

         
