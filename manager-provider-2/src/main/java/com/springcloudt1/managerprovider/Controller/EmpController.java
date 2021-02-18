package com.springcloudt1.managerprovider.Controller;


import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerprovider.service.EmpService;
import com.springcloudt1.managerprovider.service.PermissionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Resource
    EmpService empService;
    @RequestMapping(value = "/add")
    public void add(@RequestBody Emp data) {
        empService.add(data);
    }
    @RequestMapping(value = "/del")
    public void del(int id){
        empService.del(id);
    }

    @RequestMapping(value = "/update",method =RequestMethod.POST)
    public void update(@RequestBody Emp data ) {
        empService.update(data);
    }

    @RequestMapping("/delAll")
    public void delAll(@RequestBody int[] records){
       empService.dellAll(records);
    }
}
