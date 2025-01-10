package com.example.KienTruc.Services;

import com.example.KienTruc.Models.KhuyenMai;
import com.example.KienTruc.Repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhuyenMaiService implements BaseService<KhuyenMai,Long>{
    @Autowired
    private KhuyenMaiRepository khuyenMaiRepository;

    @Override
    public List<KhuyenMai> getAll() {
        return khuyenMaiRepository.findAll();
    }

    @Override
    public Optional<KhuyenMai> getById(Long id) {
        return khuyenMaiRepository.findById(id);
    }

    @Override
    public KhuyenMai save(KhuyenMai khuyenMai) {
        return khuyenMaiRepository.save(khuyenMai);
    }

    @Override
    public KhuyenMai update(Long id, KhuyenMai khuyenMai) {
        Optional<KhuyenMai> existingKhuyenMai = khuyenMaiRepository.findById(id);
        if (existingKhuyenMai.isPresent()) {
            KhuyenMai updatedKhuyenMai = existingKhuyenMai.get();
            updatedKhuyenMai.setStartDate(khuyenMai.getStartDate());
            updatedKhuyenMai.setEndDate(khuyenMai.getEndDate());
            return khuyenMaiRepository.save(updatedKhuyenMai);
        }
        throw new RuntimeException("Khuyến mãi không tồn tại với id: " + id);
    }

    @Override
    public void delete(Long id) {
        if (khuyenMaiRepository.existsById(id)) {
            khuyenMaiRepository.deleteById(id);
        } else {
            throw new RuntimeException("Khuyến mãi không tồn tại với id: " + id);
        }
    }
}
