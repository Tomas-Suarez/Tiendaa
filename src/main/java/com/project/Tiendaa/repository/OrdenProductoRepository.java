package com.project.Tiendaa.repository;

import com.project.Tiendaa.model.OrdenProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenProductoRepository extends JpaRepository<OrdenProductoEntity, Long> {
}
