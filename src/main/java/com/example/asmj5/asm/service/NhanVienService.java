package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.NhanVien;
import com.example.asmj5.asm.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    NhanVienRepository nhanVienRepository;
    public List<NhanVien> getAll(){
        return nhanVienRepository.findAll();
    }

    public void add(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

    public void update(NhanVien nhanVien){
        nhanVienRepository.save(nhanVien);
    }

    public void delete(Integer id){
        nhanVienRepository.deleteById(id);
    }

    public NhanVien findById(Integer id){
        return nhanVienRepository.findById(id).get();
    }

    public NhanVien kiemTraDangNhap(String tenDangNhap, String matKhau) {
        Optional<NhanVien> nhanVien = nhanVienRepository.findByTenDangNhap(tenDangNhap);
        if (nhanVien.isPresent() && nhanVien.get().getMatKhau().equals(matKhau)) {
            return nhanVien.get();
        }
        return null;
    }

}
