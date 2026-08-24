package com.cibertec.inventario.service.impl;

import com.cibertec.inventario.model.Herramienta;
import com.cibertec.inventario.model.Movimiento;
import com.cibertec.inventario.repository.HerramientaRepository;
import com.cibertec.inventario.repository.MovimientoRepository;
import com.cibertec.inventario.service.MovimientoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimientoServiceImpl implements MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final HerramientaRepository herramientaRepository;

    @Override
    public List<Movimiento> listarTodos() {
        return movimientoRepository.findAll();
    }

    @Override
    public List<Movimiento> listarPorHerramienta(Long herramientaId) {
        return movimientoRepository.findByHerramientaId(herramientaId);
    }

    @Override
    public List<Movimiento> listarPorUsuario(Long usuarioId) {
        return movimientoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Movimiento> listarPorFechas(LocalDateTime inicio, LocalDateTime fin) {
        return movimientoRepository.findByFechaBetween(inicio, fin);
    }

    @Override
    @Transactional
    public Movimiento registrar(Movimiento movimiento) {
        Herramienta herramienta = herramientaRepository.findById(
                movimiento.getHerramienta().getId())
                .orElseThrow(() -> new RuntimeException("Herramienta no encontrada"));

        if (movimiento.getTipo().equals("ENTRADA")) {
            herramienta.setStockActual(herramienta.getStockActual() + movimiento.getCantidad());
        } else if (movimiento.getTipo().equals("SALIDA")) {
            if (herramienta.getStockActual() < movimiento.getCantidad()) {
                throw new RuntimeException("Stock insuficiente");
            }
            herramienta.setStockActual(herramienta.getStockActual() - movimiento.getCantidad());
        }

        if (herramienta.getStockActual() <= 0) {
            herramienta.setEstado("AGOTADO");
        } else {
            herramienta.setEstado("DISPONIBLE");
        }

        herramientaRepository.save(herramienta);
        movimiento.setFecha(LocalDateTime.now());
        return movimientoRepository.save(movimiento);
    }
}