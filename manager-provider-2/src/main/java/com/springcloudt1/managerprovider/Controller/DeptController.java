package com.springcloudt1.managerprovider.Controller;

import com.springcloudt1.managerapi.entity.Dept;
import com.springcloudt1.managerprovider.service.DeptService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Resource
    DeptService deptService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(@RequestBody Dept data){
        deptService.add(data);
    }

    @RequestMapping(value = "/del")
    public void del(int id){
        deptService.del(id);
    }

    @RequestMapping(value = "/update",method =RequestMethod.POST)
    public void update(@RequestBody Dept data){
        deptService.update(data);
    }

   @RequestMapping(value = "/delAll")
   public void delAll(@RequestBody int[] records){
           deptService.delAll(records);
   }

}
