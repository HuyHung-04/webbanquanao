package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.MauSac;
import com.example.asmj5.asm.repository.MauSacRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MauSacServiceTestAdd {
    private MauSacService mauSacService;
    private MauSacRepository mauSacRepository;

    @BeforeEach
    void setUp() {
        mauSacRepository = mock(MauSacRepository.class);
        mauSacService = new MauSacService();
    }

    @AfterEach
    void tearDown() {
        mauSacService = null;
    }

    @Test
    void testAdd_MauSacThanhCong() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");
        mauSac.setTrangThai(true);

        when(mauSacRepository.findAll()).thenReturn(new ArrayList<>());

        assertDoesNotThrow(() -> mauSacService.add(mauSac));
        verify(mauSacRepository).save(mauSac);
    }

    @Test
    void testAdd_MauSacNull() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            mauSacService.add(null);
        });
        assertEquals("Không thể thêm đối tượng null", e.getMessage());
    }

    @Test
    void testAdd_BoTrongMa() {
        MauSac mauSac = new MauSac();
        mauSac.setMa(null);
        mauSac.setTen("Đỏ");
        mauSac.setTrangThai(true);

        when(mauSacRepository.findAll()).thenReturn(new ArrayList<>());

        assertDoesNotThrow(() -> mauSacService.add(mauSac));
        verify(mauSacRepository).save(mauSac);
    }

    @Test
    void testAdd_BoTrongTen() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen(null);
        mauSac.setTrangThai(true);

        when(mauSacRepository.findAll()).thenReturn(new ArrayList<>());

        assertDoesNotThrow(() -> mauSacService.add(mauSac));
        verify(mauSacRepository).save(mauSac);
    }

    @Test
    void testAdd_TrungMa() {
        MauSac mauSac1 = new MauSac();
        mauSac1.setMa("MS01");
        mauSac1.setTen("Đỏ");
        mauSac1.setTrangThai(true);

        MauSac mauSac2 = new MauSac();
        mauSac2.setMa("MS01");
        mauSac2.setTen("Xanh");
        mauSac2.setTrangThai(true);

        when(mauSacRepository.findAll()).thenReturn(List.of(mauSac1));

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            mauSacService.add(mauSac2);
        });
        assertEquals("Mã màu sắc đã tồn tại", e.getMessage());
    }

    @Test
    void testAdd_TenQuaDai() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Tên rất dài vượt quá 50 ký tự, tên này không được phép sử dụng trong hệ thống");
        mauSac.setTrangThai(true);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            mauSacService.add(mauSac);
        });
        assertEquals("Tên màu sắc không được vượt quá 50 ký tự", e.getMessage());
    }

    @Test
    void testAdd_NhieuLan() {
        MauSac mauSac1 = new MauSac();
        mauSac1.setMa("MS01");
        mauSac1.setTen("Đỏ");
        mauSac1.setTrangThai(true);

        MauSac mauSac2 = new MauSac();
        mauSac2.setMa("MS02");
        mauSac2.setTen("Xanh");
        mauSac2.setTrangThai(true);

        when(mauSacRepository.findAll()).thenReturn(new ArrayList<>());

        mauSacService.add(mauSac1);
        mauSacService.add(mauSac2);

        verify(mauSacRepository, times(1)).save(mauSac1);
        verify(mauSacRepository, times(1)).save(mauSac2);
    }
}
