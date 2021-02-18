package com.springcloudt1.managerprovider.Controller;

import com.springcloudt1.managerprovider.service.DeptService;
import com.springcloudt1.managerapi.entity.Dept;
import com.springcloudt1.managerprovider.utils.RedisUtils;
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
        List data=deptService.check(name);
        return data;
    }

    @RequestMapping(value = "/show")
    public List show(){
        return deptService.show();
    }

   @RequestMapping(value = "/pager")
   public List pager(int pageNo,int pageSize){
       List data =  deptService.pager(pageNo,pageSize);
    return data;
   }

}
