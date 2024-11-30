package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.*;
import com.example.asmj5.asm.repository.SanPhamRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SanPhamServiceTestSanPham {
    SanPhamService ss;
    @BeforeEach
    void setUp() {
        ss=new SanPhamService();
    }

    @AfterEach
    void tearDown() {
        ss=null;
    }


    @Test
    void testThemHopLe() {
        SanPham s=new SanPham(1,"sp1","San pham A",true);
        ss.add(s);
        Assertions.assertEquals("sp1", ss.getAll().get(1).getMa());
    }

    @Test
    void addMaDeTrong(){
        SanPham s=new SanPham(1,"","San pham A",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.add(s));
        Assertions.assertEquals("Khong duoc de trong ma", exception.getMessage());
    }
    @Test
    void addTenDeTrong(){
        SanPham s=new SanPham(1,"sp1","",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.add(s));
        Assertions.assertEquals("Khong duoc de trong ten", exception.getMessage());
    }
    @Test
    void addMaVuotQua20KyTu(){
        String name50="a";
        for (int i = 1; i <=21; i++) {
            name50+="m";
        }

        SanPham s=new SanPham(1,name50,"San pham A",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.add(s));
        Assertions.assertEquals("Ma khong duoc nhap qua 20 ky tu", exception.getMessage());
    }
    @Test
    void addTenVuotQua20KyTu(){
        String name50="a";
        for (int i = 1; i <= 21; i++) {
            name50+="m";
        }
        SanPham s=new SanPham(1,"sp1",name50,true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.add(s));
        Assertions.assertEquals("Ten khong duoc nhap qua 20 ky tu", exception.getMessage());
    }@Test
    void addTenChuaSo(){
        SanPham s=new SanPham(1,"sp1","San pham A1",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.add(s));
        Assertions.assertEquals("Ten chi duoc chua chu", exception.getMessage());
    }
    @Test
    void addTenChuaKyTuDacBiet(){
        SanPham s=new SanPham(1,"sp1","San pham A!!!!!!!",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.add(s));
        Assertions.assertEquals("Ten chi duoc chua chu", exception.getMessage());
    }

    @Test
    void testSuaHopLe() {
        SanPham s=new SanPham(1,"sp1","San pham B",true);
        ss.update(s);
        Assertions.assertEquals("sp1", ss.getAll().get(1).getMa());
    }
    @Test
    void updateMaDeTrong(){
        SanPham s=new SanPham(22,"","San pham A",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.update(s));
        Assertions.assertEquals("Khong duoc de trong ma", exception.getMessage());
    }
    @Test
    void updateTenDeTrong(){
        SanPham s=new SanPham(22,"sp1","",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.update(s));
        Assertions.assertEquals("Khong duoc de trong ten", exception.getMessage());
    }
    @Test
    void updateMaVuotQua20KyTu(){
        String name50="a";
        for (int i = 1; i <=20; i++) {
            name50+="m";
        }

        SanPham s=new SanPham(22,name50,"San pham A",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.update(s));
        Assertions.assertEquals("Ma khong duoc nhap qua 20 ky tu", exception.getMessage());
    }
    @Test
    void updateTenVuotQua20KyTu(){
        String name50="a";
        for (int i = 1; i <= 22; i++) {
            name50+="m";
        }
        System.out.println(name50);
        SanPham s=new SanPham(22,"sp1",name50,true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.update(s));
        Assertions.assertEquals("Ten khong duoc nhap qua 20 ky tu", exception.getMessage());
    }@Test
    void updateTenChuaSo(){
        SanPham s=new SanPham(22,"sp1","San pham A1",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.update(s));
        Assertions.assertEquals("Ten chi duoc chua chu", exception.getMessage());
    }
    @Test
    void updateTenChuaKyTuDacBiet(){
        SanPham s=new SanPham(22,"sp1","San pham A!!!!!!!",true);
        Exception exception=assertThrows(IllegalArgumentException.class, ()->ss.update(s));
        Assertions.assertEquals("Ten chi duoc chua chu", exception.getMessage());
    }
    @Test
    void delete() {
        SanPham s=new SanPham(22,"sp1","San pham A",true);
        ss.add(s);
        ss.delete(22);
    }

    @Test
    void findById() {
        ss.add(new SanPham(222,"sp1","San pham A",true));
        ss.add(new SanPham(22,"sp2","San pham B",true));
        Assertions.assertEquals("sp2", ss.findById(22).getMa());
    }
}