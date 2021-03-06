package cn.itcast.controller;

import cn.itcast.domain.Permission;
import cn.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;
    @RequestMapping("findAll")
    public ModelAndView findAll(){
        List<Permission> permissionList = permissionService.findAll();
        ModelAndView mv =new ModelAndView();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("save")
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:findAll" ;
    }
}
