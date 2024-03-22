package com.vansisto.ll7shopapi.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
@ToString
@Getter
@Setter
@Accessors(chain = true)
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private Set<OrderDTO> orders = new HashSet<>();
}
