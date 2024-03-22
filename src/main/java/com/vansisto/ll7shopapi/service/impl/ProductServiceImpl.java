package com.vansisto.ll7shopapi.service.impl;

import com.vansisto.ll7shopapi.dto.OrderDTO;
import com.vansisto.ll7shopapi.dto.ProductDTO;
import com.vansisto.ll7shopapi.entity.Order;
import com.vansisto.ll7shopapi.entity.Product;
import com.vansisto.ll7shopapi.exception.ResourceNotFoundException;
import com.vansisto.ll7shopapi.repository.OrderRepository;
import com.vansisto.ll7shopapi.repository.ProductRepository;
import com.vansisto.ll7shopapi.service.ProductService;
import com.vansisto.ll7shopapi.util.OrderDTOMapperUtil;
import com.vansisto.ll7shopapi.util.ProductDTOMapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.vansisto.ll7shopapi.util.ExceptionMessagesUtil.PRODUCT_NOT_FOUND_MESSAGE;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    @Transactional
    public void create(ProductDTO dto) {
        Product product = ProductDTOMapperUtil.mapFromDTO(dto);
        productRepository.save(product);
    }


    @Override
    @Cacheable(cacheNames = "products", key = "#id")
    public ProductDTO getById(Long id) {
        Product product = productRepository.findByIdAndPriceNotNull(id).orElseThrow(
                () -> new ResourceNotFoundException(PRODUCT_NOT_FOUND_MESSAGE, id)
        );
        return ProductDTOMapperUtil.mapToDTO(product);
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "products", key = "#dto.id")
    public void update(ProductDTO dto) {
        productRepository.save(ProductDTOMapperUtil.mapFromDTO(dto));
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "products", key = "#dto.id")
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public OrderDTO addProductToOrder(ProductDTO dto, Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseGet(() -> orderRepository.save(new Order()));
        Product product = ProductDTOMapperUtil.mapFromDTO(dto);

        product.getOrder().add(order);
        order.getProduct().add(product);
        return OrderDTOMapperUtil.mapToDTO(order);
    }
}
