package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.KichThuoc;
import com.example.asmj5.asm.repository.KichThuocRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KichThuocServiceTestUpdate {

     KichThuocRepository kichThuocRepository;
     KichThuocService kichThuocService;

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
    void testUpdate_ThayDoiDayDu() {
        KichThuoc existingKichThuoc = new KichThuoc();
        existingKichThuoc.setMa("KT001");
        existingKichThuoc.setTen("Nhỏ");

        KichThuoc updatedKichThuoc = new KichThuoc();
        updatedKichThuoc.setMa("KT001");
        updatedKichThuoc.setTen("Lớn");

        when(kichThuocRepository.findById(1)).thenReturn(Optional.of(existingKichThuoc));
        when(kichThuocRepository.save(updatedKichThuoc)).thenReturn(updatedKichThuoc);

        assertDoesNotThrow(() -> kichThuocService.update(updatedKichThuoc));
        verify(kichThuocRepository).save(updatedKichThuoc);
    }

    @Test
    void testUpdate_NullObject() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> kichThuocService.update(null));
        assertEquals("Không thể cập nhật đối tượng null", exception.getMessage());
    }

    @Test
    void testUpdate_BoTrongTen() {
        KichThuoc existingKichThuoc = new KichThuoc();
        existingKichThuoc.setMa("KT001");
        existingKichThuoc.setTen("Nhỏ");

        KichThuoc updatedKichThuoc = new KichThuoc();
        updatedKichThuoc.setMa("KT001");
        updatedKichThuoc.setTen("");

        when(kichThuocRepository.findById(1)).thenReturn(Optional.of(existingKichThuoc));
        when(kichThuocRepository.save(updatedKichThuoc)).thenReturn(updatedKichThuoc);

        assertDoesNotThrow(() -> kichThuocService.update(updatedKichThuoc));
        verify(kichThuocRepository).save(updatedKichThuoc);
    }

    @Test
    void testUpdate_MaQuaDai() {
        KichThuoc existingKichThuoc = new KichThuoc();
        existingKichThuoc.setMa("KT001");
        existingKichThuoc.setTen("Nhỏ");

        KichThuoc updatedKichThuoc = new KichThuoc();
        updatedKichThuoc.setMa("Mã rất dài vượt quá giới hạn cho phép");
        updatedKichThuoc.setTen("Lớn");

        when(kichThuocRepository.findById(1)).thenReturn(Optional.of(existingKichThuoc));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> kichThuocService.update(updatedKichThuoc));
        assertEquals("Mã vượt quá độ dài cho phép", exception.getMessage());

        verify(kichThuocRepository, never()).save(any(KichThuoc.class));
    }

    @Test
    void testUpdate_MaChuaKyTuDacBiet() {
        KichThuoc existingKichThuoc = new KichThuoc();
        existingKichThuoc.setMa("KT001");
        existingKichThuoc.setTen("Nhỏ");

        KichThuoc updatedKichThuoc = new KichThuoc();
        updatedKichThuoc.setMa("KT@001");
        updatedKichThuoc.setTen("Lớn");

        when(kichThuocRepository.findById(1)).thenReturn(Optional.of(existingKichThuoc));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> kichThuocService.update(updatedKichThuoc));
        assertEquals("Mã không được chứa ký tự đặc biệt", exception.getMessage());

        verify(kichThuocRepository, never()).save(any(KichThuoc.class));
    }

    @Test
    void testUpdate_TenChuaKyTuDacBiet() {
        KichThuoc existingKichThuoc = new KichThuoc();
        existingKichThuoc.setMa("KT001");
        existingKichThuoc.setTen("Nhỏ");

        KichThuoc updatedKichThuoc = new KichThuoc();
        updatedKichThuoc.setMa("KT001");
        updatedKichThuoc.setTen("Lớ@n");

        when(kichThuocRepository.findById(1)).thenReturn(Optional.of(existingKichThuoc));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> kichThuocService.update(updatedKichThuoc));
        assertEquals("Tên không được chứa ký tự đặc biệt", exception.getMessage());

        verify(kichThuocRepository, never()).save(any(KichThuoc.class));
    }

    @Test
    void testUpdate_TenNull() {
        KichThuoc existingKichThuoc = new KichThuoc();
        existingKichThuoc.setMa("KT001");
        existingKichThuoc.setTen("Nhỏ");

        KichThuoc updatedKichThuoc = new KichThuoc();
        updatedKichThuoc.setMa("KT001");

        when(kichThuocRepository.findById(1)).thenReturn(Optional.of(existingKichThuoc));
        when(kichThuocRepository.save(updatedKichThuoc)).thenReturn(updatedKichThuoc);

        assertDoesNotThrow(() -> kichThuocService.update(updatedKichThuoc));
        verify(kichThuocRepository).save(updatedKichThuoc);
    }
}