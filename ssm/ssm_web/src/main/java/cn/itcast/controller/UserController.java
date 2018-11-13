package cn.itcast.controller;

import cn.itcast.domain.Roles;
import cn.itcast.domain.UserInfo;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv =new ModelAndView();
        List<UserInfo> list = userService.findAll();
        mv.addObject("userList",list);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("save")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("show")
    public ModelAndView show(String id){
        ModelAndView mv =new ModelAndView();
        UserInfo userInfo = userService.show(id);
        mv.addObject("userInfo",userInfo);
        mv.setViewName("user-show");
        return mv;
    }
    @RequestMapping("findListUserByRole")
    //@RolesAllowed("ROLE_root")
//    @Secured("ROLE_root")
    @PreAuthorize("hasAnyRole('ROLE_root') and hasAnyAuthority('findAll')")
    public ModelAndView findListUserByRole(String userId) {
        List<Roles> rolesList = userService.findListUserByRole(userId);
        ModelAndView mv =new ModelAndView();
        mv.addObject("rolesList",rolesList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("userAddRole")
    @PreAuthorize("hasAnyRole('ROLE_root') and hasAnyAuthority('findAll')")
    public String userAddRole(String userId, @RequestParam(value = "idss[]") String[] idss, @RequestParam(value = "ids[]") String[] ids){
        userService.userAddRole(userId,idss,ids);
        return "redirect:findAll";

    }
}
