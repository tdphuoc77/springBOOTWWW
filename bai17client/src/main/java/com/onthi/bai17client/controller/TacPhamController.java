package com.onthi.bai17client.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.onthi.bai17client.config.UploadFile;
import com.onthi.bai17client.model.TacPham;
import com.onthi.bai17client.service.ITacGiaService;
import com.onthi.bai17client.service.ITacPhamService;
import com.onthi.bai17client.validate.TacPhamValidation;

@Controller
public class TacPhamController {
	@Autowired
	private ITacPhamService tacPhamService;
	@Autowired
	private ITacGiaService tacGiaService;
	@Autowired
	private UploadFile uploadFile;
	
	@Autowired
	private TacPhamValidation valid;
	@GetMapping(value = {"/","/home"})
	public String home(Model model) {
		model.addAttribute("listTP", tacPhamService.getAll());
		return "home";
	}
	
	@GetMapping("/tacpham/add")
	public String addTP(Model model) {
		model.addAttribute("tp", new TacPham());
		model.addAttribute("listTG", tacGiaService.getAll());
		return "addtacpham";
	}
	
	
	@PostMapping("/tacpham/add")
	public String saveTP(Model model,HttpSession session, @ModelAttribute("tp") TacPham tp,@RequestParam("idTG") int maTG,@RequestParam("file") MultipartFile file,BindingResult bindingResult) {
		tp.setTacGia(tacGiaService.getByID(maTG));
		tp.setHinh(file.getOriginalFilename());
		valid.validate(tp, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("listTG", tacGiaService.getAll());
			return "addtacpham";
		}
		
		tacPhamService.addtacPham(tp);
		
		uploadFile.uploadFile(file, session);
		
		return "redirect:/";
	}
	@GetMapping("/tacpham/quanly")
	public String quanly(Model model) {
		model.addAttribute("listTP", tacPhamService.getAll());
		return "quanly";
	}
	@GetMapping("/tacpham/update/{maTP}")
	public String update(Model model,@PathVariable int maTP) {
		model.addAttribute("tp",tacPhamService.getById(maTP) );
		model.addAttribute("listTG", tacGiaService.getAll());
		return "addtacpham";
	}
	
	@PostMapping("/tacpham/update/{maTP}")
	public String saveUpdate(Model model,@ModelAttribute("tp")TacPham tp,@RequestParam("file") MultipartFile file,@RequestParam("idTG") int maTG,HttpSession session,BindingResult bindingResult) {
		tp.setTacGia(tacGiaService.getByID(maTG));
		tp.setHinh(file.getOriginalFilename());
		valid.validate(tp, bindingResult);
		if(bindingResult.hasErrors()) {
			model.addAttribute("listTG", tacGiaService.getAll());
			return "addtacpham";
		}
		tacPhamService.addtacPham(tp);
		uploadFile.uploadFile(file, session);
		
		return "redirect:/tacpham/quanly";
	}
	
	@GetMapping("/tacpham/delete/{maTP}")
	public String delete(Model model,@PathVariable int maTP) {
		tacPhamService.deleteTacPham(maTP);
		return "redirect:/tacpham/quanly";
	}
	@GetMapping("/tacpham/tacgia/{maTG}")
	public String tacPhamByTacGia(Model model,@PathVariable("maTG") int maTG) {
		model.addAttribute("listTP", tacPhamService.getByTacGia(maTG));
		return "quanly";
	}
	
	@GetMapping("/error")
	public String name() {
		return "error";
	}
//	/tacpham/quanly/timkiem
	
	@GetMapping("/tacpham/quanly/timkiem")
	public String timKiemByTen(Model model,@RequestParam("key") String key) {
		model.addAttribute("listTP", tacPhamService.getTaiTen(key));
		return "quanly";
	}
	
//	/tacpham/quanly/gia/tang
	@GetMapping("/tacpham/quanly/gia/tang")
	public String sapXepTang(Model model) {
		model.addAttribute("listTP", tacPhamService.getByGiaTang());
		return "quanly";
	}
	@GetMapping("/tacpham/quanly/gia/giam")
	public String sapXepGiam(Model model) {
		model.addAttribute("listTP", tacPhamService.getByGiaGiam());
		return "quanly";
	}
//	/tacpham/xemchitiet/${tp.maTP}
	
	@GetMapping("/tacpham/xemchitiet/{maTP}")
	public String xemChiTiet(Model model,@PathVariable int maTP) {
		model.addAttribute("tp", tacPhamService.getById(maTP));
		return "xemchitiet";
	}
}
