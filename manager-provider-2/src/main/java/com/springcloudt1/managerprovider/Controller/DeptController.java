package com.springcloudt1.managerprovider.Controller;

import com.springcloudt1.managerprovider.service.DeptService;
import com.springcloudt1.managerapi.entity.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Resource
    DeptService deptService;

    @RequestMapping(value = "/search")
    public List search(String name){
      return  deptService.check(name);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(@RequestBody Dept data){
        deptService.add(data);
    }

    @RequestMapping(value = "/del")
    public void del(int id){
        deptService.del(id);
    }

    @RequestMapping(value = "/load")
    public Dept load(int id){
        Dept record = deptService.load(id);
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
     Map map = new HashMap();
       System.out.println(pageNo+""+pageSize);
     map.put("pageNo",(pageNo-1)*pageSize);
     map.put("pageSize",pageSize);
     List data =   deptService.pager(map);
       System.out.println(data);
       return data;
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
