package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.MauSac;
import com.example.asmj5.asm.repository.MauSacRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MauSacServiceTestUpdate {
    private MauSacRepository mauSacRepository;
    private MauSacService mauSacService;

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
    void testUpdate_ThayDoiDayDu() {
        MauSac existingMauSac = new MauSac();
        existingMauSac.setMa("MS001");
        existingMauSac.setTen("Đỏ");

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS001");
        updatedMauSac.setTen("Xanh");

        when(mauSacRepository.findByMa("MS001")).thenReturn(Optional.of(existingMauSac));
        when(mauSacRepository.save(updatedMauSac)).thenReturn(updatedMauSac);

        assertDoesNotThrow(() -> mauSacService.update("MS001", updatedMauSac));
        verify(mauSacRepository).save(updatedMauSac);
    }


    @Test
    void testUpdate_NullObject() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("MS001", null));
        assertEquals("Không thể cập nhật đối tượng null", exception.getMessage());
    }

    @Test
    void testUpdate_BoTrongTen() {
        MauSac existingMauSac = new MauSac();
        existingMauSac.setMa("MS001");
        existingMauSac.setTen("Đỏ");

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS001");
        updatedMauSac.setTen("");

        when(mauSacRepository.findByMa("MS001")).thenReturn(Optional.of(existingMauSac));
        when(mauSacRepository.save(updatedMauSac)).thenReturn(updatedMauSac);

        assertDoesNotThrow(() -> mauSacService.update("MS001", updatedMauSac));
        verify(mauSacRepository).save(updatedMauSac);
    }

    @Test
    void testUpdate_TenQuaDai() {
        MauSac existingMauSac = new MauSac();
        existingMauSac.setMa("MS001");
        existingMauSac.setTen("Đỏ");

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS001");
        updatedMauSac.setTen("Tên rất dài vượt quá số ký tự cho phép");

        when(mauSacRepository.findByMa("MS001")).thenReturn(Optional.of(existingMauSac));
        when(mauSacRepository.save(updatedMauSac)).thenReturn(updatedMauSac);

        assertDoesNotThrow(() -> mauSacService.update("MS001", updatedMauSac));
        verify(mauSacRepository).save(updatedMauSac);
    }

    @Test
    void testUpdate_BoTrongMa() {
        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("");
        updatedMauSac.setTen("Xanh");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("", updatedMauSac));
        assertEquals("Mã không được để trống", exception.getMessage());
    }

    @Test
    void testUpdate_DoiMaKhac() {
        MauSac existingMauSac = new MauSac();
        existingMauSac.setMa("MS001");
        existingMauSac.setTen("Đỏ");

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS002");
        updatedMauSac.setTen("Xanh");

        when(mauSacRepository.findByMa("MS001")).thenReturn(Optional.of(existingMauSac));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("MS001", updatedMauSac));
        assertEquals("Mã trong đối tượng không trùng khớp với mã cần cập nhật", exception.getMessage());
    }

    @Test
    void testUpdate_TenMauSacNull() {
        MauSac existingMauSac = new MauSac();
        existingMauSac.setMa("MS001");
        existingMauSac.setTen("Đỏ");

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS001");

        when(mauSacRepository.findByMa("MS001")).thenReturn(Optional.of(existingMauSac));
        when(mauSacRepository.save(updatedMauSac)).thenReturn(updatedMauSac);

        assertDoesNotThrow(() -> mauSacService.update("MS001", updatedMauSac));
        verify(mauSacRepository).save(updatedMauSac);
    }

    @Test
    void testUpdate_MaQuaDai() {
        MauSac existingMauSac = new MauSac();
        existingMauSac.setMa("MS001");
        existingMauSac.setTen("Đỏ");

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("Mã dài vượt quá độ dài cho phép");
        updatedMauSac.setTen("Xanh");

        when(mauSacRepository.findByMa("MS001")).thenReturn(Optional.of(existingMauSac));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("MS001", updatedMauSac));
        assertEquals("Mã vượt quá độ dài cho phép", exception.getMessage());

        verify(mauSacRepository, never()).save(any(MauSac.class));
    }

    @Test
    void testUpdate_MaChuaKyTuDacBiet() {
        MauSac existingMauSac = new MauSac();
        existingMauSac.setMa("MS001");
        existingMauSac.setTen("Đỏ");

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS@001");
        updatedMauSac.setTen("Xanh");

        when(mauSacRepository.findByMa("MS001")).thenReturn(Optional.of(existingMauSac));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("MS001", updatedMauSac));
        assertEquals("Mã không được chứa ký tự đặc biệt", exception.getMessage());

        verify(mauSacRepository, never()).save(any(MauSac.class));
    }

    @Test
    void testUpdate_TenChuaKyTuDacBiet() {
        MauSac existingMauSac = new MauSac();
        existingMauSac.setMa("MS001");
        existingMauSac.setTen("Đỏ");

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS001");
        updatedMauSac.setTen("X@nh");

        when(mauSacRepository.findByMa("MS001")).thenReturn(Optional.of(existingMauSac));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("MS001", updatedMauSac));
        assertEquals("Tên không được chứa ký tự đặc biệt", exception.getMessage());

        verify(mauSacRepository, never()).save(any(MauSac.class));
    }


}
