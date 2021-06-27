package com.onthi.bai17client.service;

import java.util.List;

import com.onthi.bai17client.model.TacPham;

public interface ITacPhamService {
	List<TacPham> getAll();
	List<TacPham> getByTacGia(int maTG);
	TacPham getById(int id);
	void addtacPham(TacPham tacPham);
	void updateTacPham(TacPham tacPham);
	void deleteTacPham(int id);
	List<TacPham> getTaiTen(String tenTP);
	 List<TacPham> getByGiaGiam();
	 List<TacPham> getByGiaTang();
}
