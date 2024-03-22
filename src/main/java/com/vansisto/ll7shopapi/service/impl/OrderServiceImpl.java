package com.vansisto.ll7shopapi.service.impl;

import com.vansisto.ll7shopapi.dto.OrderDTO;
import com.vansisto.ll7shopapi.entity.Order;
import com.vansisto.ll7shopapi.exception.ResourceNotFoundException;
import com.vansisto.ll7shopapi.repository.OrderRepository;
import com.vansisto.ll7shopapi.service.OrderService;
import com.vansisto.ll7shopapi.util.ExceptionMessagesUtil;
import com.vansisto.ll7shopapi.util.OrderDTOMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void create(OrderDTO orderDTO) {
        orderRepository.save(OrderDTOMapperUtil.mapFromDTO(orderDTO));
    }

    @Override
    public OrderDTO getById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(ExceptionMessagesUtil.ORDER_NOT_FOUND_MESSAGE, id)
        );
        return OrderDTOMapperUtil.mapToDTO(order);
    }

    @Override
    @Transactional
    public void update(OrderDTO orderDTO) {

    }

    @Override
    @Transactional
    public void deleteById(Long id) {

    }
}
