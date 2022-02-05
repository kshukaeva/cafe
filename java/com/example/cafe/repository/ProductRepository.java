package com.example.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cafe.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    public List<Product> findByCategory_CategoryId(long CategoryId);

}