package com.vansisto.ll7shopapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
public class OrderDTO {
    private Long id;
    private Set<ProductDTO> products = new HashSet<>();
}
