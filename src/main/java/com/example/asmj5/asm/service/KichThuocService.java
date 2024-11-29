package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.KichThuoc;
import com.example.asmj5.asm.repository.KichThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KichThuocService {
    @Autowired
    private KichThuocRepository kichThuocRepository;

    public List<KichThuoc> getAll() {
        return kichThuocRepository.findAll();
    }

    public void add(KichThuoc kichThuoc) {
        validateKichThuoc(kichThuoc);
        kichThuocRepository.save(kichThuoc);
    }

    public void update(KichThuoc updatedKichThuoc) {
        if (updatedKichThuoc == null) {
            throw new IllegalArgumentException("Không thể cập nhật đối tượng null");
        }

        Optional<KichThuoc> optionalExisting = kichThuocRepository.findById(updatedKichThuoc.getId());
        if (optionalExisting.isEmpty()) {
            throw new IllegalArgumentException("Không tìm thấy kích thước với ID: " + updatedKichThuoc.getId());
        }

        validateKichThuoc(updatedKichThuoc);
        kichThuocRepository.save(updatedKichThuoc);
    }

    public void delete(Integer id) {
        if (!kichThuocRepository.existsById(id)) {
            throw new IllegalArgumentException("Không tìm thấy kích thước với ID: " + id);
        }
        kichThuocRepository.deleteById(id);
    }

    public KichThuoc findById(Integer id) {
        return kichThuocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy kích thước với ID: " + id));
    }

    private void validateKichThuoc(KichThuoc kichThuoc) {
        if (kichThuoc.getMa() == null || kichThuoc.getMa().trim().isEmpty()) {
            throw new IllegalArgumentException("Mã không được để trống");
        }

        if (kichThuoc.getMa().length() > 50) {
            throw new IllegalArgumentException("Mã vượt quá độ dài cho phép");
        }

        if (!kichThuoc.getMa().matches("^[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("Mã không được chứa ký tự đặc biệt");
        }

        if (kichThuoc.getTen() != null) {
            if (kichThuoc.getTen().length() > 100) {
                throw new IllegalArgumentException("Tên vượt quá độ dài cho phép");
            }

            if (!kichThuoc.getTen().matches("^[a-zA-Z0-9\\s]+$")) {
                throw new IllegalArgumentException("Tên không được chứa ký tự đặc biệt");
            }
        }
    }
}
