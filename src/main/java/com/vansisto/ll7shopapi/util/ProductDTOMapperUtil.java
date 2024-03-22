package com.vansisto.ll7shopapi.util;

import com.vansisto.ll7shopapi.dto.ProductDTO;
import com.vansisto.ll7shopapi.entity.Order;
import com.vansisto.ll7shopapi.entity.Product;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class ProductDTOMapperUtil {

    public ProductDTO mapToDTO(Product product) {
        return new ProductDTO()
                .setId(product.getId())
                .setName(product.getName())
                .setPrice(product.getPrice());
    }

    public Product mapFromDTO(ProductDTO dto) {
        Set<Order> orders = dto.getOrders().stream()
                .map(OrderDTOMapperUtil::mapFromDTO)
                .collect(Collectors.toSet());

        return new Product()
                .setId(dto.getId())
                .setName(dto.getName())
                .setPrice(dto.getPrice())
                .setOrder(orders);
    }
}
