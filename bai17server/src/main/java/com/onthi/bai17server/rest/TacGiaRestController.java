package com.onthi.bai17server.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onthi.bai17server.entity.TacGia;
import com.onthi.bai17server.repository.TacGiaRepository;

@RestController
@RequestMapping("/tacgia")
public class TacGiaRestController {
	@Autowired
	private TacGiaRepository tacGiaRepository;
	
	@GetMapping
	public List<TacGia> getTacGias() {
		return tacGiaRepository.findAll();
	}
	@GetMapping("/{id}")
	public TacGia getTacGia(@PathVariable int id) {
		return tacGiaRepository.findById(id).get();
	}
	@PostMapping
	public TacGia postTacGia(@RequestBody TacGia tacGia) {
		tacGiaRepository.save(tacGia);
		return tacGia;
	}
	@PutMapping
	public TacGia putTacGia(@RequestBody TacGia tacGia) {
		tacGiaRepository.save(tacGia);
		return tacGia;
	}
	
	@DeleteMapping("/{id}")
	public void deleteTacGia(@PathVariable int id) {
		tacGiaRepository.deleteById(id);
	}
}
