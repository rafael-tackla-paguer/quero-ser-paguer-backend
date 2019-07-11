package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Order;
import com.pag.backend.model.PageModel;
import com.pag.backend.service.impl.OrderItemServiceImpl;

/**
 *Interface para gerenciar {@link OrderItemServiceImpl} 
 * @author rafael.tackla
 *
 */
public interface OrderService {
	
	/**
	 * Insere novo registro
	 * @param order
	 * @return
	 */
	Order save (Order order);
	
	/**
	 * Atualiza registro
	 * @param order
	 * @return
	 */
	Order update(Order order);
	
	/**
	 * Deleta regitro pelo {@link Order#getId()}
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados
	 * @return {@link List} of {@link Order}
	 */
	List<Order> findAll();
	
	/**
	 * Busca o registro pelo {@link Order#getId()}
	 * @param id
	 * @return {@link Order}
	 */
	Order findById(Integer id);

	/**
	 * Retorna todos os registros cadastrados <b>com Paginação</b>
	 * @param pageable
	 * @return {@link PageModel} of {@link Order}
	 */
	PageModel<Order> findAll(Pageable pageable);
	
	/**
	 * Busca registros pelo {@link Order#getCustomer()}
	 * @param orderId
	 * @return {@link List} of {@link Order}
	 */
	PageModel<Order> findAllByCustomerId(Integer customerId, Pageable pageable);
}
