package com.project.Tiendaa.service;

import com.project.Tiendaa.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {
    ProductoDTO getProductById(Long id);
    ProductoDTO createProduct(ProductoDTO productoDTO);
    List<ProductoDTO> getAllProducts();
    void deleteProductoById(Long id);
    ProductoDTO updateProduct(Long id, ProductoDTO productoDTO);
}
