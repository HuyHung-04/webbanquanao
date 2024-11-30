package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.SanPham;
import com.example.asmj5.asm.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;


    public List<SanPham> getAll(){
        return sanPhamRepository.findAll();
    }

    public void add(SanPham sanPham) {
        if(validateSanPham(sanPham)){
        sanPhamRepository.save(sanPham);
        }
    }

    private boolean validateSanPham(SanPham sanPham) {
        if(sanPham.getMa().equals("")){
            throw new IllegalArgumentException("Khong duoc de trong ma");
        }
        if (sanPham.getMa().length() > 20) {
            throw new IllegalArgumentException("Ma khong duoc nhap qua 20 ky tu");
        }
        if(sanPham.getTen().equals("")){
            throw new IllegalArgumentException("Khong duoc de trong ten");
        }
        if (sanPham.getTen().length() >= 20) {
            throw new IllegalArgumentException("Ten khong duoc nhap qua 20 ky tu");
        }
        if (!sanPham.getTen().matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException("Ten chi duoc chua chu");
        }

        return true;
    }

    public void update(SanPham sanPham){
        if(validateSanPham(sanPham)){
            sanPhamRepository.save(sanPham);
        }

    }

    public void delete(Integer id){
        sanPhamRepository.deleteById(id);
    }

    public SanPham findById(Integer id){
        return sanPhamRepository.findById(id).get();
    }
}
