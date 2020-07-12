package com.sm.multi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.multi.bar.domain.Bar;
import com.sm.multi.foo.domain.Foo;
import com.sm.multi.service.BarService;
import com.sm.multi.service.FooService;

@RestController
public class FooBarController {

	@Autowired
	FooService fooService;
	@Autowired
	BarService barService;

	/**
	 * If both db id are same, retrieve the data 
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}")
	public String getDataByDBId(@PathVariable("id") Long id) {
		Foo foo = fooService.getNameById(id);
		Bar bar = barService.getNameById(id);

		return foo.getFoo() + " " + bar.getBar() + "!";
	}

	/**
	 * save the data in both table and uncomment the runtime exception it will rollback to both transaction
	 * @param name
	 * @return
	 */
	@RequestMapping("/save/{name}")
	public String saveBothDataOrRollBack(@PathVariable("name") String name) {
		fooService.insert(name);
		return "OK";
	}

}
