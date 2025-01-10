package com.example.KienTruc.Controller;

import com.example.KienTruc.Models.DanhMuc;
import com.example.KienTruc.Services.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/danhmuc")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class DanhMucController {

    @Autowired
    private DanhMucService danhMucService;

    // Lấy tất cả danh mục
    @GetMapping("/get-all")
    public ResponseEntity<List<DanhMuc>> getAllDanhMuc() {
        List<DanhMuc> danhMucs = danhMucService.getAll();
        return ResponseEntity.ok(danhMucs);
    }

    // Lấy danh mục theo ID
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<DanhMuc> getDanhMucById(@PathVariable Long id) {
        Optional<DanhMuc> danhMuc = danhMucService.getById(id);
        return danhMuc.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm mới danh mục
    @PostMapping("/add")
    public ResponseEntity<DanhMuc> createDanhMuc(@RequestBody DanhMuc danhMuc) {
        DanhMuc createdDanhMuc = danhMucService.save(danhMuc);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDanhMuc);
    }

    // Cập nhật danh mục
    @PutMapping("/update/{id}")
    public ResponseEntity<DanhMuc> updateDanhMuc(@PathVariable Long id, @RequestBody DanhMuc danhMuc) {
        DanhMuc updatedDanhMuc = danhMucService.update(id, danhMuc);
        return ResponseEntity.ok(updatedDanhMuc);
    }

    // Xóa danh mục
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDanhMuc(@PathVariable Long id) {
        danhMucService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
