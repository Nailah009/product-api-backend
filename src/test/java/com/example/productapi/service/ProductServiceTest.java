package com.example.productapi.service;

import com.example.productapi.dto.ProductRequest;
import com.example.productapi.dto.ProductResponse;
import com.example.productapi.exception.ProductNotFoundException;
import com.example.productapi.model.Product;
import com.example.productapi.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void testGetAllProducts() {
        Product product1 = new Product(1L, "Laptop", 15000000.0, 5);
        Product product2 = new Product(2L, "Mouse", 150000.0, 20);

        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        var responses = productService.getAllProducts();

        assertThat(responses).hasSize(2);
        assertThat(responses.get(0).getName()).isEqualTo("Laptop");
        assertThat(responses.get(1).getName()).isEqualTo("Mouse");
        verify(productRepository).findAll();
    }

    @Test
    void testCreateProduct() {
        ProductRequest request = new ProductRequest();
        request.setName("Keyboard");
        request.setPrice(500000.0);
        request.setStock(15);

        Product savedProduct = new Product(1L, "Keyboard", 500000.0, 15);

        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);

        ProductResponse response = productService.createProduct(request);

        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getName()).isEqualTo("Keyboard");
        verify(productRepository).save(any(Product.class));
    }

    @Test
    void testUpdateProduct() {
        Product existing = new Product(1L, "Laptop", 15000000.0, 5);
        ProductRequest request = new ProductRequest();
        request.setName("Laptop Pro");
        request.setPrice(17000000.0);
        request.setStock(7);

        when(productRepository.findById(1L)).thenReturn(Optional.of(existing));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ProductResponse response = productService.updateProduct(1L, request);

        assertThat(response.getName()).isEqualTo("Laptop Pro");
        assertThat(response.getPrice()).isEqualTo(17000000.0);
        assertThat(response.getStock()).isEqualTo(7);
    }

    @Test
    void testGetProductByIdNotFound() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.getProductById(99L))
                .isInstanceOf(ProductNotFoundException.class)
                .hasMessageContaining("99");
    }
}
