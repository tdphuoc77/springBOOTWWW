package com.onthi.bai17server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onthi.bai17server.entity.TacPham;
import com.onthi.bai17server.repository.TacPhamRepository;

@RestController
@RequestMapping("/tacpham")
public class TacPhamRestTroller {
	@Autowired
	private TacPhamRepository tacPhamRepository;
	
	@GetMapping
	public List<TacPham> getTacPhams() {
		return tacPhamRepository.findAll();
	}
	@GetMapping("/tacgia/{maTG}")
	public List<TacPham> getTacPhamByTacGia(@PathVariable int maTG) {
		return tacPhamRepository.findByTacGiaMaTG(maTG);
	}
	
	@GetMapping("/gia/giam")
	public List<TacPham> getByGiaGiam() {
		return tacPhamRepository.findAll(Sort.by(Direction.DESC, "gia"));
	}
	
	@GetMapping("/gia/tang")
	public List<TacPham> getByGiatang() {
		return tacPhamRepository.findAll(Sort.by(Direction.ASC, "gia"));
	}
	
	@GetMapping("/ten")
	public List<TacPham> getByTen(@RequestParam String tenTP) {
		return tacPhamRepository.findByTenTPContaining(tenTP);
	}
	
	@GetMapping("/{id}")
	public TacPham getTacPham(@PathVariable int id) {
		return tacPhamRepository.findById(id).get();
	}
	
	@PostMapping
	public TacPham postTacPham(@RequestBody TacPham tacPham) {
		tacPhamRepository.save(tacPham);
		return tacPham;
	}
	@PutMapping
	public TacPham putTacPham(@RequestBody TacPham tacPham) {
		tacPhamRepository.save(tacPham);
		return tacPham;
	}
	
	@DeleteMapping("/{id}")
	public void deleteTacPham(@PathVariable int id) {
		tacPhamRepository.deleteById(id);
	}
}
