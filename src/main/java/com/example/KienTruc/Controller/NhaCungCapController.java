package com.example.KienTruc.Controller;

import com.example.KienTruc.Models.NhaCungCap;
import com.example.KienTruc.Services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nhacungcap")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class NhaCungCapController {

    @Autowired
    private NhaCungCapService nhaCungCapService;

    // Lấy tất cả nhà cung cấp
    @GetMapping("/get-all")
    public ResponseEntity<List<NhaCungCap>> getAllNhaCungCap() {
        List<NhaCungCap> nhaCungCaps = nhaCungCapService.getAll();
        return ResponseEntity.ok(nhaCungCaps);
    }

    // Lấy nhà cung cấp theo ID
    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<NhaCungCap> getNhaCungCapById(@PathVariable Long id) {
        Optional<NhaCungCap> nhaCungCap = nhaCungCapService.getById(id);
        return nhaCungCap.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm mới nhà cung cấp
    @PostMapping("/add")
    public ResponseEntity<NhaCungCap> createNhaCungCap(@RequestBody NhaCungCap nhaCungCap) {
        NhaCungCap createdNhaCungCap = nhaCungCapService.save(nhaCungCap);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNhaCungCap);
    }

    // Cập nhật nhà cung cấp
    @PutMapping("/update/{id}")
    public ResponseEntity<NhaCungCap> updateNhaCungCap(@PathVariable Long id, @RequestBody NhaCungCap nhaCungCap) {
        NhaCungCap updatedNhaCungCap = nhaCungCapService.update(id, nhaCungCap);
        return ResponseEntity.ok(updatedNhaCungCap);
    }

    // Xóa nhà cung cấp
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNhaCungCap(@PathVariable Long id) {
        nhaCungCapService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
