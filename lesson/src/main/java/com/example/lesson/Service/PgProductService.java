package com.example.lesson.Service;

import com.example.lesson.Product.Product;

import java.util.List;

public interface PgProductService {
    List<Product> findAll();

    Product findById(int id);

    public int insert(Product user);

    public int update(Product user);

    public int delete(int id);

}
