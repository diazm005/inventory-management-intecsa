package com.cibertec.inventario.controller;

import com.cibertec.inventario.model.*;
import com.cibertec.inventario.service.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final HerramientaService herramientaService;
    private final UsuarioService usuarioService;
    private final MovimientoService movimientoService;

    //DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Herramienta> herramientas = herramientaService.listarTodas();
        List<Movimiento> movimientos   = movimientoService.listarTodos();

        long totalEntradas = movimientos.stream()
                .filter(m -> m.getTipo().equals("ENTRADA")).count();
        long totalSalidas  = movimientos.stream()
                .filter(m -> m.getTipo().equals("SALIDA")).count();

        List<Movimiento> ultimos = movimientos.stream()
                .sorted((a, b) -> b.getFecha().compareTo(a.getFecha()))
                .limit(5)
                .toList();

        model.addAttribute("totalHerramientas", herramientas.size());
        model.addAttribute("stockBajo", herramientaService.listarStockBajo().size());
        model.addAttribute("totalUsuarios", usuarioService.listarTodos().size());
        model.addAttribute("ultimosMovimientos", ultimos);
        model.addAttribute("totalEntradas", totalEntradas);
        model.addAttribute("totalSalidas", totalSalidas);

        return "admin/dashboard";
    }

    //HERRAMIENTAS

    @GetMapping("/herramientas")
    public String listarHerramientas(Model model) {
        model.addAttribute("herramientas", herramientaService.listarTodas());
        model.addAttribute("herramienta", new Herramienta());
        return "admin/herramientas";
    }

    @PostMapping("/herramientas/guardar")
    public String guardarHerramienta(@ModelAttribute Herramienta herramienta,
            RedirectAttributes ra) {
        herramientaService.guardar(herramienta);
        ra.addFlashAttribute("mensaje", "Herramienta guardada correctamente");
        return "redirect:/admin/herramientas";
    }

    @GetMapping("/herramientas/editar/{id}")
    public String editarHerramienta(@PathVariable Long id, Model model) {
        model.addAttribute("herramienta",
                herramientaService.buscarPorId(id).orElseThrow());
        model.addAttribute("herramientas", herramientaService.listarTodas());
        return "admin/herramientas";
    }

    @GetMapping("/herramientas/eliminar/{id}")
    public String eliminarHerramienta(@PathVariable Long id,
            RedirectAttributes ra) {
        herramientaService.eliminar(id);
        ra.addFlashAttribute("mensaje", "Herramienta eliminada");
        return "redirect:/admin/herramientas";
    }

    //USUARIOS

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        model.addAttribute("usuario", new Usuario());
        return "admin/usuarios";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario,
            RedirectAttributes ra) {
        usuarioService.guardar(usuario);
        ra.addFlashAttribute("mensaje", "Usuario guardado correctamente");
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/usuarios/toggle/{id}")
    public String toggleUsuario(@PathVariable Long id, RedirectAttributes ra) {
        usuarioService.listarTodos().stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .ifPresent(u -> usuarioService.actualizarEstado(id, !u.getActivo()));
        ra.addFlashAttribute("mensaje", "Estado actualizado");
        return "redirect:/admin/usuarios";
    }

    //MOVIMIENTOS

    @GetMapping("/movimientos")
    public String listarMovimientos(Model model) {
        model.addAttribute("movimientos", movimientoService.listarTodos());
        return "admin/movimientos";
    }
}