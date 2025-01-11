package com.example.KienTruc.Repository;


import com.example.KienTruc.Models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    // Có thể thêm các phương thức tùy chỉnh nếu cần
}
