package com.example.cafe.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.cafe.domain.Category;
import com.example.cafe.domain.Product;
import com.example.cafe.service.CategoryService;
import com.example.cafe.service.ProductService;

@Controller
@RequestMapping("manager")
public class ManagerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @GetMapping("index")
    public String index() {
        return "manager/index";
    }

    //	For Category--------------------------------------------------
    @GetMapping("CategoryList")
    public ModelAndView listCategory() {
        ModelAndView mv = new ModelAndView("manager/CategoryList");
        mv.addObject("categoryList", categoryService.listCategory());
        return mv;
    }

    @PostMapping("add-category")
    public ModelAndView addCategory(Category category) {
        ModelAndView mv = new ModelAndView("manager/CategoryList");
        categoryService.addCategory(category);
        mv.addObject("categoryList", categoryService.listCategory());
        return mv;
    }

    @GetMapping("delete-Category/{categoryId}")
    public ModelAndView deleteCategory(@PathVariable("categoryId")String categoryId) {
        ModelAndView mv = new ModelAndView("manager/CategoryList");
        categoryService.deleteCategory(Long.parseLong(categoryId));
        mv.addObject("categoryList", categoryService.listCategory());
        return mv;
    }

    @GetMapping("updateCategory/{categoryId}")
    public ModelAndView updateCategory(@PathVariable("categoryId")String categoryId) {
        ModelAndView mv = new ModelAndView("manager/updateCategory");
        mv.addObject("Category", categoryService.getCategory(Long.parseLong(categoryId)).get());
        return mv;
    }

    //	For Product--------------------------------------------------
    @GetMapping("ProductList")
    public ModelAndView listProduct() {
        ModelAndView mv = new ModelAndView("manager/ProductList");
        mv.addObject("categoryList", categoryService.listCategory());
        mv.addObject("productList", productService.listProduct());
        return mv;
    }

    @PostMapping("add-product")
    public ModelAndView addProduct(Product product) {
        ModelAndView mv = new ModelAndView("manager/ProductList");
        productService.addProduct(product);
        mv.addObject("productList", productService.listProduct());
        return mv;
    }

    @GetMapping("delete-Product/{productId}")
    public ModelAndView deleteProduct(@PathVariable("productId")String productId) {
        ModelAndView mv = new ModelAndView("manager/ProductList");
        productService.deleteProduct(Long.parseLong(productId));
        mv.addObject("productList", productService.listProduct());
        return mv;
    }

    @GetMapping("updateProduct/{productId}")
    public ModelAndView updateProduct(@PathVariable("productId")String productId) {
        ModelAndView mv = new ModelAndView("manager/updateProduct");
        mv.addObject("categoryList", categoryService.listCategory());
        mv.addObject("Product", productService.getProductById(Long.parseLong(productId)).get());
        return mv;
    }

}
