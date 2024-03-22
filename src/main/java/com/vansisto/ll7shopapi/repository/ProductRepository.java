package com.vansisto.ll7shopapi.repository;

import com.vansisto.ll7shopapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByIdAndPriceNotNull(Long id);

    @Query(value = """
        SELECT p FROM Product p
            WHERE p.price = 0 
            AND p.name LIKE CONCAT('%', :namePart, '%') 
    """)
    List<Product> getAllWithZeroPriceAndNameContains(@Param("namePart") String namePart);
}
