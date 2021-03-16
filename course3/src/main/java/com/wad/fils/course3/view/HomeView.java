package com.wad.fils.course3.view;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeView extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);
  }

  protected void processRequest(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Home</title>");
      out.println("</head>");
      out.println("<body>");
      String user="GUEST";
      boolean logged=false;
      if(request.getSession(false) != null && request.getSession().getAttribute("user")!=null){
        user=(String) request.getSession().getAttribute("user");
        logged=true;}
      out.println("<h1>Hello " + user + "</h1>");
      if(logged)
        out.println("<a href=\"LogoutController\">Logout</a>");
      else
        out.println("<a href=\"login.html\">Login</a>");
      out.println("</body>");
      out.println("</html>");
    }


  }

}
