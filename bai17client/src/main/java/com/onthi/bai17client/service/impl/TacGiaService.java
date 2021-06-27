package com.onthi.bai17client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.onthi.bai17client.model.TacGia;
import com.onthi.bai17client.service.ITacGiaService;

@Service
public class TacGiaService implements ITacGiaService{
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<TacGia> getAll() {
		return restTemplate.exchange("tacgia", HttpMethod.GET, null, new ParameterizedTypeReference<List<TacGia>>() {
		}).getBody();
	}

	@Override
	public TacGia getByID(int id) {
		return restTemplate.getForObject("tacgia/"+id, TacGia.class);
	}

	@Override
	public void add(TacGia tacGia) {
		restTemplate.postForEntity("tacgia", tacGia, TacGia.class);
	}

	@Override
	public void update(TacGia tacGia) {
		restTemplate.put("tacgia", tacGia);
	}
}
