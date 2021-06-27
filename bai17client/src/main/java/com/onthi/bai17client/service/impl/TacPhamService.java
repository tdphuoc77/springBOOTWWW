package com.onthi.bai17client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.onthi.bai17client.model.TacPham;
import com.onthi.bai17client.service.ITacPhamService;

@Service
public class TacPhamService implements ITacPhamService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<TacPham> getAll() {
		return restTemplate.exchange("tacpham", HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}

	@Override
	public List<TacPham> getByTacGia(int maTG) {
		return restTemplate.exchange("tacpham/tacgia/"+maTG, HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}

	@Override
	public TacPham getById(int id) {
		return restTemplate.getForObject("tacpham/"+id, TacPham.class);
	}

	@Override
	public void addtacPham(TacPham tacPham) {
		restTemplate.postForEntity("tacpham", tacPham, TacPham.class);
	}

	@Override
	public void updateTacPham(TacPham tacPham) {
		restTemplate.put("tacpham", tacPham);
	}

	@Override
	public void deleteTacPham(int id) {
		restTemplate.delete("tacpham/"+id);
	}

	@Override
	public List<TacPham> getTaiTen(String tenTP) {
		return restTemplate.exchange("tacpham/ten?tenTP="+tenTP, HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}

	@Override
	public List<TacPham> getByGiaGiam() {
		return restTemplate.exchange("tacpham/gia/giam", HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}

	@Override
	public List<TacPham> getByGiaTang() {
		return restTemplate.exchange("tacpham/gia/tang", HttpMethod.GET, null, new ParameterizedTypeReference<List<TacPham>>() {
		}).getBody();
	}
	

}
