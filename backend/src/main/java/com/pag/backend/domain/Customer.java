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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8417792073068899323L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name required")
	@Column(name = "nome", length = 100, nullable = false)
	private String name;
	
	@Column(length = 11, nullable = false, unique = true, columnDefinition = "char(11)")
	private Character cpf;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date birthDate;
	
	@Getter(onMethod_={@JsonIgnore})
	@OneToMany(mappedBy = "customer")
	private List<Order> orders = new ArrayList<Order>();
	
}
