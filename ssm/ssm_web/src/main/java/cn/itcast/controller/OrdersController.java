package cn.itcast.controller;

import cn.itcast.dao.OrdersDao;
import cn.itcast.domain.Orders;
import cn.itcast.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1") int pageNum ,@RequestParam(name = "pageSize",required = true,defaultValue = "4") int pageSize){
        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize);
        ModelAndView mv =new ModelAndView();
        PageInfo pageInfo = new PageInfo(ordersList,6);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id){
        Orders orders = ordersService.findById(id);
        ModelAndView mv =new ModelAndView();
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }

}
