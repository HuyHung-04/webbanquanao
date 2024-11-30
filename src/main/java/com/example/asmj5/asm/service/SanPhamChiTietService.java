package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.SanPhamChiTiet;
import com.example.asmj5.asm.repository.SanPhamChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamChiTietService {
    @Autowired
    SanPhamChiTietRepository sanPhamChiTietRepository;
    public List<SanPhamChiTiet> getAll(){
        return sanPhamChiTietRepository.findAll();
    }

    public void add(SanPhamChiTiet sanPhamChiTiet){
        if(validateSanPhamChiTiet(sanPhamChiTiet)){
            sanPhamChiTietRepository.save(sanPhamChiTiet);
        }
    }

    private boolean validateSanPhamChiTiet(SanPhamChiTiet sanPhamChiTiet) {
        if(sanPhamChiTiet.getMa().equals("")){
            throw new IllegalArgumentException("Khong duoc de trong ma");
        }
        if (sanPhamChiTiet.getMa().length() > 20) {
            throw new IllegalArgumentException("Ma khong duoc nhap qua 20 ky tu");
        }
        if(sanPhamChiTiet.getSoLuong()<0){
            throw new IllegalArgumentException("So luong khong duoc nhap nho hon 0");
        }
        if(sanPhamChiTiet.getDonGia()<0){
            throw new IllegalArgumentException("Don gia khong duoc nhap nho hon 0");
        }if (sanPhamChiTiet.getSoLuong() >= 1000000000) {
            throw new IllegalArgumentException("So luong khong duoc nhap qua 1.000.000.000");
        }
        if (sanPhamChiTiet.getDonGia() >= 1000000000) {
            throw new IllegalArgumentException("Don gia khong duoc nhap qua 1.000.000.000");
        }
        if (!String.valueOf(sanPhamChiTiet.getSoLuong()).matches("[0-9]+")) {
            throw new IllegalArgumentException("So luong chi duoc chua so");
        }
        if (!String.valueOf(sanPhamChiTiet.getDonGia()).matches("[0-9]+")) {
            throw new IllegalArgumentException("Don gia chi duoc chua so");
        }
        return true;
    }

    public void update(SanPhamChiTiet sanPhamChiTiet){
        if(validateSanPhamChiTiet(sanPhamChiTiet)){
            sanPhamChiTietRepository.save(sanPhamChiTiet);
        }
    }

    public void delete(Integer id){
        sanPhamChiTietRepository.deleteById(id);
    }

    public SanPhamChiTiet findById(Integer id){
        return sanPhamChiTietRepository.findById(id).get();
    }

}
