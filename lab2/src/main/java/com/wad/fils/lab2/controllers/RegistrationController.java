package com.wad.fils.lab2.controllers;


import com.wad.fils.lab2.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegistrationController", value = "/RegistrationController")
public class RegistrationController extends HttpServlet {
  private final UserService userService=new UserService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Registration Controller post method");
    response.setContentType("text/html;charset=UTF-8");
    /* TODO 3
    Change the format of the previous generated page so that it is similar to the register.html page (same header, navigation, footer, css).
    */
    try (PrintWriter out = response.getWriter()) {
       /* TODO 2
      In doPost method in RegistrationController the request is available in the variable request. Get all the parameter names using

request.getParameterNames() or
request.getParameterMap().keySet()
Iterate through the parameter names and for each name print in the response the value. The response should look like:

Parameter name has value George
Parameter username has value george
Parameter password has value pass
Parameter email has value g@ing.pub.ro
Parameter gender has value male
Parameter tel has value 123
Parameter country has value Romania
Parameter spam has value on */
      String username = request.getParameter("username");
      out.println(userService.userExists(username));
    }
  }
}
