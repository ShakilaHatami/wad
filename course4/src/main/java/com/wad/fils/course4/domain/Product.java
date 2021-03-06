package com.wad.fils.course4.domain;

public class Product {
  private Long id; // leaky abstraction! database details leak in the domain model
  private String name;
  private double price;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public Product(Long id, String name, double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", price=" + price +
            '}';
  }
}
