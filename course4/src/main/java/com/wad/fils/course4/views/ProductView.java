package com.wad.fils.course4.views;

import com.wad.fils.course4.domain.Product;
import com.wad.fils.course4.services.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductView", value = "/ProductView")
public class ProductView extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");

    List<Product> products = (List<Product>) request.getAttribute("products");
    PrintWriter out = response.getWriter();
    out.println("<html><body>");
    out.println("<h1>Products</h1>");
    out.println("<table>");
    out.println("<tr>");
    out.println("<th>Name</th>");
    out.println("<th>Price</th>");
    out.println("</tr>");
    for(Product p : products){
      out.println("<tr>");
      out.println("<td>"+p.getName()+"</td>");
      out.println("<td>"+p.getPrice()+"</td>");
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("</body></html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
