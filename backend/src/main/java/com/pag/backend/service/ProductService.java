package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Product;
import com.pag.backend.model.PageModel;

/**
 * Interface para gerenciar {@link Product}
 * @author rafael.tackla
 */
public interface ProductService {

	
	/**
	 * Insere novo registro
	 * 
	 * @param product - {@link Product} a ser inserido
	 * @return {@link Product} com identificador preenchido
	 */
	Product save (Product product);
	
	/**
	 * Atualiza registro
	 * @param product - {@link Product} a ser atualizado
	 * @return {@link Product} atualizado
	 */
	Product update(Product product);
	
	/**
	 * Deleta registro
	 * @param id - Identificador de {@link Product}
	 */
	void delete(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados
	 * @return {@link List} of {@link Product}
	 */
	List<Product> findAll();
	
	/**
	 * Busca o registro
	 * @param id - Identificador de {@link Product}
	 * @return {@link Product}
	 */
	Product findById(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados <b>com Paginação</b>
	 * @param pageable - Objeto de paginação {@link Pageable}
	 * @return {@link PageModel} of {@link Product}
	 */
	PageModel<Product> findAll(Pageable pageable);
}
