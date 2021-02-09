package com.springcloudt1.managerprovider.Controller;


import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerprovider.utils.RedisUtils;
import com.springcloudt1.managerprovider.service.EmpService;
import com.springcloudt1.managerprovider.service.PermissionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emp")
public class EmpController {
    private String user_id="emp:id:";
    @Resource
    EmpService empService;
    @Resource
    PermissionService permissionService;
    @Resource
    RedisUtils redisUtils;

    @RequestMapping(value = "/add")
    public void add(@RequestBody Emp data){
        data.setPwd("111111");
        empService.add(data);
        System.out.println(data.getId());
        if (!redisUtils.hasKey(user_id + data.getId())) {
            redisUtils.set(user_id + data.getId(), data, 3600);
        }
    }
    @RequestMapping(value = "/del")
    public void del(int id){
        if(redisUtils.hasKey(user_id+id)){
            redisUtils.del(user_id+id);
        }
        empService.del(id);
    }

    @RequestMapping(value = "/loadRole")
    public List loadRole(){
        List roles;
        if(redisUtils.hasKey("roles")){
         roles =(List)redisUtils.get("roles");
        }else{
            roles = permissionService.initRoles();
            redisUtils.set("roles",roles,800);
        }

        return roles;
    }
    @RequestMapping(value = "/loadDept")
    public List loadDept(){
        List depts;
        if(redisUtils.hasKey("depts")){
                    depts=(List) redisUtils.get("depts");
                }else{
            depts =  empService.loadDept();
            redisUtils.set("depts",depts,800);
        }

       return depts;
    }
/*    @RequestMapping(value = "/{id}/load")
    public String load(@PathVariable int id,ModelMap modelMap){
       List depts =  empService.loadDept();
       modelMap.addAttribute("depts",depts);
       Emp record = empService.findById(id);
       modelMap.addAttribute("record",record);
       return "emp/modify";
    }
    */

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public void update(@RequestBody Emp data ){
        redisUtils.set(user_id + data.getId(), data, 3600);
        empService.update(data);
    }

    @RequestMapping("/search")
    public List search(String name){
        List data =  empService.search(name);
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
       for(int id : records){
           if(redisUtils.hasKey(user_id+id)){
               redisUtils.del(user_id+id);
           }
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
