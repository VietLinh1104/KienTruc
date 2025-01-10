package com.example.KienTruc.Controller;

import com.example.KienTruc.Models.KhuyenMai;
import com.example.KienTruc.Services.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khuyenmai")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class KhuyenMaiController {

    @Autowired
    private KhuyenMaiService khuyenMaiService;

    // Lấy tất cả khuyến mãi
    @GetMapping("/get-all")
    public ResponseEntity<List<KhuyenMai>> getAllKhuyenMai() {
        List<KhuyenMai> khuyenMais = khuyenMaiService.getAll();
        return ResponseEntity.ok(khuyenMais);
    }

    // Lấy khuyến mãi theo ID
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<KhuyenMai> getKhuyenMaiById(@PathVariable Long id) {
        Optional<KhuyenMai> khuyenMai = khuyenMaiService.getById(id);
        return khuyenMai.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm mới khuyến mãi
    @PostMapping("/add")
    public ResponseEntity<KhuyenMai> createKhuyenMai(@RequestBody KhuyenMai khuyenMai) {
        KhuyenMai createdKhuyenMai = khuyenMaiService.save(khuyenMai);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKhuyenMai);
    }

    // Cập nhật khuyến mãi
    @PutMapping("/update/{id}")
    public ResponseEntity<KhuyenMai> updateKhuyenMai(@PathVariable Long id, @RequestBody KhuyenMai khuyenMai) {
        KhuyenMai updatedKhuyenMai = khuyenMaiService.update(id, khuyenMai);
        return ResponseEntity.ok(updatedKhuyenMai);
    }

    // Xóa khuyến mãi
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKhuyenMai(@PathVariable Long id) {
        khuyenMaiService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
