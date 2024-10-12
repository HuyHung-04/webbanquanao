package com.example.asmj5.asm.repository;

import com.example.asmj5.asm.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    List<HoaDon> findByTrangThai(boolean trangThai);
    List<HoaDon> findByTrangThaiTrue();
}
