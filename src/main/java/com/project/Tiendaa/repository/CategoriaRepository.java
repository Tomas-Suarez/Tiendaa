package com.project.Tiendaa.repository;

import com.project.Tiendaa.model.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

    Optional<CategoriaEntity> findByCategoryName(String categoryName);
}
