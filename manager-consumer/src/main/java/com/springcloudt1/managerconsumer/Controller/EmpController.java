package com.springcloudt1.managerconsumer.Controller;


import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerconsumer.Service.EmpService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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
    private final static String REST_URI_PRIFIX = "http://localhost:8888/";
    @Autowired
    EmpService empService;
    @RequestMapping(value = "/add")
    public void add(MultipartFile photo,Emp data,HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/images");
        String FileName = photo.getOriginalFilename();
        data.setPhotoname(FileName);
        try {
            File file = new File(path,FileName);
            FileUtils.copyInputStreamToFile(photo.getInputStream(),file);
        }catch (Exception e){
            e.printStackTrace();
        }
       empService.add(data);

    }
    @RequestMapping(value = "/{id}/del")
    public void del(@PathVariable int id){
        empService.del(id);
    }
    @RequestMapping(value = "loadRole")
    public List loadRole(){
        List roles = empService.loadRole();
        return roles;
    }
    @RequestMapping(value = "/loadDept")
    public List loadDept(){
       List depts =  empService.loadDept();
       return depts;
    }
    @RequestMapping(value = "/update",method =RequestMethod.POST)
    public void update(Emp data,MultipartFile photo,HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/images");
        String FileName = photo.getOriginalFilename();
        data.setPhotoname(FileName);
        try {
            File file = new File(path,FileName);
            FileUtils.copyInputStreamToFile(photo.getInputStream(),file);
        }catch (Exception e){
            e.printStackTrace();
        }
        empService.update(data);
    }
    @ResponseBody
    @RequestMapping("/{name}/search")
    public List search(@PathVariable String name){
        System.out.println(name);
     List data =  empService.search(name);
        return data;
    }
    @RequestMapping("/pager")
    public List pager(int pageNo,int pageSize){
        List all =  empService.pager((pageNo-1)*pageSize,pageSize);
      return  all;
    }
    @RequestMapping("/count")
    public List count(){
        List all =empService.count();
        return all;
    }
    @RequestMapping("/delAll")
    public void delAll(int[] records){
        System.out.println(records[0]);
        empService.delAll(records);

    }

    @RequestMapping("/show")
    public List show(){
    /*    PageHelper.startPage(pn,5);*/
        List all =empService.show();
        return all;
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
