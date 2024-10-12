package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.KichThuoc;
import com.example.asmj5.asm.repository.KichThuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KichThuocService {
    @Autowired
    KichThuocRepository kichThuocRepository;
    public List<KichThuoc> getAll(){
        return kichThuocRepository.findAll();
    }

    public void add(KichThuoc kichThuoc){
        kichThuocRepository.save(kichThuoc);
    }

    public void update(KichThuoc kichThuoc){
        kichThuocRepository.save(kichThuoc);
    }

    public void delete(Integer id){
        kichThuocRepository.deleteById(id);
    }

    public KichThuoc findById(Integer id){
        return kichThuocRepository.findById(id).get();
    }
}
