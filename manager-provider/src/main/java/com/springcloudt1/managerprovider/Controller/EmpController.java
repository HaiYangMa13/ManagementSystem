package com.springcloudt1.managerprovider.Controller;


import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerprovider.service.EmpService;
import com.springcloudt1.managerprovider.service.PermissionService;
import com.springcloudt1.managerprovider.utils.RedisUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {
    @Resource
    EmpService empService;
    @RequestMapping(value = "/loadRole")
    public List loadRole(){
        return empService.initRoles();
    }
    @RequestMapping(value = "/loadDept")
    public List loadDept(){
       return empService.loadDept();
    }

    @RequestMapping("/search")
    public List search(String name){
        return  empService.search(name);
    }
    @RequestMapping("/pager")
    public List pager(int pageNo,int pageSize){
      return empService.pager(pageNo,pageSize);
    }

    @RequestMapping("/count")
    public List count(){
      return empService.show();
    }
}
