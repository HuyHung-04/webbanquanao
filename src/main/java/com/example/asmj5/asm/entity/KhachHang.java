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
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "MaKhachHang")
    private String ma;
    @Column(name = "TenKhachHang")
    private String ten;
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "TrangThai")
    private boolean trangThai;
}
