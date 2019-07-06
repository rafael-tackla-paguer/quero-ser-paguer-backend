package com.pag.backend.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produto")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9116956277466401532L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nome", length = 100, nullable = false, unique = true)
	private String name;
	
	@Column(name = "preco_sugerido", precision = 10, scale = 2)
	private BigDecimal suggestedPrice;
}