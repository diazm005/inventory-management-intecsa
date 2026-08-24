package com.cibertec.inventario.service;

import com.cibertec.inventario.model.Movimiento;
import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoService {
    List<Movimiento> listarTodos();
    List<Movimiento> listarPorHerramienta(Long herramientaId);
    List<Movimiento> listarPorUsuario(Long usuarioId);
    List<Movimiento> listarPorFechas(LocalDateTime inicio, LocalDateTime fin);
    Movimiento registrar(Movimiento movimiento);
}