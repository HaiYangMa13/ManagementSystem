package com.springcloudt1.managerprovider.Controller;

import com.springcloudt1.managerapi.entity.Dept;
import com.springcloudt1.managerprovider.utils.RedisUtils;
import com.springcloudt1.managerprovider.service.DeptService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
public class DeptController {
    private String user_id="dept:id:";
    @Resource
    DeptService deptService;
    @Resource
    RedisUtils redisUtils;

    @RequestMapping(value = "/search")
    public List search(String name){
        List data=deptService.check(name);
        return data;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void add(@RequestBody Dept data){
        deptService.add(data);
        if(!redisUtils.hasKey(user_id+data.getId())){
            redisUtils.set(user_id+data.getId(),data,3600);
        }
    }

    @RequestMapping(value = "/del")
    public void del(int id){
        if(redisUtils.hasKey(user_id+id)){
            redisUtils.del(user_id+id);
        }
        deptService.del(id);
    }

    @RequestMapping(value = "/load")
    public Dept load(int id){
        Dept record;
        if(redisUtils.hasKey(user_id+id)){
            record=(Dept)redisUtils.get(user_id+id);
        }else{
            record = deptService.load(id);
            redisUtils.set(user_id+id,record,3600);
        }

        //modelMap.addAttribute("record",record);
        return record;
    }


    @RequestMapping(value = "/update",method =RequestMethod.POST)
    public void update(@RequestBody Dept data){
        redisUtils.set(user_id+data.getId(),data,3600);
        deptService.update(data);
    }


    @RequestMapping(value = "/show")
    public List show(){
        return deptService.show();
    }
   @RequestMapping(value = "/delAll")
   public void delAll(@RequestBody int[] records){
        for (int id:records){
            if(redisUtils.hasKey(user_id+id)){
                redisUtils.del(user_id+id);
            }
            deptService.del(id);
        }

   }
   @RequestMapping(value = "/pager")
   public List pager(int pageNo,int pageSize){
     Map map = new HashMap();
       System.out.println(pageNo+""+pageSize);
     map.put("pageNo",(pageNo-1)*pageSize);
     map.put("pageSize",pageSize);
       List data =  deptService.pager(map);
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
