package com.cibertec.inventario.service;

import com.cibertec.inventario.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    List<Usuario> listarTodos();
    Optional<Usuario> buscarPorId(Long id);
    Optional<Usuario> buscarPorUsername(String username);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
    Usuario actualizarEstado(Long id, Boolean activo);
}