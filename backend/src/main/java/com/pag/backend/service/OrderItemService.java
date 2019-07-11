package com.pag.backend.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.pag.backend.domain.Order;
import com.pag.backend.domain.OrderItem;
import com.pag.backend.model.PageModel;

/**
 * Interface para gerenciar {@link OrderItem}
 * @author rafael.tackla
 *
 */
public interface OrderItemService {

	
	/**
	 * Insere novo registro
	 * 
	 * @param orderItem - {@link OrderItem} a ser inserido
	 * @return {@link OrderItem} com identificador preenchido
	 */
	OrderItem save (OrderItem orderItem);
	
	/**
	 * Atualiza registro
	 * 
	 * @param orderItem - {@link OrderItem} a ser atualizado 
	 * @return {@link OrderItem} atualizado
	 */
	OrderItem update(OrderItem orderItem);
	
	/**
	 * Deleta registro
	 * @param id - Identificador de {@link OrderItem}
	 */
	void delete(Integer id);
	
	/**
	 * Retorna todos os registros cadastrados
	 * @return {@link List} of {@link OrderItem}
	 */
	List<OrderItem> findAll();
	
	/**
	 * Busca o registro 
	 * @param id - Identificador de {@link OrderItem}
	 * @return {@link OrderItem}
	 */
	OrderItem findById(Integer id);

	/**
	 * Retorna todos os registros cadastrados <b>com Paginação</b>
	 * @param pageable - Objeto de {@link Pageable}
	 * @return {@link PageModel} of {@link OrderItem}
	 */
	PageModel<OrderItem> findAll(Pageable pageable);

	
	/**
	 * Busca registros associados a {@link Order}
	 * @param orderId - Identificador de {@link Order}
	 * @return {@link List} of {@link OrderItem}
	 */
	List<OrderItem> findAllByOrderId(Integer orderId);
}
