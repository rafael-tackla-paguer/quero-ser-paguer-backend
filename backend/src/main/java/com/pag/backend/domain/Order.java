package com.pag.backend.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mapeamento da tabela "pedido" 
 * @author rafael.tackla
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pedido")
public class Order implements Serializable{
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 5059268557324895665L;

	/**
	 *Chave Primária 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 *Cliente que fez o pedido 
	 */
	@ManyToOne
	@JoinColumn(name = "id_cliente", nullable = false)
	@NotNull(message = "customer required")
	private Customer customer;
	
	/**
	 * Valor total do pedido 
	 */
	@Column(name = "valor", precision = 10, scale = 2)
	private BigDecimal value;
	
	/**
	 *Itens associados  
	 */
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	@JsonIgnoreProperties("order")
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
}
