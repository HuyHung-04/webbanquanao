package com.example.asmj5.asm.repository;

import com.example.asmj5.asm.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    Optional<MauSac> findByMa(String ma);
}
