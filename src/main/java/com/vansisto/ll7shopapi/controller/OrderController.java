package com.vansisto.ll7shopapi.controller;

import com.vansisto.ll7shopapi.dto.OrderDTO;
import com.vansisto.ll7shopapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void create(OrderDTO dto) {
        orderService.create(dto);
    }

    @GetMapping("/{id}")
    public OrderDTO getById(@PathVariable Long id) {
        return orderService.getById(id);
    }
}
