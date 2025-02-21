package com.project.Tiendaa.service;

import com.project.Tiendaa.dto.ProductoDTO;
import com.project.Tiendaa.model.CategoriaEntity;
import com.project.Tiendaa.model.ProductoEntity;
import com.project.Tiendaa.repository.CategoriaRepository;
import com.project.Tiendaa.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductoServiceImp implements ProductoService{

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public ProductoDTO getProductById(Long id) {
        ProductoEntity productoEntity = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado!"));
        return new ProductoDTO(
                productoEntity.getCategoria(),
                productoEntity.getNombre(),
                productoEntity.getPrecio(),
                productoEntity.getStock(),
                productoEntity.getDescripcion()
        );
    }

    @Override
    public ProductoDTO createProduct(ProductoDTO productoDTO) {

        CategoriaEntity categoria = categoriaRepository.findByCategoryName(productoDTO.getCategoria().getNombre())
                .orElseThrow(()-> new RuntimeException("Categoria no encontrada!"));

        ProductoEntity productoEntity = ProductoEntity.builder()
                .categoria(categoria)
                .nombre(productoDTO.getNombre())
                .precio(productoDTO.getPrecio())
                .stock(productoDTO.getStock())
                .descripcion(productoDTO.getDescripcion())
                .build();

        productoEntity = productoRepository.save(productoEntity);

        return new ProductoDTO(
                productoEntity.getCategoria(),
                productoEntity.getNombre(),
                productoEntity.getPrecio(),
                productoEntity.getStock(),
                productoEntity.getDescripcion()
        );
    }

    @Override
    public List<ProductoDTO> getAllProducts() {
        return productoRepository.findAll().stream()
                .map((producto) -> new ProductoDTO(
                        producto.getCategoria(),
                        producto.getNombre(),
                        producto.getPrecio(),
                        producto.getStock(),
                        producto.getDescripcion()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteProductoById(Long id) {
        if(!productoRepository.existsById(id)){
            throw new RuntimeException("Producto no encontrado!");
        }
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoDTO updateProduct(Long id, ProductoDTO productoDTO) {

        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado!"));

        producto.setNombre(productoDTO.getNombre());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        producto.setDescripcion(productoDTO.getDescripcion());

        producto = productoRepository.save(producto);

        return new ProductoDTO(
                producto.getCategoria(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getDescripcion()
        );

    }
}
