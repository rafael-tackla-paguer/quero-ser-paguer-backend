package com.pag.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Mapeamento da tabela "cliente" 
 * @author rafael.tackla
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class Customer implements Serializable {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8417792073068899323L;

	/**
	 *Chave Primária 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 *Nome  
	 */
	@NotBlank(message = "Name required")
	@Size(message = "The name must contain a maximum of 100 characters.")
	@Column(name = "nome", length = 100, nullable = false)
	private String name;
	
	/**
	 * CPF  
	 */
	@NotBlank(message = "CPF required")
	@Size(message = "The CPF must contain a maximum of 11 characters.")
	@Column(length = 11, nullable = false, unique = true, columnDefinition = "char(11)")
	private String cpf;
	
	/**
	 *Data de nascimento 
	 */
	@NotNull(message = "Birth date required")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date birthDate;
	
	/**
	 *Pedidos associados 
	 */
	@Getter(onMethod_={@JsonIgnore})
	@OneToMany(mappedBy = "customer")
	private List<Order> orders = new ArrayList<Order>();
	
}
