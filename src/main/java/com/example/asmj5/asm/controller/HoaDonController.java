package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.entity.HoaDon;
import com.example.asmj5.asm.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/asm")
public class HoaDonController {
    @Autowired
    HoaDonService hoaDonService;
    @GetMapping("/hd-hienthi")
    public String hienThi(Model model){
        List<HoaDon> danhSachHDHT = hoaDonService.getAllDaThanhToan();
        model.addAttribute("danhSachHDHT",danhSachHDHT);
        return "asm/hd-hienthi";
    }

    @GetMapping("/hd-detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("hd",hoaDonService.findById(id));
        return "asm/hd-detail";
    }
}
