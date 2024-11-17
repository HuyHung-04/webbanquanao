package com.example.asmj5.asm.repository;

import com.example.asmj5.asm.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    Optional<NhanVien> findByTenDangNhap(String tenDangNhap);
}
