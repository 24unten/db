package com.example.lesson.Service;

import com.example.lesson.Product.Product;
import com.example.lesson.Repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements PgProductService{

        @Autowired
        private ProductDao userRepository;

        @Override
        public List<Product> findAll() {
            return userRepository.findAll();
        }

        @Override
        public Product findById(int id) {
                return userRepository.findById(id);
        }

        @Override
        public int insert(Product user) {
                return userRepository.insert(user);

        }

        @Override
        public int update(Product user) {
                return userRepository.update(user);

        }
        @Override
        public int delete(int id) {
                return userRepository.delete(id);

        }
}
