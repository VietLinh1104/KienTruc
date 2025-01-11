package com.example.KienTruc.Controller;


import com.example.KienTruc.Models.Brand;
import com.example.KienTruc.Services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BrandController {

    @Autowired
    private BrandService brandService;

    // Lấy danh sách tất cả thương hiệu
    @GetMapping("/get-all")
    public List<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }

    // Lấy thương hiệu theo ID
    @GetMapping("/get-all-by-id/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable Long id) {
        return brandService.getBrandById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Thêm mới một thương hiệu
    @PostMapping("/add")
    public Brand createBrand(@RequestBody Brand brand) {
        return brandService.addBrand(brand);
    }

    // Cập nhật thông tin một thương hiệu
    @PutMapping("/update/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable Long id, @RequestBody Brand brandDetails) {
        return brandService.getBrandById(id)
                .map(existingBrand -> {
                    existingBrand.setName(brandDetails.getName());
                    return ResponseEntity.ok(brandService.addBrand(existingBrand));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Xóa một thương hiệu theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBrand(@PathVariable Long id) {
        return brandService.getBrandById(id)
                .map(brand -> {
                    brandService.deleteBrand(id);
                    return ResponseEntity.ok("Brand with ID " + id + " was deleted successfully.");
                })
                .orElseGet(() -> ResponseEntity.status(404).body("Brand with ID " + id + " not found."));
    }
}
