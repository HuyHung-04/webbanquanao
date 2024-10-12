package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.HoaDon;
import com.example.asmj5.asm.entity.HoaDonChiTiet;
import com.example.asmj5.asm.repository.HoaDonChiTietRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;
    public List<HoaDonChiTiet> getAll(){
        return hoaDonChiTietRepository.findAll();
    }

    public void add(HoaDonChiTiet hoaDonChiTiet){
        hoaDonChiTietRepository.save(hoaDonChiTiet);
    }

    public HoaDonChiTiet findById(Integer id){
        return hoaDonChiTietRepository.findById(id).get();
    }

    public void delete(Integer id){
        hoaDonChiTietRepository.deleteById(id);
    }

    public List<HoaDonChiTiet> findByHoaDon(HoaDon hoaDon) {
        return hoaDonChiTietRepository.findByHoaDon(hoaDon);
    }

}
