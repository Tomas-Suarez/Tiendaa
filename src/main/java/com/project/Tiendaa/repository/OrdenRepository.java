package com.project.Tiendaa.repository;

import com.project.Tiendaa.model.OrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenEntity, Long> {
}
