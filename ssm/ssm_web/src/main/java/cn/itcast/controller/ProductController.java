package cn.itcast.controller;

import cn.itcast.service.ProductService;
import cn.itcast.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Product> productList = productService.findAll();
        mv.addObject("productList",productList);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/saveProduct")
    public String saveProduct(Product product){
        System.out.println(product);
        productService.saveProduct(product);
        return "redirect:findAll";
    }
}
