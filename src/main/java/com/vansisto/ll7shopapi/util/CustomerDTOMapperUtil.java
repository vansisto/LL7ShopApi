package com.vansisto.ll7shopapi.util;

import com.vansisto.ll7shopapi.dto.CustomerDTO;
import com.vansisto.ll7shopapi.entity.Customer;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CustomerDTOMapperUtil {

    public CustomerDTO mapToDTO(Customer customer) {
        return new CustomerDTO()
                .setId(customer.getId())
                .setName(customer.getName());
    }

    public Customer mapFromDTO(CustomerDTO dto) {
        return new Customer()
                .setId(dto.getId())
                .setName(dto.getName());
    }
}
