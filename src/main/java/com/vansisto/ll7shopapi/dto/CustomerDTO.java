package com.vansisto.ll7shopapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CustomerDTO {
    private Long id;
    private String name;
}
