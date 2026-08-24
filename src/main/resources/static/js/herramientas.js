// ─── EVENTO CLICK EDITAR ─────────────────────────────
document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.btn-editar-herramienta').forEach(btn => {
        btn.addEventListener('click', function () {
            editarHerramienta(
                this.dataset.id,
                this.dataset.codigo,
                this.dataset.nombre,
                this.dataset.descripcion,
                this.dataset.categoria,
                this.dataset.stockactual,
                this.dataset.stockminimo,
                this.dataset.estado,
                this.dataset.ubicacion
            );
        });
    });
});

function filtrarTabla() {
    const buscar    = document.getElementById('buscador').value.toLowerCase();
    const categoria = document.getElementById('filtroCategoria').value.toLowerCase();
    const estado    = document.getElementById('filtroEstado').value.toLowerCase();
    const filas     = document.querySelectorAll('#tbodyHerramientas tr');

    filas.forEach(fila => {
        const texto        = fila.textContent.toLowerCase();
        const matchBuscar    = texto.includes(buscar);
        const matchCategoria = categoria === '' || texto.includes(categoria);
        const matchEstado    = estado    === '' || texto.includes(estado);
        fila.style.display   = (matchBuscar && matchCategoria && matchEstado) ? '' : 'none';
    });
}

function limpiarModal() {
    document.getElementById('modalTitulo').innerHTML =
        '<i class="bi bi-tools me-2"></i>Nueva Herramienta';
    document.getElementById('hId').value          = '';
    document.getElementById('hCodigo').value      = '';
    document.getElementById('hNombre').value      = '';
    document.getElementById('hDescripcion').value = '';
    document.getElementById('hCategoria').value   = '';
    document.getElementById('hUbicacion').value   = '';
    document.getElementById('hStockActual').value = '';
    document.getElementById('hStockMinimo').value = '';
    document.getElementById('hEstado').value      = 'DISPONIBLE';
}

function editarHerramienta(id, codigo, nombre, descripcion,
                            categoria, stockActual, stockMinimo,
                            estado, ubicacion) {
    document.getElementById('modalTitulo').innerHTML =
        '<i class="bi bi-pencil me-2"></i>Editar Herramienta';
    document.getElementById('hId').value          = id;
    document.getElementById('hCodigo').value      = codigo;
    document.getElementById('hNombre').value      = nombre;
    document.getElementById('hDescripcion').value = descripcion;
    document.getElementById('hCategoria').value   = categoria;
    document.getElementById('hStockActual').value = stockActual;
    document.getElementById('hStockMinimo').value = stockMinimo;
    document.getElementById('hEstado').value      = estado;
    document.getElementById('hUbicacion').value   = ubicacion;

    new bootstrap.Modal(document.getElementById('modalHerramienta')).show();
}