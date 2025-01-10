package com.example.KienTruc.Services;

import com.example.KienTruc.Models.DanhMuc;
import com.example.KienTruc.Repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DanhMucService implements BaseService<DanhMuc, Long>{
    @Autowired
    private DanhMucRepository danhMucRepository;

    @Override
    public List<DanhMuc> getAll() {
        return danhMucRepository.findAll();
    }

    @Override
    public Optional<DanhMuc> getById(Long id) {
        return danhMucRepository.findById(id);
    }

    @Override
    public DanhMuc save(DanhMuc danhMuc) {
        return danhMucRepository.save(danhMuc);
    }

    @Override
    public DanhMuc update(Long id, DanhMuc danhMuc) {
        Optional<DanhMuc> existingDanhMuc = danhMucRepository.findById(id);
        if (existingDanhMuc.isPresent()) {
            DanhMuc updatedDanhMuc = existingDanhMuc.get();
            updatedDanhMuc.setTenDanhMuc(danhMuc.getTenDanhMuc());
            return danhMucRepository.save(updatedDanhMuc);
        }
        throw new RuntimeException("Danh mục không tồn tại với id: " + id);
    }

    @Override
    public void delete(Long id) {
        if (danhMucRepository.existsById(id)) {
            danhMucRepository.deleteById(id);
        } else {
            throw new RuntimeException("Danh mục không tồn tại với id: " + id);
        }
    }
}
