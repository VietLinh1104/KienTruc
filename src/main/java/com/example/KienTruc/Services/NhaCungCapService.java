package com.example.KienTruc.Services;

import com.example.KienTruc.Models.NhaCungCap;
import com.example.KienTruc.Repository.NhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapService implements BaseService<NhaCungCap,Long>{
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;

    @Override
    public List<NhaCungCap> getAll() {
        return nhaCungCapRepository.findAll();
    }

    @Override
    public Optional<NhaCungCap> getById(Long id) {
        return nhaCungCapRepository.findById(id);
    }

    @Override
    public NhaCungCap save(NhaCungCap nhaCungCap) {
        return nhaCungCapRepository.save(nhaCungCap);
    }

    @Override
    public NhaCungCap update(Long id, NhaCungCap nhaCungCap) {
        Optional<NhaCungCap> existingNhaCungCap = nhaCungCapRepository.findById(id);
        if (existingNhaCungCap.isPresent()) {
            NhaCungCap updatedNhaCungCap = existingNhaCungCap.get();
            updatedNhaCungCap.setTenNhaCungCap(nhaCungCap.getTenNhaCungCap());
            return nhaCungCapRepository.save(updatedNhaCungCap);
        }
        throw new RuntimeException("Nhà cung cấp không tồn tại với id: " + id);
    }

    @Override
    public void delete(Long id) {
        if (nhaCungCapRepository.existsById(id)) {
            nhaCungCapRepository.deleteById(id);
        } else {
            throw new RuntimeException("Nhà cung cấp không tồn tại với id: " + id);
        }
    }
}
