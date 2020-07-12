package com.sm.multi.foo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foo_data")
public class Foo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4826109143794516614L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String foo;

	public Foo(String foo) {
		this.foo = foo;
	}

	public Foo() {
		// Default constructor needed by JPA
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoo() {
		return foo;
	}

	public void setFoo(String foo) {
		this.foo = foo;
	}

}
