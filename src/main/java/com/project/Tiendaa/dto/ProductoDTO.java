package com.project.Tiendaa.dto;

import com.project.Tiendaa.model.CategoriaEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private CategoriaEntity categoria;

    @NotBlank
    private String nombre;

    @NotNull
    private double precio;

    @NotNull
    private int stock;

    @NotBlank
    private String descripcion;
}
