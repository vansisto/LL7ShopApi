package com.vansisto.ll7shopapi.util;

import com.vansisto.ll7shopapi.dto.OrderDTO;
import com.vansisto.ll7shopapi.entity.Order;
import com.vansisto.ll7shopapi.entity.Product;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class OrderDTOMapperUtil {

    public OrderDTO mapToDTO(Order order) {
        return new OrderDTO()
                .setId(order.getId());
    }

    public Order mapFromDTO(OrderDTO dto) {
        Set<Product> products = dto.getProducts().stream()
                .map(ProductDTOMapperUtil::mapFromDTO)
                .collect(Collectors.toSet());

        return new Order()
                .setId(dto.getId())
                .setProduct(products);
    }
}
