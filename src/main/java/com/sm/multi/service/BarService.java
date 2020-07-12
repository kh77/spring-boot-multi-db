package com.sm.multi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.multi.bar.domain.Bar;
import com.sm.multi.bar.repo.BarRepository;

@Service
@Transactional
public class BarService {
	@Autowired
	BarRepository barRepo;

	public Bar getNameById(Long id) {
		return barRepo.findById(id);
	}

	public void insert(String name) {
		barRepo.save(new Bar(name));
		//throw new RuntimeException("update exception");
	}
}
