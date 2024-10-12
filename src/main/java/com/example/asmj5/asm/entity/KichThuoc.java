package com.example.asmj5.asm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KichThuoc")
public class KichThuoc {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "MaKichThuoc")
    private String ma;
    @Column(name = "TenKichThuoc")
    private String ten;
    @Column(name = "TrangThai")
    private boolean trangThai;
}
