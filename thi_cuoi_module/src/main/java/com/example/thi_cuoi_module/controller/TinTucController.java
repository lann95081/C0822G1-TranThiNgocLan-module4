package com.example.thi_cuoi_module.controller;

import com.example.thi_cuoi_module.model.TinTuc;
import com.example.thi_cuoi_module.service.IDanhMucService;
import com.example.thi_cuoi_module.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TinTucController {
    @Autowired
    private IDanhMucService iDanhMucService;

    @Autowired
    private ITinTucService iTinTucService;

    @GetMapping("")
    public String hienThi(@RequestParam(value = "tieuDe", defaultValue = "") String tieuDe, Model model) {
        model.addAttribute("danhSachTinTuc", iTinTucService.searchByTieuDe(tieuDe));
        model.addAttribute("danhSachDanhMuc", iDanhMucService.findAll());
        model.addAttribute("tieuDe", tieuDe);
        return "/danh_sach";
    }

    @GetMapping("/themMoi")
    public String themMoi(Model model) {
        model.addAttribute("tinTuc", new TinTuc());
        model.addAttribute("danhSachDanhMuc", iTinTucService.findAll());
        return "/them_moi";
    }

    @PostMapping("/luu")
    public String luu(TinTuc tinTuc, RedirectAttributes redirectAttributes) {
        iTinTucService.save(tinTuc);
        redirectAttributes.addFlashAttribute("message", "Thêm mới tin tức thành công.");
        return "redirect:/";
    }

    @GetMapping("/xoa/{ma}")
    public String xoa(@PathVariable(value = "ma") Integer ma, RedirectAttributes redirectAttributes) {
        iTinTucService.deleteLogical(ma);
        redirectAttributes.addFlashAttribute("message", "Xóa tin tức  [" +
                iTinTucService.findById(ma).get().getTieuDe() + "]  thành công.");

        return "redirect:/";
    }
}
