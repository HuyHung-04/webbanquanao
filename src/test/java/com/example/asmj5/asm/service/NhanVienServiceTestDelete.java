package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.NhanVien;
import com.example.asmj5.asm.repository.NhanVienRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NhanVienServiceTestDelete {
    private NhanVienRepository nhanVienRepository;
    private NhanVienService nhanVienService;

    @BeforeEach
    void setUp() {
        nhanVienRepository = mock(NhanVienRepository.class);
        nhanVienService = new NhanVienService(nhanVienRepository);
    }

    @Test
    void testXoaNhanVienTonTai() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(1);
        when(nhanVienRepository.findById(1)).thenReturn(Optional.of(nhanVien));
        nhanVienService.delete(1);
        verify(nhanVienRepository).deleteById(1);
    }


    @Test
    void testXoaNhanVienKhongTonTai() {
        when(nhanVienRepository.findById(2)).thenReturn(Optional.empty());
        nhanVienService.delete(2);
        verify(nhanVienRepository).deleteById(2);
    }

    @Test
    void testXoaNhanVienIdTrong() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.delete(null);
        });
        assertEquals("ID trống", e.getMessage());
    }

    @Test
    void testXoaNhanVienIdAm1() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.delete(-1);
        });
        assertEquals("ID âm", e.getMessage());
    }

    @Test
    void testTimNhanVienIdBang0() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.delete(0);
        });
        assertEquals("ID âm", e.getMessage());
    }


    @Test
    void testXoaNhanVienIdLonNhat() {
        int maxId = Integer.MAX_VALUE;
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(maxId);
        when(nhanVienRepository.findById(maxId)).thenReturn(Optional.of(nhanVien));
        nhanVienService.delete(maxId);
        verify(nhanVienRepository).deleteById(maxId);
    }

    @Test
    void testXoaNhanVienIdNhoNhat() {
        Integer minId = Integer.MIN_VALUE;
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.delete(minId);
        });
        assertEquals("ID âm", e.getMessage());
    }

    @Test
    void testXoaNhanVienDaNghiLam() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(2);
        when(nhanVienRepository.findById(2)).thenReturn(Optional.of(nhanVien));
        nhanVienService.delete(2);

        verify(nhanVienRepository).deleteById(2);
    }
    @Test
    void testXoaNhanVienIdKhongPhaiLaSo() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.delete(Integer.valueOf("aaaa"));
        });
        assertEquals("ID không phải là số", e.getMessage());
    }

    @Test
    void testXoaNhanVienIdChuaKyTuDacBiet() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.delete(Integer.valueOf("#####"));
        });
        assertEquals("ID chứa ký tự đặc biệt.", e.getMessage());
    }

}