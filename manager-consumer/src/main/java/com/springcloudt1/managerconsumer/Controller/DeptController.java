package com.springcloudt1.managerconsumer.Controller;

import com.springcloudt1.managerapi.entity.Dept;
import com.springcloudt1.managerconsumer.Service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;

    @RequestMapping(value = "/{name}/search")
    public List search(@PathVariable  String name){
      return  deptService.check(name);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(@RequestBody Dept data){
        deptService.add(data);
    }

    @RequestMapping(value = "/{id}/del")
    public void del(@PathVariable("id")int id){
        deptService.del(id);
    }

    @RequestMapping(value = "/{id}/load")
    public Dept load(@PathVariable("id")int id){
        Dept record = deptService.load(id);
        //modelMap.addAttribute("record",record);
        return record;
    }


    @RequestMapping(value = "/update",method =RequestMethod.POST)
    public void update(@RequestBody Dept data){deptService.update(data);
    }


    @RequestMapping(value = "/show")
    public List show(){
        List all = deptService.show();
        return all;
    }
   @RequestMapping(value = "/delAll")
   public void delAll(@RequestBody int[] records){
        for (int id:records){
            deptService.del(id);
        }
   }
   @RequestMapping(value = "/pager")
   public List pager(int pageNo,int pageSize){
     return  deptService.pager(pageNo,pageSize);
   }
    @RequestMapping(value = "/check",produces = "text/html;charset=utf-8")
    public String check(String name){
        System.out.println(name);
        List data = deptService.check(name);
      if(data==null){
          return "yes";
      } else{
          return "no";
      }
    }
}
