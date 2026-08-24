package com.cibertec.inventario.controller;

import com.cibertec.inventario.model.*;
import com.cibertec.inventario.repository.UsuarioRepository;
import com.cibertec.inventario.service.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/almacenero")
@RequiredArgsConstructor
public class AlmaceneroController {

    private final HerramientaService herramientaService;
    private final MovimientoService movimientoService;
    private final UsuarioRepository usuarioRepository;

    //DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Herramienta> herramientas = herramientaService.listarTodas();
        List<Herramienta> stockBajo    = herramientaService.listarStockBajo();

        long disponibles = herramientas.stream()
                .filter(h -> h.getEstado().equals("DISPONIBLE")).count();
        long agotadas = herramientas.stream()
                .filter(h -> h.getEstado().equals("AGOTADO")).count();

        List<Herramienta> herramientasDisponibles = herramientas.stream()
                .filter(h -> h.getEstado().equals("DISPONIBLE"))
                .limit(6)
                .toList();

        model.addAttribute("herramientas", herramientas);
        model.addAttribute("stockBajo", stockBajo);
        model.addAttribute("disponibles", disponibles);
        model.addAttribute("agotadas", agotadas);
        model.addAttribute("herramientasDisponibles", herramientasDisponibles);

        return "almacenero/dashboard";
    }

    //VER INVENTARIO
    @GetMapping("/inventario")
    public String verInventario(
            @RequestParam(required = false) String buscar,
            @RequestParam(required = false) String categoria,
            Model model) {
        if (buscar != null && !buscar.isEmpty()) {
            model.addAttribute("herramientas",
                    herramientaService.buscarPorNombre(buscar));
        } else if (categoria != null && !categoria.isEmpty()) {
            model.addAttribute("herramientas",
                    herramientaService.buscarPorCategoria(categoria));
        } else {
            model.addAttribute("herramientas",
                    herramientaService.listarTodas());
        }
        return "almacenero/inventario";
    }

    //REGISTRAR MOVIMIENTO
    @GetMapping("/movimientos/nuevo")
    public String nuevoMovimiento(Model model) {
        model.addAttribute("movimiento", new Movimiento());
        model.addAttribute("herramientas", herramientaService.listarTodas());
        return "almacenero/movimiento-form";
    }

    @PostMapping("/movimientos/registrar")
    public String registrarMovimiento(
            @ModelAttribute Movimiento movimiento,
            Authentication auth,
            RedirectAttributes ra) {
        try {
            Usuario usuario = usuarioRepository
                    .findByUsername(auth.getName()).orElseThrow();
            movimiento.setUsuario(usuario);
            movimientoService.registrar(movimiento);
            ra.addFlashAttribute("mensaje", "Movimiento registrado correctamente");
        } catch (RuntimeException e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/almacenero/movimientos";
    }

    //HISTORIAL
    @GetMapping("/movimientos")
    public String verMovimientos(Authentication auth, Model model) {
        Usuario usuario = usuarioRepository
                .findByUsername(auth.getName()).orElseThrow();
        List<Movimiento> movimientos = movimientoService.listarPorUsuario(usuario.getId());

        long totalEntradas = movimientos.stream()
                .filter(m -> m.getTipo().equals("ENTRADA")).count();
        long totalSalidas = movimientos.stream()
                .filter(m -> m.getTipo().equals("SALIDA")).count();

        model.addAttribute("movimientos", movimientos);
        model.addAttribute("totalEntradas", totalEntradas);
        model.addAttribute("totalSalidas", totalSalidas);

        return "almacenero/movimientos";
    }
}