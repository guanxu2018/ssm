package cn.itcast.controller;

import cn.itcast.domain.SysLog;
import cn.itcast.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("sysLog")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;
    @RequestMapping("findAll")
    public ModelAndView findAll(){
        List<SysLog> sysLogList = sysLogService.findAll();
        ModelAndView mv =new ModelAndView();
        mv.addObject("sysLogList",sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }
}
