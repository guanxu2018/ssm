package cn.itcast.controller;


import cn.itcast.domain.Roles;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("roles")
public class RolesController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("findAll")
    public ModelAndView findAll(){
        ModelAndView mv =new ModelAndView();
        List<Roles> rolesList = roleService.findAll();
        mv.addObject("rolesList",rolesList);
        mv.setViewName("roles-list");
        return mv;
    }

    @RequestMapping("save")
    public String save(Roles roles){
        roleService.save(roles);
        return "redirect:findAll";
    }

}
