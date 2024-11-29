package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.MauSac;
import com.example.asmj5.asm.repository.MauSacRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MauSacServiceTest {

    MauSacService mauSacService;
    MauSacRepository mauSacRepository;

    @BeforeEach
    void setUp() {
        mauSacService = new MauSacService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAdd_DayDu() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS01");
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertEquals("MS01", items.get(0).getMa());
        assertEquals("Đỏ", items.get(0).getTen());
        assertTrue(items.get(0).getTrangThai());
    }

    @Test
    void testAdd_KhongNhapGi() {
        assertThrows(IllegalArgumentException.class, () -> mauSacService.add(null));
    }

    @Test
    void testAdd_BoTrongMa() {
        MauSac mauSac = new MauSac();
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertNull(items.get(0).getMa());
        assertEquals("Đỏ", items.get(0).getTen());
        assertTrue(items.get(0).getTrangThai());
    }

    @Test
    void testAdd_BoTrongTen() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS001");

        mauSacService.add(mauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertEquals("MS001", items.get(0).getMa());
        assertNull(items.get(0).getTen());
        assertTrue(items.get(0).getTrangThai());
    }

    @Test
    void testAdd_MaDai() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS0123456789");
        mauSac.setTen("Đỏ ");

        mauSacService.add(mauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertEquals("MS0123456789", items.get(0).getMa());
        assertEquals("Đỏ", items.get(0).getTen());
    }

    @Test
    void testAdd_NhieuLan() {
        MauSac mauSac1 = new MauSac();
        mauSac1.setMa("MS01");
        mauSac1.setTen("Đỏ");

        MauSac mauSac2 = new MauSac();
        mauSac2.setMa("MS02");
        mauSac2.setTen("Xanh");

        mauSacService.add(mauSac1);
        mauSacService.add(mauSac2);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(2, items.size());
        assertEquals("MS001", items.get(0).getMa());
        assertEquals("MS002", items.get(1).getMa());
    }

    @Test
    void testAdd_TrungMa() {
        MauSac mauSac1 = new MauSac();
        mauSac1.setMa("MS001");
        mauSac1.setTen("Đỏ");

        MauSac mauSac2 = new MauSac();
        mauSac2.setMa("MS001");
        mauSac2.setTen("Xanh");

        mauSacService.add(mauSac1);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> mauSacService.add(mauSac2));
        assertEquals("Trung ma", exception.getMessage());
    }


    @Test
    void testAdd_BoTrongMaVaTen() {
        MauSac mauSac = new MauSac();

        mauSacService.add(mauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertNull(items.get(0).getMa());
        assertNull(items.get(0).getTen());
        assertTrue(items.get(0).getTrangThai());
    }

    @Test
    void testAdd_TenDai() {
        MauSac mauSac = new MauSac();
        mauSac.setMa("MS002");
        mauSac.setTen("Đỏ siêu đẹp và cực kỳ nổi bật nhất trong các loại màu đỏ");

        mauSacService.add(mauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertEquals("MS002", items.get(0).getMa());
        assertEquals("Đỏ siêu đẹp và cực kỳ nổi bật nhất trong các loại màu đỏ", items.get(0).getTen());
    }

    @Test
    void testAdd_BoTrongMa() {
        MauSac mauSac = new MauSac();
        mauSac.setTen("Đỏ");

        mauSacService.add(mauSac);

        List<MauSac> items = mauSacService.getItems();
        assertEquals(1, items.size());
        assertNull(items.get(0).getMa());
        assertEquals("Đỏ", items.get(0).getTen());
        assertTrue(items.get(0).getTrangThai());
    }
}