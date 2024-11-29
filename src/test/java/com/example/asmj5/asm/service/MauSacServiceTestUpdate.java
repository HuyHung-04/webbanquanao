package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.MauSac;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MauSacServiceTestUpdate {

    MauSacService mauSacService;
    @BeforeEach
    void setUp() {
        mauSacService = new MauSacService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testUpdate_ThayDoiDayDu() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS01");
        updatedMauSac.setTen("Xanh");

        mauSacService.update("MS01", updatedMauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertEquals("MS01", items.get(0).getMa());
        assertEquals("Xanh", items.get(0).getTen());
    }

    @Test
    void testUpdate_KhongTimThayMa() {
        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS02");
        updatedMauSac.setTen("Xanh");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("MS02", updatedMauSac));
        assertEquals("Không tìm thấy mã cần cập nhật", exception.getMessage());
    }

    @Test
    void testUpdate_NullObject() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("MS01", null));
        assertEquals("Không thể cập nhật đối tượng null", exception.getMessage());
    }

    @Test
    void testUpdate_BoTrongTen() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS01");

        mauSacService.update("MS01", updatedMauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertEquals("MS01", items.get(0).getMa());
        assertNull(items.get(0).getTen());
    }

    @Test
    void testUpdate_TenQuaDai() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS01");
        updatedMauSac.setTen("Màu sắc rất dài và không hợp lệ do vượt quá giới hạn ký tự");

        mauSacService.update("MS01", updatedMauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertEquals("Màu sắc rất dài và không hợp lệ do vượt quá giới hạn ký tự", items.get(0).getTen());
    }

    @Test
    void testUpdate_BoTrongMa() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setTen("Xanh");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("", updatedMauSac));
        assertEquals("Mã không được để trống", exception.getMessage());
    }

    @Test
    void testUpdate_KhongThayDoi() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS01");
        updatedMauSac.setTen("Đỏ");

        mauSacService.update("MS01", updatedMauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertEquals("MS01", items.get(0).getMa());
        assertEquals("Đỏ", items.get(0).getTen());
    }

    @Test
    void testUpdate_ThayDoiTrangThai() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");
        mauSac.setTrangThai(true);

        mauSacService.add(mauSac);

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS01");
        updatedMauSac.setTen("Đỏ");
        updatedMauSac.setTrangThai(false);

        mauSacService.update("MS01", updatedMauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertFalse(items.get(0).getTrangThai());
    }

    @Test
    void testUpdate_DoiMaKhac() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        MauSac updatedMauSac = new MauSac();
        updatedMauSac.setMa("MS02");
        updatedMauSac.setTen("Xanh");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.update("MS01", updatedMauSac));
        assertEquals("Mã trong đối tượng không trùng khớp với mã cần cập nhật", exception.getMessage());
    }

    @Test
    void testUpdate_NhieuLan() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        MauSac updatedMauSac1 = new MauSac();
        updatedMauSac1.setMa("MS01");
        updatedMauSac1.setTen("Xanh");

        MauSac updatedMauSac2 = new MauSac();
        updatedMauSac2.setMa("MS01");
        updatedMauSac2.setTen("Vàng");

        mauSacService.update("MS01", updatedMauSac1);
        mauSacService.update("MS01", updatedMauSac2);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertEquals("Vàng", items.get(0).getTen());
    }

}