package com.pag.backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "item_pedido")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "pedido_id", nullable = false)
	private Order order;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "produto_id", nullable = false)
	private Product product;
	
	@Column(name = "quantidade", precision = 10, scale = 2)
	private Double amount;
	
	@Column(name = "preco",precision = 10, scale = 2)
	private Double price;
}
