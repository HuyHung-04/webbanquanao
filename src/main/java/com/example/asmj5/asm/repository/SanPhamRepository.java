package com.example.asmj5.asm.repository;

import com.example.asmj5.asm.entity.HoaDon;
import com.example.asmj5.asm.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    List<SanPham> findByTrangThai(boolean trangThai);
    List<SanPham> findByTrangThaiTrue();
}
