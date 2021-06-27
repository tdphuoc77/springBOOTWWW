package com.onthi.bai17client.service;

import java.util.List;

import com.onthi.bai17client.model.TacGia;

public interface ITacGiaService {
	List<TacGia> getAll();
	TacGia getByID(int id);
	void add(TacGia tacGia);
	void update(TacGia tacGia);
}
