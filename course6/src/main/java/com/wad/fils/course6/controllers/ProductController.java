package com.wad.fils.course6.controllers;

import com.wad.fils.course6.domain.Product;
import com.wad.fils.course6.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public String listProducts(Model model){
    model.addAttribute("products",productService.findAll());
//    log.info(productService.findAll().toString());
    return "products";
  }

  @GetMapping("/new")
  public String showAddProductForm(Model model){
    model.addAttribute("product", new Product());
    return "addproducts";
  }

  @PostMapping("/new")
  public String addProduct(Product product){
    productService.save(product);
    return "redirect:/products";
  }
}
