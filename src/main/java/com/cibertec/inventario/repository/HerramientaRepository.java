package com.cibertec.inventario.repository;

import com.cibertec.inventario.model.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HerramientaRepository extends JpaRepository<Herramienta, Long> {
    List<Herramienta> findByNombreContainingIgnoreCase(String nombre);
    List<Herramienta> findByCategoria(String categoria);
    List<Herramienta> findByStockActualLessThanEqual(Integer stockMinimo);
}