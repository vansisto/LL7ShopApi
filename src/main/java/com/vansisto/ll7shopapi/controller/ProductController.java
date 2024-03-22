package com.vansisto.ll7shopapi.controller;

import com.vansisto.ll7shopapi.dto.OrderDTO;
import com.vansisto.ll7shopapi.dto.ProductDTO;
import com.vansisto.ll7shopapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO dto) {
        productService.create(dto);
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping
    public void update(@RequestBody ProductDTO dto) {
        productService.update(dto);
    }

    @PostMapping("/{orderId}")
    public OrderDTO addProductToOrder(@PathVariable Long orderId, @RequestBody ProductDTO dto) {
        return productService.addProductToOrder(dto, orderId);
    }
}
