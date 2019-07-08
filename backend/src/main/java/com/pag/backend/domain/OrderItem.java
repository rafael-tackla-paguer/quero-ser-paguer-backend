package com.pag.backend.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "item_pedido")
public class OrderItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3203521209953222840L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_pedido", nullable = false)
	@NotNull(message = "order required")
	@JsonIgnoreProperties("orderItems")
	private Order order;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "id_produto", nullable = false)
	@NotNull(message = "product required")
	private Product product;
	
	@Column(name = "quantidade", precision = 10, scale = 2)
	@Min(value = 1, message = "At least 1 product required")
	private BigDecimal amount;
	
	@Column(name = "preco",precision = 10, scale = 2)
	private BigDecimal price;
}
