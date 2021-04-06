package com.wad.fils.course6.services;

import com.wad.fils.course6.domain.Product;

import java.util.List;

public interface ProductService {
  List<Product> findAll();
  void save(Product p);
}
