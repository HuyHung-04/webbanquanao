package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.entity.*;
import com.example.asmj5.asm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/asm")
public class BanHangController {
    @Autowired
    HoaDonService hoaDonService;
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    SanPhamChiTietService sanPhamChiTietService;
    @Autowired
    KhachHangService khachHangService;
    @Autowired
    NhanVienService nhanVienService;
    @GetMapping("/bh-hienthi")
    public String hienThi(Model model) {
        List<HoaDon> danhSachHD = hoaDonService.getAll();
        List<HoaDonChiTiet> danhSachHDCT = hoaDonChiTietService.getAll();
        List<HoaDonChiTiet> danhSachHDCTChuaThanhToan = danhSachHDCT.stream()
                .filter(hdct -> !hdct.getHoaDon().isTrangThai())
                .collect(Collectors.toList());

        model.addAttribute("danhSachHD", danhSachHD);
        model.addAttribute("danhSachHDCT", danhSachHDCTChuaThanhToan);
        model.addAttribute("danhSachSPCT", sanPhamChiTietService.getAll());
        model.addAttribute("ngayHienTai", LocalDate.now());
        return "asm/bh-hienthi";
    }


    @ModelAttribute("danhSachKH")
    public List<KhachHang> getKhachHang(){
        return khachHangService.getAll();
    }

    @ModelAttribute("danhSachNV")
    public List<NhanVien> getNhanVien(){
        return nhanVienService.getAll();
    }

    @PostMapping("/bh-add")
    public String addHoaDon(HoaDon hoaDon){
        HoaDon hoaDon1 = new HoaDon();
        hoaDon1.setTrangThai(false);
        hoaDonService.add(hoaDon);
        return "redirect:/asm/bh-hienthi";
    }

    @PostMapping("/add-cart")
    public String addToCart(@RequestParam("idHoaDon") Integer idHoaDon,
                            @RequestParam("idSanPhamChiTiet") Integer idSanPhamChiTiet) {
        HoaDon hoaDon = hoaDonService.findById(idHoaDon);
        SanPhamChiTiet sanPhamChiTiet = sanPhamChiTietService.findById(idSanPhamChiTiet);
        if (sanPhamChiTiet.getSoLuong() > 0) {
            sanPhamChiTiet.setSoLuong(sanPhamChiTiet.getSoLuong() - 1);
            sanPhamChiTietService.update(sanPhamChiTiet);
            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setSanPhamChiTiet(sanPhamChiTiet);
            hoaDonChiTiet.setSoLuong(1);
            hoaDonChiTiet.setDonGia(sanPhamChiTiet.getDonGia());
            hoaDonChiTietService.add(hoaDonChiTiet);
        }

        return "redirect:/asm/bh-hienthi";
    }
    @PostMapping("/hdct-delete")
    public String deleteHoaDonChiTiet(@RequestParam("id") Integer id) {
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietService.findById(id);
        if (hoaDonChiTiet != null) {
            SanPhamChiTiet sanPhamChiTiet = hoaDonChiTiet.getSanPhamChiTiet();
            sanPhamChiTiet.setSoLuong(sanPhamChiTiet.getSoLuong() + hoaDonChiTiet.getSoLuong());
            sanPhamChiTietService.update(sanPhamChiTiet);
            hoaDonChiTietService.delete(id);
        }
        return "redirect:/asm/bh-hienthi";
    }

    @PostMapping("/thanh-toan")
    public String thanhToan(@RequestParam("idHoaDon") Integer idHoaDon) {
        HoaDon hoaDon = hoaDonService.findById(idHoaDon);
        hoaDon.setTrangThai(true);
        hoaDonService.update(hoaDon);
        return "redirect:/asm/bh-hienthi";
    }



}
