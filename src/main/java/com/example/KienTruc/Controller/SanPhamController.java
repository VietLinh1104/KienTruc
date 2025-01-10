package com.example.KienTruc.Controller;

import com.example.KienTruc.Models.SanPham;
import com.example.KienTruc.Services.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sanpham")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SanPhamController {

    @Autowired
    private SanPhamService sanPhamService;

    // Lấy tất cả sản phẩm
    @GetMapping("/get-all")
    public ResponseEntity<List<SanPham>> getAllSanPham() {
        List<SanPham> sanPhams = sanPhamService.getAll();
        return ResponseEntity.ok(sanPhams);
    }

    // Lấy sản phẩm theo ID
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<SanPham> getSanPhamById(@PathVariable Long id) {
        Optional<SanPham> sanPham = sanPhamService.getById(id);
        return sanPham.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm mới sản phẩm
    @PostMapping("/add")
    public ResponseEntity<SanPham> createSanPham(@RequestBody SanPham sanPham) {
        SanPham createdSanPham = sanPhamService.save(sanPham);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSanPham);
    }

    // Cập nhật sản phẩm
    @PutMapping("/update/{id}")
    public ResponseEntity<SanPham> updateSanPham(@PathVariable Long id, @RequestBody SanPham sanPham) {
        SanPham updatedSanPham = sanPhamService.update(id, sanPham);
        return ResponseEntity.ok(updatedSanPham);
    }

    // Xóa sản phẩm
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSanPham(@PathVariable Long id) {
        sanPhamService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
