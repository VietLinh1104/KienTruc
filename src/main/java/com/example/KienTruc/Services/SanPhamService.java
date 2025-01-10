package com.example.KienTruc.Services;

import com.example.KienTruc.Models.SanPham;
import com.example.KienTruc.Repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService implements BaseService<SanPham, Long>{
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Optional<SanPham> getById(Long id) {
        return sanPhamRepository.findById(id);
    }

    @Override
    public SanPham save(SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham update(Long id, SanPham sanPham) {
        Optional<SanPham> existingSanPham = sanPhamRepository.findById(id);
        if (existingSanPham.isPresent()) {
            SanPham updatedSanPham = existingSanPham.get();
            updatedSanPham.setTenSanPham(sanPham.getTenSanPham());
            updatedSanPham.setGia(sanPham.getGia());
            updatedSanPham.setSoLuong(sanPham.getSoLuong());
            return sanPhamRepository.save(updatedSanPham);
        }
        throw new RuntimeException("Sản phẩm không tồn tại với id: " + id);
    }

    @Override
    public void delete(Long id) {
        if (sanPhamRepository.existsById(id)) {
            sanPhamRepository.deleteById(id);
        } else {
            throw new RuntimeException("Sản phẩm không tồn tại với id: " + id);
        }
    }
}
