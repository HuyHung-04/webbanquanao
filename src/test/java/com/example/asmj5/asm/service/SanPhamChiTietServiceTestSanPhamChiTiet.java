package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.KichThuoc;
import com.example.asmj5.asm.entity.MauSac;
import com.example.asmj5.asm.entity.SanPham;
import com.example.asmj5.asm.entity.SanPhamChiTiet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SanPhamChiTietServiceTestSanPhamChiTiet {
    SanPhamChiTietService spcts;
    @BeforeEach
    void setUp() {
        spcts=new SanPhamChiTietService();
    }

    @AfterEach
    void tearDown() {
        spcts=null;
    }

    @Test
    void getAll() {

    }
    @Test
    void testThemHopLe() {
        SanPhamChiTiet spct=new SanPhamChiTiet(1,"spct1",12,20,true,new SanPham(),new MauSac(),new KichThuoc());
        spcts.add(spct);
        Assertions.assertEquals("spct1", spcts.getAll().get(1).getMa());
    }
    @Test
    void add() {
    }
    @Test
    void getAll_emptyList() {
        List<SanPhamChiTiet> result = spcts.getAll();
        assertNotNull(result, "Kết quả không được null");
        assertTrue(result.isEmpty(), "Danh sách phải rỗng");
    }
    @Test
    void addDeTrongMa() {
        SanPhamChiTiet spct=new SanPhamChiTiet(1,"",12,20,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.add(spct));
        Assertions.assertEquals("Khong duoc de trong ma", exception.getMessage());
    }
    @Test
    void addSoLuongNhoHon0() {
        SanPhamChiTiet spct=new SanPhamChiTiet(1,"spct1",-23,20,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.add(spct));
        Assertions.assertEquals("So luong khong duoc nhap nho hon 0", exception.getMessage());
    }
    @Test
    void addDonGiaNhoHon0() {
        SanPhamChiTiet spct=new SanPhamChiTiet(1,"spct1",22,-1,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.add(spct));
        Assertions.assertEquals("Don gia khong duoc nhap nho hon 0", exception.getMessage());
    }
    @Test
    void addDonGiaLonHon1000000000() {
        SanPhamChiTiet spct=new SanPhamChiTiet(1,"spct1",22,1200000000,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.add(spct));
        Assertions.assertEquals("Don gia khong duoc nhap qua 1.000.000.000", exception.getMessage());
    }
    @Test
    void addSoLuongLonHon1000000000() {
        SanPhamChiTiet spct=new SanPhamChiTiet(1,"spct1",1222222222,3000,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.add(spct));
        Assertions.assertEquals("So luong khong duoc nhap qua 1.000.000.000", exception.getMessage());
    }

    @Test
    void update() {
    }
    @Test
    void testSuaHopLe() {
        SanPhamChiTiet spct=new SanPhamChiTiet(1,"spct2",22,222,true,new SanPham(),new MauSac(),new KichThuoc());
        spcts.update(spct);
        Assertions.assertEquals("spct2", spcts.getAll().get(1).getMa());
    }
    @Test
    void updateDeTrongMa() {
        SanPhamChiTiet spct=new SanPhamChiTiet(2,"",22,22,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.update(spct));
        Assertions.assertEquals("Khong duoc de trong ma", exception.getMessage());
    }
    @Test
    void updateSoLuongNhoHon0() {
        SanPhamChiTiet spct=new SanPhamChiTiet(2,"spct2",-23,20,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.update(spct));
        Assertions.assertEquals("So luong khong duoc nhap nho hon 0", exception.getMessage());
    }
    @Test
    void updateDonGiaNhoHon0() {
        SanPhamChiTiet spct=new SanPhamChiTiet(2,"spct2",22,-1,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.update(spct));
        Assertions.assertEquals("Don gia khong duoc nhap nho hon 0", exception.getMessage());
    }
    @Test
    void updateDonGiaLonHon1000000000() {
        SanPhamChiTiet spct=new SanPhamChiTiet(2,"spct2",22,1200000000,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.update(spct));
        Assertions.assertEquals("Don gia khong duoc nhap qua 1.000.000.000", exception.getMessage());
    }
    @Test
    void updateSoLuongLonHon1000000000() {
        SanPhamChiTiet spct=new SanPhamChiTiet(2,"spct2",1222222222,3000,true,new SanPham(),new MauSac(),new KichThuoc());
        Exception exception=assertThrows(IllegalArgumentException.class, ()->spcts.update(spct));
        Assertions.assertEquals("So luong khong duoc nhap qua 1.000.000.000", exception.getMessage());
    }

    @Test
    void delete() {
        SanPhamChiTiet spct=new SanPhamChiTiet(2,"spct2",10,3000,true,new SanPham(),new MauSac(),new KichThuoc());
        spcts.add(spct);
        spcts.delete(2);
    }

    @Test
    void findById() {
        SanPhamChiTiet spct1=new SanPhamChiTiet(2,"spct2",10,3000,true,new SanPham(),new MauSac(),new KichThuoc());
        SanPhamChiTiet spct2=new SanPhamChiTiet(3,"spct4",24,252354,true,new SanPham(),new MauSac(),new KichThuoc());
        spcts.add(spct1);
        spcts.add(spct2);
        Assertions.assertEquals("spct4", spcts.findById(3).getMa());
    }
}