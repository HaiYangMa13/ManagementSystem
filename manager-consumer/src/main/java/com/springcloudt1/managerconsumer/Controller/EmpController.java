package com.springcloudt1.managerconsumer.Controller;


import com.springcloudt1.managerapi.entity.Emp;
import com.springcloudt1.managerconsumer.Service.AddEmpService;
import com.springcloudt1.managerconsumer.Service.SelectEmpService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {
    private final static String REST_URI_PRIFIX = "http://localhost:8888/";
    @Autowired
    SelectEmpService selectEmpService;
    @Autowired
    AddEmpService addEmpService;
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
       addEmpService.add(data);

    }
    @RequestMapping(value = "/{id}/del")
    public void del(@PathVariable int id){
        addEmpService.del(id);
    }
    @RequestMapping(value = "loadRole")
    public List loadRole(){
        List roles = selectEmpService.loadRole();
        return roles;
    }
    @RequestMapping(value = "/loadDept")
    public List loadDept(){
       List depts =  selectEmpService.loadDept();
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
        addEmpService.update(data);
    }
    @ResponseBody
    @RequestMapping("/{name}/search")
    public List search(@PathVariable String name){
     List data =  selectEmpService.search(name);
        return data;
    }
    @RequestMapping("/pager")
    public List pager(int pageNo,int pageSize){
        List all =  selectEmpService.pager((pageNo-1)*pageSize,pageSize);
      return  all;
    }
    @RequestMapping("/count")
    public List count(){
        List all = selectEmpService.count();
        return all;
    }
    @RequestMapping("/delAll")
    public void delAll(int[] records){
        addEmpService.delAll(records);
    }

}
