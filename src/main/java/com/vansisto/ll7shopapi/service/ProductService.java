package com.vansisto.ll7shopapi.service;

import com.vansisto.ll7shopapi.dto.OrderDTO;
import com.vansisto.ll7shopapi.dto.ProductDTO;

public interface ProductService extends BaseCRUDService<ProductDTO> {
    OrderDTO addProductToOrder(ProductDTO dto, Long orderId);
}
