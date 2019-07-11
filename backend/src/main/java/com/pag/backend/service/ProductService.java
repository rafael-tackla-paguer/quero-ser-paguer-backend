package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Product;
import com.pag.backend.model.PageModel;
import com.pag.backend.service.impl.ProductServiceImpl;

/**
 * Interface para gerenciar {@link ProductServiceImpl}
 * @author rafael.tackla
 */
public interface ProductService {

	
	/**
	 * Insere novo registro
	 * 
	 * @param product
	 * @return
	 */
	Product save (Product product);
	
	/**
	 * Atualiza registro
	 * @param product
	 * @return
	 */
	Product update(Product product);
	
	/**
	 * Deleta registro pelo {@link Product#getId()}
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados
	 * @return {@link List} of {@link Product}
	 */
	List<Product> findAll();
	
	/**
	 * Busca o registro pelo {@link Product#getId()}
	 * @param id
	 * @return {@link Product}
	 */
	Product findById(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados <b>com Paginação</b>
	 * @param pageable
	 * @return {@link PageModel} of {@link Product}
	 */
	PageModel<Product> findAll(Pageable pageable);
}
