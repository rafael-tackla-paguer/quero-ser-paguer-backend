package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Customer;
import com.pag.backend.domain.Order;
import com.pag.backend.model.PageModel;

/**
 *Interface para gerenciar {@link com.pag.backend.domain.Order} 
 * @author rafael.tackla
 *
 */
public interface OrderService {
	
	/**
	 * Insere novo registro
	 * @param order - {@link Order} a ser inserido
	 * @return {@link Order} com identificador preenchido
	 */
	Order save (Order order);
	
	/**
	 * Atualiza registro
	 * @param order - {@link Order} a ser atualizado
	 * @return - {@link Order} atualizado
	 */
	Order update(Order order);
	
	/**
	 * Deleta regitro 
	 * @param id - Identificador de {@link Order}
	 */
	void delete(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados
	 * @return {@link List} of {@link Order}
	 */
	List<Order> findAll();
	
	/**
	 * Busca o registro
	 * @param id - Identificador de {@link Order}
	 * @return {@link Order}
	 */
	Order findById(Integer id);

	/**
	 * Retorna todos os registros cadastrados <b>com Paginação</b>
	 * @param pageable - {@link Pageable}
	 * @return {@link PageModel} of {@link Order}
	 */
	PageModel<Order> findAll(Pageable pageable);
	
	/**
	 * Busca registros associados ao {@link Customer}
	 * @param customerId - Identificador de {@link Customer}
	 * @param pageable - Objeto paginável {@link Pageable}
	 * @return {@link List} of {@link Order}
	 */
	PageModel<Order> findAllByCustomerId(Integer customerId, Pageable pageable);
}
