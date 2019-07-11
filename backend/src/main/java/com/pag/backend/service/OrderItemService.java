package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.OrderItem;
import com.pag.backend.model.PageModel;
import com.pag.backend.service.impl.OrderItemServiceImpl;

/**
 * Interface para gerenciar {@link OrderItemServiceImpl}
 * @author rafael.tackla
 *
 */
public interface OrderItemService {

	
	/**
	 * Insere novo registro
	 * 
	 * @param orderItem
	 * @return
	 */
	OrderItem save (OrderItem orderItem);
	
	/**
	 * Atualiza registro
	 * 
	 * @param orderItem
	 * @return
	 */
	OrderItem update(OrderItem orderItem);
	
	/**
	 * Deleta registro pelo {@link OrderItem#getId()}
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados
	 * @return {@link List} of {@link OrderItem}
	 */
	List<OrderItem> findAll();
	
	/**
	 * Busca o registro pelo {@link OrderItem#getId()}
	 * @param id
	 * @return {@link OrderItem}
	 */
	OrderItem findById(Integer id);

	/**
	 * Retorna todos os registros cadastrados <b>com Paginação</b>
	 * @param pageable
	 * @return {@link PageModel} of {@link OrderItem}
	 */
	PageModel<OrderItem> findAll(Pageable pageable);

	
	/**
	 * Busca registros pelo {@link OrderItem#getOrder()}
	 * @param orderId
	 * @return {@link List} of {@link OrderItem}
	 */
	List<OrderItem> findAllByOrderId(Integer orderId);
}
