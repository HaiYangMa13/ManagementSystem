package com.springcloudt1.managerprovider.Controller;

import com.springcloudt1.managerprovider.service.PermissionService;
import com.springcloudt1.managerapi.entity.Roleinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/permission")
public class  PermissionController {
    @Resource
    PermissionService permissionService;
    @RequestMapping(value = "/init")
    String init(ModelMap modelMap){
     List roles=permissionService.initRoles();
     List rights =  permissionService.init();
     modelMap.addAttribute("rights",rights);
        modelMap.addAttribute("roles",roles);
     return "permission/init";
    }


    @RequestMapping(value = "/load")
 public String load(int roleid,ModelMap modelMap){
       Roleinfo roleinfo =permissionService.loadRole(roleid);
        List roles=permissionService.initRoles();
        List rights =  permissionService.init();
        modelMap.addAttribute("rights",rights);
        modelMap.addAttribute("roles",roles);
        Set permissions = roleinfo.getRights();
        modelMap.addAttribute("permissions",permissions);
        modelMap.addAttribute("roleinfo",roleinfo);
        return "permission/init";
    }

    @RequestMapping(value = "/grant")
    public String grant(int roleid,int[] rightid){
        Map map =new HashMap();
        Roleinfo roleinfo =permissionService.loadRole(roleid);
        roleinfo.getRights().clear();
        permissionService.clear(roleinfo.getId());
        for(int data:rightid){
            map.put("roleid",roleid);
            map.put("rightid",data);
            permissionService.grant(map);
        }
        return "permission/tip";
    }
}
