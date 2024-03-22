package com.vansisto.ll7shopapi.repository;

import com.vansisto.ll7shopapi.AbstractTestcontainers;
import com.vansisto.ll7shopapi.entity.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest extends AbstractTestcontainers {
    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        createAndPersistListOfProducts();
    }

    @AfterEach
    void tearDown() {
    }

    @ParameterizedTest
    @CsvSource({
            "ddd",
            " ddd",
            "ddd ",
            " ddd ",
            " ddd 10",
            "ddd 1",
            "Product ddd",
            "duct ddd ",
            "Product ddd 10",
    })
    void getAllWithZeroPriceAndNameContains(String namePart) {
        List<Product> actualProductList = productRepository.getAllWithZeroPriceAndNameContains(namePart);
        assertThat(actualProductList).hasSize(1);
    }

    @ParameterizedTest
    @CsvSource({
            "aaa",
            "bb 5",
            " ccc ",
            "Product b"
    })
    void getAllWithZeroPriceAndNameContains_ShouldBeEmpty(String namePart) {
        List<Product> actualProductList = productRepository.getAllWithZeroPriceAndNameContains(namePart);
        assertThat(actualProductList).isEmpty();
    }

    private void createAndPersistListOfProducts() {
        List<Product> products = List.of(
                new Product().setName("Product aaa 1").setPrice(BigDecimal.valueOf(1)),
                new Product().setName("Product aaa 2").setPrice(BigDecimal.valueOf(2)),
                new Product().setName("Product aaa 3").setPrice(BigDecimal.valueOf(3)),
                new Product().setName("Product bbb 4").setPrice(BigDecimal.valueOf(4)),
                new Product().setName("Product bbb 5").setPrice(BigDecimal.valueOf(5)),
                new Product().setName("Product bbb 6").setPrice(BigDecimal.valueOf(6)),
                new Product().setName("Product ccc 7").setPrice(BigDecimal.valueOf(7)),
                new Product().setName("Product ccc 8").setPrice(BigDecimal.valueOf(8)),
                new Product().setName("Product ccc 9").setPrice(BigDecimal.valueOf(9)),
                new Product().setName("Product ddd 10").setPrice(BigDecimal.valueOf(0))
        );
        productRepository.saveAll(products);
    }
}