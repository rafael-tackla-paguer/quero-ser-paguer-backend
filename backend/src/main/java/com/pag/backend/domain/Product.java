package com.pag.backend.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produto")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9116956277466401532L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name required")
	@Size(message = "The name must contain a maximum of 100 characters.")
	@Column(name = "nome", length = 100, nullable = false, unique = true)
	private String name;
	
	@Column(name = "preco_sugerido", precision = 10, scale = 2)
	private BigDecimal suggestedPrice;
	
	private Double discount;
}
