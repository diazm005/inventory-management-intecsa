package com.cibertec.inventario.service;

import com.cibertec.inventario.model.Herramienta;
import java.util.List;
import java.util.Optional;

public interface HerramientaService {
    List<Herramienta> listarTodas();
    Optional<Herramienta> buscarPorId(Long id);
    List<Herramienta> buscarPorNombre(String nombre);
    List<Herramienta> buscarPorCategoria(String categoria);
    List<Herramienta> listarStockBajo();
    Herramienta guardar(Herramienta herramienta);
    void eliminar(Long id);
}