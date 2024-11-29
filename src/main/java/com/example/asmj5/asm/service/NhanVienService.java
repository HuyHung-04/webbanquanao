package com.example.asmj5.asm.service;

import com.example.asmj5.asm.entity.NhanVien;
import com.example.asmj5.asm.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    NhanVienRepository nhanVienRepository;

    public NhanVienService(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;
    }

    public List<NhanVien> getAll(){
        return nhanVienRepository.findAll();
    }
    public void add(NhanVien nhanVien) {
        if (nhanVien.getMa() == null || nhanVien.getMa().trim().isEmpty()) {
            throw new ArithmeticException("Mã nhân viên không được để trống");
        }
        if (nhanVien.getTen() == null || nhanVien.getTen().trim().isEmpty()) {
            throw new ArithmeticException("Tên nhân viên không được để trống");
        }
        if (nhanVien.getTenDangNhap() == null || nhanVien.getTenDangNhap().trim().isEmpty()) {
            throw new ArithmeticException("Tên đăng nhập không được để trống");
        }
        if (nhanVien.getMatKhau() == null || nhanVien.getMatKhau().trim().isEmpty()) {
            throw new ArithmeticException("Mật khẩu không được để trống");
        }
        if (nhanVienRepository.findAll().stream().anyMatch(nv -> nv.getMa().equals(nhanVien.getMa()))) {
            throw new ArithmeticException("Mã nhân viên đã tồn tại");
        }
        if (nhanVien.getMa().length() > 10) {
            throw new ArithmeticException("Mã nhân viên không được vượt quá 10 ký tự");
        }
        if (nhanVien.getTen().matches("\\d+")) {
            throw new ArithmeticException("Tên nhân viên không được chứa toàn bộ là số");
        }
        if (nhanVien.getTen().length() > 50) {
            throw new ArithmeticException("Tên nhân viên không được vượt quá 50 ký tự");
        }
        if (nhanVien.getTenDangNhap().length() > 50) {
            throw new ArithmeticException("Tên đăng nhập không được vượt quá 50 ký tự");
        }
        nhanVienRepository.save(nhanVien);
    }


    public void update(NhanVien nhanVien){
        if (nhanVien.getMa() == null || nhanVien.getMa().trim().isEmpty()) {
            throw new ArithmeticException("Mã nhân viên không được để trống");
        }
        if (nhanVien.getTen() == null || nhanVien.getTen().trim().isEmpty()) {
            throw new ArithmeticException("Tên nhân viên không được để trống");
        }
        if (nhanVien.getTenDangNhap() == null || nhanVien.getTenDangNhap().trim().isEmpty()) {
            throw new ArithmeticException("Tên đăng nhập không được để trống");
        }
        if (nhanVien.getMatKhau() == null || nhanVien.getMatKhau().trim().isEmpty()) {
            throw new ArithmeticException("Mật khẩu không được để trống");
        }
        if (nhanVienRepository.findAll().stream().anyMatch(nv -> nv.getMa().equals(nhanVien.getMa()))) {
            throw new ArithmeticException("Mã nhân viên đã tồn tại");
        }
        if (nhanVien.getMa().length() > 10) {
            throw new ArithmeticException("Mã nhân viên không được vượt quá 10 ký tự");
        }
        if (nhanVien.getTen().matches("\\d+")) {
            throw new ArithmeticException("Tên nhân viên không được chứa toàn bộ là số");
        }
        if (nhanVien.getTen().length() > 50) {
            throw new ArithmeticException("Tên nhân viên không được vượt quá 50 ký tự");
        }
        if (nhanVien.getTenDangNhap().length() > 50) {
            throw new ArithmeticException("Tên đăng nhập không được vượt quá 50 ký tự");
        }
        nhanVienRepository.save(nhanVien);
    }

    public void delete(Integer id) {
        if (id == null) {
            throw new ArithmeticException("ID trống");
        }
        if (id <= 0) {
            throw new ArithmeticException("ID âm");
        }
        if (id.toString().matches(".*\\D.*")) {
            throw new ArithmeticException("ID không phải là số");
        }
        String idStr = id.toString();
        if (!idStr.matches("\\d+")) {
            throw new IllegalArgumentException("ID chứa ký tự đặc biệt");
        }
        nhanVienRepository.deleteById(id);
    }


    public NhanVien findById(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new ArithmeticException("ID không được để trống");
        }
        if (!id.matches("\\d+")) {
            throw new ArithmeticException("ID chỉ được chứa số và không được chứa chữ hoặc ký tự đặc biệt");
        }
        Integer idInteger = Integer.valueOf(id);
        if (idInteger <= 0) {
            throw new ArithmeticException("ID không được là số âm");
        }
        Optional<NhanVien> optionalNhanVien = nhanVienRepository.findById(idInteger);
        if (optionalNhanVien.isPresent()) {
            return optionalNhanVien.get();
        } else {
            throw new ArithmeticException("Không tìm thấy nhân viên với ID: " + idInteger);
        }
    }


    public NhanVien kiemTraDangNhap(String tenDangNhap, String matKhau) {
        if (tenDangNhap == null || tenDangNhap.trim().isEmpty()) {
            throw new ArithmeticException("Tên đăng nhập không được để trống");
        }

        if (matKhau == null || matKhau.trim().isEmpty()) {
            throw new ArithmeticException("Mật khẩu không được để trống");
        }
        if (matKhau.length() < 8) {
            throw new ArithmeticException("Mật khẩu phải có độ dài từ 8 ký tự trở lên");
        }
        Optional<NhanVien> nhanVien = nhanVienRepository.findByTenDangNhap(tenDangNhap);
        if (nhanVien.isPresent()) {
            if (nhanVien.get().getMatKhau().equals(matKhau)) {
                return nhanVien.get();
            } else {
                throw new ArithmeticException("Tên đăng nhập hoặc mật khẩu không chính xác");
            }
        } else {
            throw new ArithmeticException("Tên đăng nhập hoặc mật khẩu không chính xác");
        }
    }

}
