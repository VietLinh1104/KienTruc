package com.example.KienTruc.Repository;


import com.example.KienTruc.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
