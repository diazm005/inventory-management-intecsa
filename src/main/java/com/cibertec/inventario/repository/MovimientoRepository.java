package com.cibertec.inventario.repository;
import com.cibertec.inventario.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {

	List<Movimiento> findByHerramientaId(Long herramientaId);
    List<Movimiento> findByUsuarioId(Long usuarioId);
    List<Movimiento> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
    List<Movimiento> findByTipo(String tipo);
}
