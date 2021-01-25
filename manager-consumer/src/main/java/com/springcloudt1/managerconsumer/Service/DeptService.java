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
@FeignClient(name = "manager-provider")
public interface DeptService {
    @RequestMapping(value = "/dept/pager")
    List pager (@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize);

    @RequestMapping(value = "/dept/del")
    void del (@RequestParam("id") int id);

    @RequestMapping(value = "/dept/show")
    List show ();

    @RequestMapping(value = "/dept/load")
    Dept load(@RequestParam("id")int id);
    @RequestMapping(value = "/dept/add")
    List add (@RequestBody Dept data);

    @RequestMapping(value = "/dept/update")
    List update (@RequestBody Dept data);

    @RequestMapping(value = "/dept/delAll")
    void delAll (@RequestBody int[] id);

    @RequestMapping(value = "/dept/search")
    List check (@RequestParam("name") String name);
}

         
