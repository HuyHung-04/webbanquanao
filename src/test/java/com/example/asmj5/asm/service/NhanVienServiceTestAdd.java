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

class NhanVienServiceTestAdd {
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
    public void testAddNhanVienThanhCong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        when(nhanVienRepository.findAll()).thenReturn(new ArrayList<>());
        assertDoesNotThrow(() -> nhanVienService.add(nhanVien));
        verify(nhanVienRepository).save(nhanVien);
    }

    @Test
    void testAddNhanVienVoiMaTrong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.add(nhanVien);
        });
        assertEquals("Mã nhân viên không được để trống", e.getMessage());
    }

    @Test
    void testAddNhanVienVoiTenTrong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("02");
        nhanVien.setTen("");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.add(nhanVien);
        });
        assertEquals("Tên nhân viên không được để trống", e.getMessage());
    }

    @Test
    void testAddNhanVienVoiTenDangNhapTrong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("03");
        nhanVien.setTen("Hoang");
        nhanVien.setTenDangNhap("");
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.add(nhanVien);
        });
        assertEquals("Tên đăng nhập không được để trống", e.getMessage());
    }

    @Test
    void testAddNhanVienVoiMatKhauTrong() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("02");
        nhanVien.setTen("Hoang");
        nhanVien.setTenDangNhap("hoang");
        nhanVien.setMatKhau("");
        nhanVien.setTrangThai(true);
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.add(nhanVien);
        });
        assertEquals("Mật khẩu không được để trống", e.getMessage());
    }

    @Test
    void testAddNhanVienVoiMaTrung() {
        NhanVien nhanVien1 = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("Hoang");
        nhanVien.setTenDangNhap("hoang");
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        NhanVien nhanVien2 = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        when(nhanVienRepository.findAll()).thenReturn(List.of(nhanVien1));

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.add(nhanVien2);
        });
    }

    @Test
    void testAddNhanVienVoiMaVuotQua10KyTu() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("12345678901");
        nhanVien.setTen("Hung");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.add(nhanVien);
        });
        assertEquals("Mã nhân viên không được vượt quá 10 ký tự", e.getMessage());
    }

    @Test
    void testAddNhanVienVoiTenNhanVienToanBoLaSo() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("123456");
        nhanVien.setTenDangNhap("hung");
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.add(nhanVien);
        });
        assertEquals("Tên nhân viên không được chứa toàn bộ là số", e.getMessage());
    }

    @Test
    void testAddNhanVienVoiTenNhanVienVuotQua50KyTu() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("hoanghoanghoanghoanghoanghoanghoanghoanghoanghoangh");
        nhanVien.setTenDangNhap("hoang");
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.add(nhanVien);
        });
        assertEquals("Tên nhân viên không được vượt quá 50 ký tự", e.getMessage());
    }

    @Test
    void testAddNhanVienVoiTenDangNhapVuotQua50KyTu() {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMa("01");
        nhanVien.setTen("hoang");
        nhanVien.setTenDangNhap("hoanghoanghoanghoanghoanghoanghoanghoanghoanghoangh"); // 51 ký tự
        nhanVien.setMatKhau("12345678");
        nhanVien.setTrangThai(true);
        when(nhanVienRepository.findAll()).thenReturn(new ArrayList<>());

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> {
            nhanVienService.add(nhanVien);
        });

        assertEquals("Tên đăng nhập không được vượt quá 50 ký tự", e.getMessage());
    }


}