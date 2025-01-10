package com.example.KienTruc.Services;


import com.example.KienTruc.Models.Product;
import com.example.KienTruc.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
//

    // Thêm sản phẩm mới
    public Product addProduct(Product newProduct) {
        try {
            return productRepository.save(newProduct); // Lưu sản phẩm vào cơ sở dữ liệu
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding product");
        }
    }

    public List<Product> getAllProducts() {
        try {
            return productRepository.findAll(); // Kiểm tra để chắc chắn rằng findAll() hoạt động bình thường
        } catch (Exception e) {
            e.printStackTrace(); // Đảm bảo bạn log lỗi ra màn hình console nếu có
            throw new RuntimeException("Error retrieving products");
        }
    }

    // Thêm phương thức findByIds
    public List<Product> findByIds(List<Long> ids) {
        try {
            // Gọi phương thức từ ProductRepository (nếu chưa có, bạn cần thêm nó vào repository)
            return productRepository.findAllById(ids);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving products by IDs");
        }
    }

    //    Update
    public Product updateById(Long id, Product updatedProduct) {
        try {
            // Kiểm tra xem sản phẩm có tồn tại hay không
            if (productRepository.existsById(id)) {
                // Lấy sản phẩm hiện tại
                Product existingProduct = productRepository.findById(id).orElseThrow(() ->
                        new RuntimeException("Product not found with ID: " + id)
                );

                // Cập nhật thông tin sản phẩm
                existingProduct.setName(updatedProduct.getName());
                existingProduct.setPrice(updatedProduct.getPrice());
                existingProduct.setDescription(updatedProduct.getDescription());
                // Cập nhật thêm các trường khác nếu cần

                // Lưu sản phẩm đã cập nhật
                return productRepository.save(existingProduct);
            } else {
                throw new RuntimeException("Product not found with ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error updating product with ID: " + id);
        }
    }




    // Xóa nhiều sản phẩm theo danh sách ID
    public void deleteProductsByIds(List<Long> ids) {
        try {
            for (Long id : ids) {
                if (productRepository.existsById(id)) {
                    productRepository.deleteById(id);
                } else {
                    throw new RuntimeException("Product not found with ID: " + id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error deleting products");
        }
    }
}
