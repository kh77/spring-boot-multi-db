package com.sm.multi.bar.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bar_data")
public class Bar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5160599255592902166L;

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE,
	// generator="bar_id_seq")
	// @SequenceGenerator(name="bar_id_seq", sequenceName="bar_id_seq",
	// allocationSize=1)
	// @Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "name")
	private String bar;

	public Bar(String bar) {
		this.bar = bar;
	}

	public Bar() {
		// Default constructor needed by JPA
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setBar(String bar) {
		this.bar = bar;
	}

	public String getBar() {
		return bar;
	}
}
