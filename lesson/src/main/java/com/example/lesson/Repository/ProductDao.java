package com.example.lesson.Repository;

import com.example.lesson.Product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
;

@Repository // 追記
public class ProductDao implements PgProductDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query("SELECT * FROM products ORDER BY id",
                new DataClassRowMapper<>(Product.class));
    }

    @Override
    public  Product findById(int id) {
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = jdbcTemplate.query("SELECT * FROM products WHERE id = :id", param, new DataClassRowMapper<>(Product.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public int insert(Product user) {
        var param = new MapSqlParameterSource();
        param.addValue("name", user.name());
        param.addValue("price", user.price());
        return jdbcTemplate.update("INSERT INTO products (name,price) VALUES (:name, :price)", param);
    }

    @Override
    public int update(Product user) {
        var param = new MapSqlParameterSource();
        param.addValue("id", user.id());
        param.addValue("name", user.name());
        param.addValue("price", user.price());
        return jdbcTemplate.update("update products SET name = :name, price = :price WHERE id = :id", param);

    }
    @Override
    public int delete(int id){
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        return jdbcTemplate.update("delete FROM products WHERE id = :id", param);
    }



}