package com.example.lesson.Controller;

import com.example.lesson.Service.ProductService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    ProductService productService;

    @GetMapping("product-list")
    public String productList(Model model) {
        // ロジックをServiceに任せる
        model.addAttribute("product", productService.findAll());
        return "product-list";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable("id") int id ,Model model) {
        model.addAttribute("products",productService.findById(id));
        return "product";
    }


}
