package com.example.KienTruc.Controller;

import com.example.KienTruc.Models.Product;
import com.example.KienTruc.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductController {

    @Autowired
    private ProductService productService;

    // API thêm sản phẩm mới
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product newProduct) {
        return productService.addProduct(newProduct);
    }

    // Lấy tất cả sản phẩm
    @GetMapping("/get-all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Lấy sản phẩm theo danh sách ID
    @PostMapping("/find-by-ids")
    public List<Product> findProductsByIds(@RequestBody List<Long> ids) {
        return productService.findByIds(ids);
    }

    // Cập nhật sản phẩm theo ID
    @PutMapping("/update/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product updatedProduct) {
        return productService.updateById(id, updatedProduct);
    }

    // Xóa nhiều sản phẩm theo danh sách ID
    @DeleteMapping("/delete")
    public void deleteProducts(@RequestBody List<Long> ids) {
        productService.deleteProductsByIds(ids);
    }
}
