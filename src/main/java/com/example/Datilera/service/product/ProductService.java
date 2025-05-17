package com.example.datilera.service.product;

import java.util.List;

import com.example.datilera.dto.product.ProductCreateMultipartDto;
import com.example.datilera.dto.product.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductCreateMultipartDto productCreateDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto updateProduct(Long id, ProductCreateMultipartDto productUpdateDto);
    void deleteProduct(Long id);
}