package com.onthi.bai17client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onthi.bai17client.model.TacGia;
import com.onthi.bai17client.service.ITacGiaService;
import com.onthi.bai17client.service.ITacPhamService;
import com.onthi.bai17client.validate.TacGiaValidation;

@Controller
@RequestMapping("/tacgia")
public class TacGiaController {
	
	@Autowired
	private TacGiaValidation valid;
	@Autowired
	private ITacGiaService tacGiaService;
	
	@GetMapping
	public String tacgia(Model model) {
		model.addAttribute("listTG", tacGiaService.getAll());
		return "tacgia";
	}
	
	@GetMapping("/add")
	public String addTG(Model model) {
		model.addAttribute("tg", new TacGia());
		return "addtacgia";
	}
	@PostMapping("/add")
	public String saveTG(Model model,@ModelAttribute("tg") TacGia tg,BindingResult bindingResult) {
		valid.validate(tg, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addtacgia";
		}
		tacGiaService.add(tg);
		return "redirect:/tacgia";
	}
	
	@GetMapping("/update/{maTG}")
	public String updateTG(Model model,@PathVariable int maTG) {
		model.addAttribute("tg", tacGiaService.getByID(maTG));
		return "addtacgia";
	}
	@PostMapping("/update/{maTG}")
	public String saveUpdate(Model model,@ModelAttribute("tg") TacGia tg,BindingResult bindingResult) {
		valid.validate(tg, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addtacgia";
		}
		tacGiaService.update(tg);;
		return "redirect:/tacgia";
	}
}
