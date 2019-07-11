package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Customer;
import com.pag.backend.model.PageModel;

/**
 * Inteface para gerenciar {@link Customer}
 * @author rafael.tackla
 *
 */
public interface CustomerService {

	/**
	 * Insere novo registro
	 * 
	 * @param customer - {@link Customer} a ser inserido
	 * @return - {@link Customer} com id preenchido
	 */
	Customer save (Customer customer);
	
	/**
	 * Atualiza registro
	 * 
	 * @param customer - {@link Customer} a ser atualizado
	 * @return - {@link Customer} atualizado
	 */
	Customer update(Customer customer);
	
	/**
	 * deleta registro
	 * @param id - Identificador de {@link Customer}
	 */
	void delete(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados
	 * @return {@link List} of {@link Customer}
	 */
	List<Customer> findAll();
	
	/**
	 * Busca o registro 
	 * @param id - Identificador de {@link Customer}
	 * @return {@link Customer}
	 */
	Customer findById(Integer id);

	/**
	 * Retorna todos os registros cadastrados <b>com Paginação</b>
	 * @param pageable - Objeto de paginação {@link Pageable}
	 * @return {@link PageModel} of {@link Customer}
	 */
	PageModel<Customer> findAll(Pageable pageable);
	
}
