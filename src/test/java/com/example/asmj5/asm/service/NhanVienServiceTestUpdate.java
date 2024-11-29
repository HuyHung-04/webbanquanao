package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.NhanVien;
import com.example.asmj5.asm.repository.NhanVienRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NhanVienServiceTestUpdate {
    private NhanVien nhanVien;
    private NhanVienService nhanVienService;
    private NhanVienRepository nhanVienRepository;
    @BeforeEach
    void setUp() {
        nhanVienRepository = mock(NhanVienRepository.class);
        nhanVienService = new NhanVienService(nhanVienRepository);
        nhanVien = new NhanVien();
    }

    @AfterEach
    void tearDown() {
        nhanVienService = null;
    }

    @Test
    void testUpdateNhanVienThanhCong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");

        when(nhanVienRepository.findAll()).thenReturn(new ArrayList<>());
        assertDoesNotThrow(() -> nhanVienService.update(nhanVien));
        verify(nhanVienRepository).save(nhanVien);
    }

    @Test
    void testUpdateNhanVienVoiMaTrong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.update(nhanVien);
        });
        assertEquals("Mã nhân viên không được để trống", e.getMessage());
    }

    @Test
    void testUpdateNhanVienVoiTenTrong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.update(nhanVien);
        });
        assertEquals("Tên nhân viên không được để trống", e.getMessage());
    }

    @Test
    void testUpdateNhanVienVoiTenDangNhapTrong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("");
        nhanVien.setMatKhau("12345678");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.update(nhanVien);
        });
        assertEquals("Tên đăng nhập không được để trống", e.getMessage());
    }

    @Test
    void testUpdateNhanVienVoiMatKhauTrong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.update(nhanVien);
        });
        assertEquals("Mật khẩu không được để trống", e.getMessage());
    }

    @Test
    void testUpdateNhanVienVoiMaTrung() {
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setMa("01");

        NhanVien nhanVien2 = new NhanVien();
        nhanVien2.setMa("01");

        when(nhanVienRepository.findAll()).thenReturn(List.of(nhanVien1));

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.update(nhanVien2);
        });
    }

    @Test
    void testUpdateNhanVienVoiMaVuotQua10KyTu() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("12345678901");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.update(nhanVien);
        });
        assertEquals("Mã nhân viên không được vượt quá 10 ký tự", e.getMessage());
    }

    @Test
    void testUpdateNhanVienVoiTenToanSo() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("123456");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.update(nhanVien);
        });
        assertEquals("Tên nhân viên không được chứa toàn bộ là số", e.getMessage());
    }

    @Test
    void testUpdateNhanVienVoiTenVuotQua50KyTu() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("hoanghoanghoanghoanghoanghoanghoanghoanghoanghoangh"); // 51 ký tự
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.update(nhanVien);
        });
        assertEquals("Tên nhân viên không được vượt quá 50 ký tự", e.getMessage());
    }

    @Test
    void testUpdateNhanVienVoiTenDangNhapVuotQua50KyTu() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("hoanghoanghoanghoanghoanghoanghoanghoanghoanghoangh"); // 51 ký tự
        nhanVien.setMatKhau("12345678");

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.update(nhanVien);
        });
        assertEquals("Tên đăng nhập không được vượt quá 50 ký tự", e.getMessage());
    }

}