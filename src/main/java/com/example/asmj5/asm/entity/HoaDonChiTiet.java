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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "SoLuong")
    private int soLuong;
    @Column(name = "DonGia")
    private float donGia;
    @ManyToOne
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id")
    private HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name = "IdSanPhamChiTiet", referencedColumnName = "Id")
    private SanPhamChiTiet sanPhamChiTiet;
}
