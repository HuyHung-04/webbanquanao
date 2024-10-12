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
        sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    public void update(SanPhamChiTiet sanPhamChiTiet){
        sanPhamChiTietRepository.save(sanPhamChiTiet);
    }

    public void delete(Integer id){
        sanPhamChiTietRepository.deleteById(id);
    }

    public SanPhamChiTiet findById(Integer id){
        return sanPhamChiTietRepository.findById(id).get();
    }

}
