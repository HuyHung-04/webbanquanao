package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.entity.KichThuoc;
import com.example.asmj5.asm.entity.MauSac;
import com.example.asmj5.asm.entity.SanPham;
import com.example.asmj5.asm.entity.SanPhamChiTiet;
import com.example.asmj5.asm.service.KichThuocService;
import com.example.asmj5.asm.service.MauSacService;
import com.example.asmj5.asm.service.SanPhamChiTietService;
import com.example.asmj5.asm.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("asm")
public class SanPhamChiTietController {
    @Autowired
    SanPhamChiTietService sanPhamChiTietService;
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    MauSacService mauSacService;
    @Autowired
    KichThuocService kichThuocService;
    @GetMapping("/spct-hienthi")
    public String hienThi(Model model){
        model.addAttribute("danhSach",sanPhamChiTietService.getAll());
        return "asm/spct-hienthi";
    }

    @ModelAttribute("danhSachSP")
    public List<SanPham> getSanPham(){
        return sanPhamService.getAll();
    }
    @ModelAttribute("danhSachMS")
    public List<MauSac> getMauSac(){
        return mauSacService.getAll();
    }
    @ModelAttribute("danhSachKT")
    public List<KichThuoc> getKichThuoc(){
        return kichThuocService.getAll();
    }

    @GetMapping("/spct-viewadd")
    public String viewAdd(){
        return "asm/spct-viewadd";
    }

    @PostMapping("/spct-add")
    public String add(SanPhamChiTiet sanPhamChiTiet){
        sanPhamChiTietService.add(sanPhamChiTiet);
        return "redirect:/asm/spct-hienthi";
    }

    @GetMapping("/spct-delete")
    public String delete(@RequestParam("id") Integer idSPCT){
        sanPhamChiTietService.delete(idSPCT);
        return "redirect:/asm/spct-hienthi";
    }

    @GetMapping("/spct-detail")
    public String detail(@RequestParam("id") Integer idSPCT, Model model){
        model.addAttribute("spct",sanPhamChiTietService.findById(idSPCT));
        return "asm/spct-detail";
    }

    @GetMapping("/spct-viewupdate/{id}")
    public String update(@PathVariable("id") Integer idSPCT, Model model){
        model.addAttribute("spct",sanPhamChiTietService.findById(idSPCT));
        return "asm/spct-viewupdate";
    }

    @PostMapping("/spct-update")
    public String update(SanPhamChiTiet sanPhamChiTiet){
        sanPhamChiTietService.update(sanPhamChiTiet);
        return "redirect:/asm/spct-hienthi";
    }
}
