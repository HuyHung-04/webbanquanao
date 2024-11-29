package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.MauSac;
import com.example.asmj5.asm.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    private boolean containsSpecialCharacters(String input) {
        return input != null && !input.matches("[a-zA-Z0-9 ]*"); // Chỉ cho phép chữ, số và khoảng trắng
    }

    public MauSac add(MauSac mauSac) {
        if (mauSac.getMa() == null || mauSac.getMa().isEmpty()) {
            throw new IllegalArgumentException("Mã màu không được để trống");
        }
        if (mauSacRepository.findByMa(mauSac.getMa()).isPresent()) {
            throw new IllegalArgumentException("Mã màu đã tồn tại");
        }
        return mauSacRepository.save(mauSac);
    }

    public MauSac update(String ma, MauSac updatedMauSac) {
        if (updatedMauSac == null) {
            throw new IllegalArgumentException("Không thể cập nhật đối tượng null");
        }
        if (ma == null || ma.isEmpty()) {
            throw new IllegalArgumentException("Mã không được để trống");
        }
        if (containsSpecialCharacters(ma) || containsSpecialCharacters(updatedMauSac.getTen())) {
            throw new IllegalArgumentException("Mã và tên không được chứa ký tự đặc biệt");
        }

        Optional<MauSac> existingMauSac = mauSacRepository.findByMa(ma);
        if (existingMauSac.isEmpty()) {
            throw new IllegalArgumentException("Không tìm thấy mã cần cập nhật");
        }

        if (!ma.equals(updatedMauSac.getMa())) {
            throw new IllegalArgumentException("Mã trong đối tượng không trùng khớp với mã cần cập nhật");
        }

        return mauSacRepository.save(updatedMauSac);
    }


    public List<MauSac> getItems() {
        return mauSacRepository.findAll();
    }

    public void delete(Integer id){
        mauSacRepository.deleteById(id);
    }

    public MauSac findById(Integer id){
        return mauSacRepository.findById(id).get();
    }
}
