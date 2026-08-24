package com.cibertec.inventario.service.impl;

import com.cibertec.inventario.model.Herramienta;
import com.cibertec.inventario.repository.HerramientaRepository;
import com.cibertec.inventario.service.HerramientaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HerramientaServiceImpl implements HerramientaService {

    private final HerramientaRepository herramientaRepository;

    @Override
    public List<Herramienta> listarTodas() {
        return herramientaRepository.findAll();
    }

    @Override
    public Optional<Herramienta> buscarPorId(Long id) {
        return herramientaRepository.findById(id);
    }

    @Override
    public List<Herramienta> buscarPorNombre(String nombre) {
        return herramientaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Herramienta> buscarPorCategoria(String categoria) {
        return herramientaRepository.findByCategoria(categoria);
    }

    @Override
    public List<Herramienta> listarStockBajo() {
        return herramientaRepository.findAll().stream()
                .filter(h -> h.getStockActual() <= h.getStockMinimo())
                .toList();
    }

    @Override
    public Herramienta guardar(Herramienta herramienta) {
        if (herramienta.getStockActual() <= 0) {
            herramienta.setEstado("AGOTADO");
        } else {
            herramienta.setEstado("DISPONIBLE");
        }
        return herramientaRepository.save(herramienta);
    }

    @Override
    public void eliminar(Long id) {
        herramientaRepository.deleteById(id);
    }
}