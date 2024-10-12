package com.example.asmj5.asm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SanPhamChiTiet")
public class SanPhamChiTiet {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "MaSanPhamChiTiet")
    private String ma;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private float donGia;
    @Column(name = "TrangThai")
    private boolean trangThai;
    @ManyToOne
    @JoinColumn(name = "IdSanPham", referencedColumnName = "Id")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name = "IdKichThuoc", referencedColumnName = "Id")
    private KichThuoc kichThuoc;
}
