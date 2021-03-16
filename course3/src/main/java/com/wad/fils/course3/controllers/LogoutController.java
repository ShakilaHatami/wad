package com.wad.fils.course3.controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LogoutController extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getSession().setAttribute("user", null);
    request.getRequestDispatcher("HomeView").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
