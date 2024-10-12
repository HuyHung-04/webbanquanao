package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/asm")
public class HoaDonChiTietController {
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/hdct-hienthi")
    public String hienThi(Model model){
        model.addAttribute("danhSachHDCTHT", hoaDonChiTietService.getAll());
        return "asm/hdct-hienthi";
    }

    @GetMapping("/hdct-detail/{id}")
    public String detail(@PathVariable("id") Integer id, Model model){
        model.addAttribute("hdct", hoaDonChiTietService.findById(id));
        return "asm/hdct-detail";
    }
}
