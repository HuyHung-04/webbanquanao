package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.MauSac;
import com.example.asmj5.asm.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacService {
    @Autowired
    MauSacRepository mauSacRepository;
    public List<MauSac> getAll(){
        return mauSacRepository.findAll();
    }

    public void add(MauSac mauSac){
        mauSacRepository.save(mauSac);
    }

    public void update(MauSac mauSac){
        mauSacRepository.save(mauSac);
    }

    public void delete(Integer id){
        mauSacRepository.deleteById(id);
    }

    public MauSac findById(Integer id){
        return mauSacRepository.findById(id).get();
    }
}
