package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.HoaDon;
import com.example.asmj5.asm.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;
    public List<HoaDon> getAll() {
        return hoaDonRepository.findByTrangThai(false);
    }

    public void add(HoaDon hoaDon){
        hoaDonRepository.save(hoaDon);
    }

    public void update(HoaDon hoaDon){
        hoaDonRepository.save(hoaDon);
    }

    public HoaDon findById(Integer idHoaDon){
      return hoaDonRepository.findById(idHoaDon).get();
    }

    public List<HoaDon> getAllDaThanhToan() {
        return hoaDonRepository.findByTrangThaiTrue();
    }
}

