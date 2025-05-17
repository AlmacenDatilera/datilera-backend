package com.example.Datilera.service.product;

import java.util.List;

import com.example.Datilera.dto.product.ProductCreateMultipartDto;
import com.example.Datilera.dto.product.ProductDto;

public interface ProductService {
    ProductDto createProduct(ProductCreateMultipartDto productCreateDto);
    List<ProductDto> getAllProducts();
    ProductDto getProductById(Long id);
    ProductDto updateProduct(Long id, ProductCreateMultipartDto productUpdateDto);
    void deleteProduct(Long id);
}