package com.springcloudt1.managerconsumer.Controller;

import com.springcloudt1.managerapi.entity.Dept;
import com.springcloudt1.managerconsumer.Service.AddDeptService;
import com.springcloudt1.managerconsumer.Service.SelectDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    SelectDeptService selectDeptService;
    @Autowired
    AddDeptService adddeptService;
    @RequestMapping(value = "/{name}/search")
    public List search(@PathVariable  String name){
      return  selectDeptService.check(name);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(@RequestBody Dept data){
        adddeptService.add(data);
    }

    @RequestMapping(value = "/{id}/del")
    public void del(@PathVariable("id")int id){
        adddeptService.del(id);
    }

    @RequestMapping(value = "/update",method =RequestMethod.POST)
    public void update(@RequestBody Dept data){adddeptService.update(data);
    }
    @RequestMapping(value = "/show")
    public List show(){
     return selectDeptService.show();
    }
   @RequestMapping(value = "/delAll")
   public void delAll(@RequestBody int[] records){
            adddeptService.delAll(records);
   }
   @RequestMapping(value = "/pager")
   public List pager(int pageNo,int pageSize){
     return  selectDeptService.pager(pageNo,pageSize);
   }
}
