package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.KhachHang;
import com.example.asmj5.asm.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangService {
    @Autowired
    KhachHangRepository khachHangRepository;
    public List<KhachHang> getAll(){
        return khachHangRepository.findAll();
    }

    public void add(KhachHang khachHang){
        khachHangRepository.save(khachHang);
    }

    public void update(KhachHang khachHang){
        khachHangRepository.save(khachHang);
    }

    public void delete(Integer id){
        khachHangRepository.deleteById(id);
    }

    public KhachHang findById(Integer id){
       return khachHangRepository.findById(id).get();
    }
}
