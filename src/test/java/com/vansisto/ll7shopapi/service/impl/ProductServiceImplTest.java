package com.vansisto.ll7shopapi.service.impl;

import com.vansisto.ll7shopapi.dto.ProductDTO;
import com.vansisto.ll7shopapi.entity.Product;
import com.vansisto.ll7shopapi.exception.ResourceNotFoundException;
import com.vansisto.ll7shopapi.repository.OrderRepository;
import com.vansisto.ll7shopapi.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    private static final String PRODUCT_NAME = "product";
    private static final BigDecimal PRODUCT_PRICE = BigDecimal.valueOf(1);
    private static final Long PRODUCT_ID = 1L;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;
    @Captor
    private ArgumentCaptor<Product> captor;
    private ProductDTO dto;

    private static ProductDTO prepareProductDTO() {
        return new ProductDTO()
                .setName(PRODUCT_NAME)
                .setPrice(PRODUCT_PRICE);
    }

    @BeforeEach
    void setUp() {
        dto = prepareProductDTO();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        // Given
        Product expectedProduct = new Product()
                .setName(PRODUCT_NAME)
                .setPrice(PRODUCT_PRICE)
                .setOrder(new HashSet<>());

        // Then
        productService.create(dto);
        verify(productRepository).save(captor.capture());
        Product actualProduct = captor.getValue();
        assertThat(actualProduct.getId()).isEqualTo(expectedProduct.getId());
        assertThat(actualProduct.getName()).isEqualTo(expectedProduct.getName());
        assertThat(actualProduct.getPrice()).isEqualTo(expectedProduct.getPrice());
        assertThat(actualProduct.getOrder()).isEqualTo(expectedProduct.getOrder());
    }

    @Test
    void getById() {
        // Given
        dto.setId(PRODUCT_ID);
        Product product = new Product()
                .setId(PRODUCT_ID)
                .setName(PRODUCT_NAME)
                .setPrice(PRODUCT_PRICE)
                .setOrder(new HashSet<>());

        // When
        when(productRepository.findByIdAndPriceNotNull(PRODUCT_ID)).thenReturn(Optional.of(product));

        // Then
        ProductDTO actualProductDTO = productService.getById(PRODUCT_ID);
        assertThat(actualProductDTO).isEqualTo(dto);
    }

    @Test
    void getById_shouldThrow() {
        // Given
        dto.setId(PRODUCT_ID);

        // When
        when(productRepository.findByIdAndPriceNotNull(PRODUCT_ID)).thenReturn(Optional.empty());

        // Then
        assertThrows(ResourceNotFoundException.class, () -> productService.getById(PRODUCT_ID));
    }

    @Test
    void update() {
        // Given

        // When

        // Then
    }

    @Test
    void deleteById() {
        // Given

        // When

        // Then
    }

    @Test
    void addProductToOrder() {
        // Given

        // When

        // Then
    }
}