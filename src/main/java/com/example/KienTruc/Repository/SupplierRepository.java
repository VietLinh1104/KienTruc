package com.example.KienTruc.Repository;


import com.example.KienTruc.Models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    // Bạn có thể thêm các phương thức tìm kiếm theo yêu cầu
}