package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.NhanVien;
import com.example.asmj5.asm.repository.NhanVienRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NhanVienServiceTestTimKiem {
    private NhanVienService nhanVienService;
    private NhanVienRepository nhanVienRepository;
    @BeforeEach
    void setUp() {
        nhanVienRepository = mock(NhanVienRepository.class);
        nhanVienService = new NhanVienService(nhanVienRepository);
    }

    @AfterEach
    void tearDown() {
        nhanVienService = null;
    }

    @Test
    void testFindNhanVienDungVoiDuLieuTrongDatabase() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(1);
        nhanVien.setTen("Hung");
        when(nhanVienRepository.findById(1)).thenReturn(Optional.of(nhanVien));
        NhanVien ketQua = nhanVienService.findById("1");
        assertNotNull(ketQua);
        assertEquals("Hung", ketQua.getTen());
        verify(nhanVienRepository).findById(1);
    }

    @Test
    void testFindNhanVienSaiVoiDuLieuTrongDatabase() {
        when(nhanVienRepository.findById(99)).thenReturn(Optional.empty());
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.findById("99");
        });
        assertEquals("Không tìm thấy nhân viên với ID: 99", e.getMessage());
        verify(nhanVienRepository).findById(99);
    }

    @Test
    void testFindNhanVienVoiTruongThongTinNhapDeTrong() {
        Integer id = null;
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.findById("id");
        });
        assertEquals("ID chỉ được chứa số và không được chứa chữ hoặc ký tự đặc biệt", e.getMessage());
    }

    @Test
    void testFindNhanVienVoiIdBangAm1() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.findById("-1");
        });
        assertEquals("ID chỉ được chứa số và không được chứa chữ hoặc ký tự đặc biệt", e.getMessage());
        verify(nhanVienRepository, never()).findById(-1);
    }


    @Test
    void testFindNhanVienVoiIdBang0() {
        when(nhanVienRepository.findById(0)).thenReturn(Optional.empty());
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.findById("0");
        });
        assertEquals("Không tìm thấy nhân viên với ID: 0", e.getMessage());
        verify(nhanVienRepository).findById(0);
    }

    @Test
    void testFindNhanVienVoiIdLonNhatTrongKieuDuLieu() {
        int maxValue = Integer.MAX_VALUE;
        when(nhanVienRepository.findById(maxValue)).thenReturn(Optional.empty());
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.findById(String.valueOf(maxValue));
        });
        assertEquals("Không tìm thấy nhân viên với ID: " + maxValue, e.getMessage());
        verify(nhanVienRepository).findById(maxValue);
    }

    @Test
    void testFindNhanVienVoiIdNhoNhatTrongKieuDuLieu() {
        int minValue = Integer.MIN_VALUE;
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.findById(String.valueOf(minValue));
        });
        assertEquals("ID chỉ được chứa số và không được chứa chữ hoặc ký tự đặc biệt", e.getMessage());
    }



    @Test
    void testFindNhanVienVoiTrangThaiDaNghiLam() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(2);
        nhanVien.setTen("Hoang");
        nhanVien.setTrangThai(false);
        when(nhanVienRepository.findById(2)).thenReturn(Optional.of(nhanVien));
        NhanVien ketQua = nhanVienService.findById("2");
        assertNotNull(ketQua);
        assertFalse(ketQua.isTrangThai());
        assertEquals("Hoang", ketQua.getTen());
        verify(nhanVienRepository).findById(2);
    }

    @Test
    void testFindNhanVienVoiIdKhongPhaiLaSo() {
        String chuaChu = "aaaa";
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.findById(chuaChu);
        });
        assertEquals("ID chỉ được chứa số và không được chứa chữ hoặc ký tự đặc biệt", e.getMessage());
    }

    @Test
    void testFindNhanVienVoiIdChuaKyTuDacBiet() {
        String kiTu = "####";
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.findById(kiTu);
        });
        assertEquals("ID chỉ được chứa số và không được chứa chữ hoặc ký tự đặc biệt", e.getMessage());
    }


}