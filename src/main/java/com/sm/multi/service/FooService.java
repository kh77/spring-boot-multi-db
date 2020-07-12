package com.sm.multi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sm.multi.foo.domain.Foo;
import com.sm.multi.foo.repo.FooRepository;

@Service
@Transactional
public class FooService {

	@Autowired
	FooRepository fooRepo;
	@Autowired
	BarService barService;

	public Foo getNameById(Long id) {
		return fooRepo.findById(id);
	}

	@Transactional(value = "chainedTransactionManager")
	public void insert(String name) {
		fooRepo.save(new Foo(name));
		barService.insert(name);
	}
}
