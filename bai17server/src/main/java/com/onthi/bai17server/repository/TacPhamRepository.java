package com.onthi.bai17server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onthi.bai17server.entity.TacPham;

public interface TacPhamRepository extends JpaRepository<TacPham, Integer> {
	
	List<TacPham> findByTacGiaMaTG(int maTG);
	List<TacPham> findByTenTPContaining(String tenTP);
}
