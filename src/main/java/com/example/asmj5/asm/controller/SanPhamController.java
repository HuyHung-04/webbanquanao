package com.example.asmj5.asm.controller;

import com.example.asmj5.asm.entity.SanPham;
import com.example.asmj5.asm.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asm")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @GetMapping("/sp-hienthi")
    public String hienThi(Model model){
        model.addAttribute("danhSach",sanPhamService.getAll());
        return "asm/sp-hienthi";
    }

    @GetMapping("/sp-viewadd")
    public String viewAdd(){
        return "asm/sp-viewadd";
    }

    @PostMapping("/sp-add")
    public String add(SanPham sanPham){
        sanPhamService.add(sanPham);
        return "redirect:/asm/sp-hienthi";
    }

    @GetMapping("/sp-delete")
    public String delete(@RequestParam("id") Integer id){
        sanPhamService.delete(id);
        return "redirect:/asm/sp-hienthi";
    }

    @GetMapping("/sp-detail")
    public String detail(@RequestParam("id") Integer id, Model model){
        model.addAttribute("sp",sanPhamService.findById(id));
        return "asm/sp-detail";
    }

    @GetMapping("/sp-viewupdate/{id}")
    public String viewupdate(@PathVariable("id") Integer id, Model model){
        model.addAttribute("sp",sanPhamService.findById(id));
        return "asm/sp-update";
    }

    @PostMapping("/sp-update")
    public String update(SanPham sanPham){
        sanPhamService.update(sanPham);
        return "redirect:/asm/sp-hienthi";
    }

}
