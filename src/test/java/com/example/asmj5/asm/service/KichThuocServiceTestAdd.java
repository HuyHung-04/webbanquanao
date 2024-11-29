package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.KichThuoc;
import com.example.asmj5.asm.repository.KichThuocRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KichThuocServiceTestAdd {
    private KichThuocService kichThuocService;
    private KichThuocRepository kichThuocRepository;

    @BeforeEach
    void setUp() {
        kichThuocRepository = mock(KichThuocRepository.class);
        kichThuocService = new KichThuocService();
    }

    @AfterEach
    void tearDown() {
        kichThuocService = null;
    }

    @Test
    void testAdd_KichThuocThanhCong() {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setMa("KT01");
        kichThuoc.setTen("Nhỏ");
        kichThuoc.setTrangThai(true);

        when(kichThuocRepository.findAll()).thenReturn(new ArrayList<>());

        assertDoesNotThrow(() -> kichThuocService.add(kichThuoc));
        verify(kichThuocRepository).save(kichThuoc);
    }

    @Test
    void testAdd_KichThuocNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            kichThuocService.add(null);
        });
        assertEquals("Không thể thêm đối tượng null", e.getMessage());
    }

    @Test
    void testAdd_BoTrongMa() {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setMa(null);
        kichThuoc.setTen("Nhỏ");
        kichThuoc.setTrangThai(true);

        when(kichThuocRepository.findAll()).thenReturn(new ArrayList<>());

        assertDoesNotThrow(() -> kichThuocService.add(kichThuoc));
        verify(kichThuocRepository).save(kichThuoc);
    }

    @Test
    void testAdd_BoTrongTen() {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setMa("KT01");
        kichThuoc.setTen(null);
        kichThuoc.setTrangThai(true);

        when(kichThuocRepository.findAll()).thenReturn(new ArrayList<>());

        assertDoesNotThrow(() -> kichThuocService.add(kichThuoc));
        verify(kichThuocRepository).save(kichThuoc);
    }

    @Test
    void testAdd_TrungMa() {
        KichThuoc kichThuoc1 = new KichThuoc();
        kichThuoc1.setMa("KT01");
        kichThuoc1.setTen("Nhỏ");
        kichThuoc1.setTrangThai(true);

        KichThuoc kichThuoc2 = new KichThuoc();
        kichThuoc2.setMa("KT01");
        kichThuoc2.setTen("Lớn");
        kichThuoc2.setTrangThai(true);

        when(kichThuocRepository.findAll()).thenReturn(List.of(kichThuoc1));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            kichThuocService.add(kichThuoc2);
        });
        assertEquals("Mã kích thước đã tồn tại", e.getMessage());
    }

    @Test
    void testAdd_TenQuaDai() {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setMa("KT01");
        kichThuoc.setTen("Tên rất dài vượt quá 100 ký tự");
        kichThuoc.setTrangThai(true);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            kichThuocService.add(kichThuoc);
        });
        assertEquals("Tên kích thước không được vượt quá 100 ký tự", e.getMessage());
    }

    @Test
    void testAdd_NhieuLan() {
        KichThuoc kichThuoc1 = new KichThuoc();
        kichThuoc1.setMa("KT01");
        kichThuoc1.setTen("Nhỏ");
        kichThuoc1.setTrangThai(true);

        KichThuoc kichThuoc2 = new KichThuoc();
        kichThuoc2.setMa("KT02");
        kichThuoc2.setTen("Lớn");
        kichThuoc2.setTrangThai(true);

        when(kichThuocRepository.findAll()).thenReturn(new ArrayList<>());

        kichThuocService.add(kichThuoc1);
        kichThuocService.add(kichThuoc2);

        verify(kichThuocRepository, times(1)).save(kichThuoc1);
        verify(kichThuocRepository, times(1)).save(kichThuoc2);
    }

    @Test
    void testAdd_MaQuaDai() {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setMa("Mã dài vượt quá giới hạn cho phép");
        kichThuoc.setTen("Nhỏ");
        kichThuoc.setTrangThai(true);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            kichThuocService.add(kichThuoc);
        });
        assertEquals("Mã kích thước không được vượt quá 50 ký tự", e.getMessage());
    }

}
