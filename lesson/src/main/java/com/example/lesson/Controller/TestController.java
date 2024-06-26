package com.example.lesson.Controller;

import com.example.lesson.Product.Product;
import com.example.lesson.Service.ProductService;
import com.example.lesson.form.AddForm;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;


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

    @GetMapping("/product-add")
    public String index(@ModelAttribute("addForm" ) AddForm addForm){
        return "product-add";
    }

    @PostMapping("/product-add")
    public String add(@Validated @ModelAttribute("addForm" ) AddForm addForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/product-add";
        } else {
            productService.insert(new Product(-1, addForm.getName(),addForm.getPrice()));
            return  "redirect:/product-list";
        }

    }



}
