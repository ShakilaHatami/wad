package com.wad.fils.course3.view;

import com.wad.fils.course3.domain.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProductView extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title> ViewProducts</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<table>");
      out.println("<tr><th>Name</th><th>Price</th></tr>");
      List<Product> products = (List<Product>) getServletContext().getAttribute("products");
      for (Product p : products) {
        out.println("<tr>");
        out.println("<td>" + p.getName() + "</td>");
        out.println("<td>" + p.getPrice() + "</td>");
        out.println("</tr>");
      }
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");


    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
