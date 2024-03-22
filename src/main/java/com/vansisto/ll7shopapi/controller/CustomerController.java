package com.vansisto.ll7shopapi.controller;

import com.vansisto.ll7shopapi.dto.CustomerDTO;
import com.vansisto.ll7shopapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CustomerDTO dto) {
        customerService.create(dto);
    }

    @GetMapping("/{id}")
    public CustomerDTO getById(@PathVariable Long id) {
        return customerService.getById(id);
    }
}
