package com.springcloudt1.managerprovider.Controller;


import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerprovider.service.EmpService;
import com.springcloudt1.managerprovider.service.PermissionService;
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
    @Resource
    PermissionService permissionService;

    @RequestMapping(value = "/add")
    public void add(@RequestBody Emp data){
        data.setPwd("111111");
        empService.add(data);
    }
    @RequestMapping(value = "/del")
    public void del(int id){
        empService.del(id);
    }

    @RequestMapping(value = "/loadRole")
    public List loadRole(){
        List roles = permissionService.initRoles();
        return roles;
    }
    @RequestMapping(value = "/loadDept")
    public List loadDept(){
       List depts =  empService.loadDept();
       return depts;
    }
    @RequestMapping(value = "/{id}/load")
    public String load(@PathVariable int id,ModelMap modelMap){
       List depts =  empService.loadDept();
       modelMap.addAttribute("depts",depts);
       Emp record = empService.findById(id);
       modelMap.addAttribute("record",record);
       return "emp/modify";
    }
    @RequestMapping(value = "/update",method =RequestMethod.POST)
    public void update(@RequestBody Emp data ){
        empService.update(data);
    }

    @RequestMapping("/search")
    public List search(String name){
        List data =  empService.search(name);
        System.out.println(name);
        System.out.println(data);
        return data;
    }
    @RequestMapping("/pager")
    public List pager(int pageNo,int pageSize){
        Map map = new HashMap();
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
      return empService.pager(map);
    }

    @RequestMapping("/delAll")
    public void delAll(@RequestBody int[] records){
        System.out.println(records[0]);
       for(int id : records){
           empService.del(id);
       }
    }

    @RequestMapping("/count")
    public List count(){
        List all = empService.show();
        return all;
    }

    @RequestMapping("/show")
    public List show(){
    /*    PageHelper.startPage(pn,5);*/
        List all = empService.show();
        throw new RuntimeException();
       /* PageInfo page = new PageInfo(all);
        modelMap.addAttribute("page",page);*/
        /* Pagination pager = new Pagination();
        Map map = new HashMap();
        int no =(index==null?1:index);
        int pageSize = 5;
        int pageNo =(no-1)*pageSize;
        int record = empService.countId();
        map.put("pageNo",pageNo);
        map.put("pageSize",pageSize);
        List all = empService.pager(map);
        pager.setData(all);
        pager.setIndex(no);
        pager.setPageSize(pageSize);
        pager.setTotal(record);
        pager.setPath("show?");
        modelMap.addAttribute("pager",pager);*/
    }
}
