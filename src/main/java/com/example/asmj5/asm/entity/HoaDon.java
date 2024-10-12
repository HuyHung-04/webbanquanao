package com.example.asmj5.asm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NgayMuaHang")
    private LocalDate ngayMuaHang;
    @Column(name = "TrangThai")
    private boolean trangThai;
    @ManyToOne
    @JoinColumn(name = "IdKhachHang", referencedColumnName = "Id")
    private KhachHang khachHang;
    @ManyToOne
    @JoinColumn(name = "IdNhanVien", referencedColumnName = "Id")
    private NhanVien nhanVien;
}
