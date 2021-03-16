package com.wad.fils.course3.listeners;

import com.wad.fils.course3.domain.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.List;

public class ProductListener implements ServletContextListener {

  public ProductListener() {
  }

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    /* This method is called when the servlet context is initialized(when the Web application is deployed). */
    List<Product> products=List.of(
            new Product(1, "prodA", 12.5),
            new Product(2, "prodB", 25.3)
    );
    sce.getServletContext().setAttribute("products", products);

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
  }

}
