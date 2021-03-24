package com.wad.fils.course4.controllers;

import com.wad.fils.course4.daos.JDBCProductDao;
import com.wad.fils.course4.domain.Product;
import com.wad.fils.course4.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/ProductController")
public class ProductController extends HttpServlet {
  private final ProductService productService = new ProductService();
  private final JDBCProductDao jDBCProductDao = new JDBCProductDao();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Product> products = productService.getProducts();
    request.setAttribute("products",products);
    request.getRequestDispatcher("ProductView").forward(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
