package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Customer;
import com.pag.backend.model.PageModel;
import com.pag.backend.service.impl.CustomerServiceImpl;

/**
 * Inteface para gerenciar {@link CustomerServiceImpl}
 * @author rafael.tackla
 *
 */
public interface CustomerService {

	/**
	 * Insere novo registro
	 * 
	 * @param customer
	 * @return
	 */
	Customer save (Customer customer);
	
	/**
	 * Atualiza registro
	 * 
	 * @param customer
	 * @return
	 */
	Customer update(Customer customer);
	
	/**
	 * deleta registro pelo {@link Customer#getId()}
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados
	 * @return {@link List} of {@link Customer}
	 */
	List<Customer> findAll();
	
	/**
	 * Busca o registro pelo {@link Customer#getId()}
	 * @param id
	 * @return {@link Customer}
	 */
	Customer findById(Integer id);

	/**
	 * Retorna todos os registros cadastrados <b>com Paginação</b>
	 * @param pageable
	 * @return {@link PageModel} of {@link Customer}
	 */
	PageModel<Customer> findAll(Pageable pageable);
	
}
