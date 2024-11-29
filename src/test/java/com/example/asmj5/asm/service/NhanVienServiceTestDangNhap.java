package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.NhanVien;
import com.example.asmj5.asm.repository.NhanVienRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NhanVienServiceTestDangNhap {
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
    void testDangNhapThanhCong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");
        when(nhanVienRepository.findByTenDangNhap("hung")).thenReturn(Optional.of(nhanVien));
        NhanVien ketQua = nhanVienService.kiemTraDangNhap("hung", "12345678");
        assertNotNull(ketQua);
        assertEquals("hung", ketQua.getTenDangNhap());
    }

    @Test
    void testDangNhapTenDangNhapTrong() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.kiemTraDangNhap("", "12345678");
        });
        assertEquals("Tên đăng nhập không được để trống", e.getMessage());
    }

    @Test
    void testDangNhapMatKhauTrong() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.kiemTraDangNhap("hung", "");
        });
        assertEquals("Mật khẩu không được để trống", e.getMessage());
    }

    @Test
    void testDangNhapTenDangNhapSai() {
        when(nhanVienRepository.findByTenDangNhap("hung222")).thenReturn(Optional.empty());
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.kiemTraDangNhap("hung222", "12345678");
        });
        assertEquals("Tên đăng nhập hoặc mật khẩu không chính xác", e.getMessage());
    }

    @Test
    void testDangNhapMatKhauSai() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("123456789");
        when(nhanVienRepository.findByTenDangNhap("hung")).thenReturn(Optional.of(nhanVien));

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.kiemTraDangNhap("hung", "123456789");
        });
        assertEquals("Tên đăng nhập hoặc mật khẩu không chính xác", e.getMessage());
    }

    @Test
    void testDangNhapTenDangNhapChuaKyTuDacBiet() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTenDangNhap("hung@");
        nhanVien.setMatKhau("12345678");
        when(nhanVienRepository.findByTenDangNhap("hung@")).thenReturn(Optional.of(nhanVien));
        NhanVien ketQua = nhanVienService.kiemTraDangNhap("hung@", "12345678");
        assertNotNull(ketQua);
    }

    @Test
    void testDangNhapMatKhauChuaKyTuDacBiet() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("1234567@");
        when(nhanVienRepository.findByTenDangNhap("hung")).thenReturn(Optional.of(nhanVien));
        NhanVien ketQua = nhanVienService.kiemTraDangNhap("hung", "1234567@");
        assertNotNull(ketQua);
    }

    @Test
    void testDangNhapMatKhauChiChuaMotKyTu() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.kiemTraDangNhap("hung", "1");
        });
        assertEquals("Mật khẩu phải có độ dài từ 8 ký tự trở lên", e.getMessage());
    }

    @Test
    void testDangNhapMatKhauChua7KyTu() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.kiemTraDangNhap("hung", "1234567");
        });
        assertEquals("Mật khẩu phải có độ dài từ 8 ký tự trở lên", e.getMessage());
    }

    @Test
    void testDangNhapTenDangNhapChuaKhoangTrang() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.kiemTraDangNhap("hung @", "12345678");
        });
        assertEquals("Tên đăng nhập hoặc mật khẩu không chính xác", e.getMessage());
    }

}