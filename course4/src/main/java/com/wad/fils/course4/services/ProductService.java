package com.wad.fils.course4.services;

import com.wad.fils.course4.daos.JDBCProductDao;
import com.wad.fils.course4.domain.Product;

import java.util.List;

public class ProductService {
  //we will use injection in next iterations
  private final JDBCProductDao jdbcProductDao = new JDBCProductDao();

  public List<Product> getProducts(){
    return jdbcProductDao.getAll();
  }
}
