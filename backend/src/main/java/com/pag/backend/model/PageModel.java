package com.pag.backend.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rafael.tackla
 *	Classe modelo de {@link ResponseEntity} para operações com paginação
 * @param <T> - Classe da lista de elementos
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageModel<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1505159134012903024L;
	/**
	 * Total de elementos encontrados
	 */
	private long totalElements;
	/**
	 * Quantidade de elementos retornadas por página
	 */
	private int pageSize;
	/**
	 * Quantidade de páginas para exibição de todos os elementos retornados
	 */
	private int totalPages;
	/**
	 * {@link List} contendo os elementos retornados 
	 */
	private List<T> elements;
}
