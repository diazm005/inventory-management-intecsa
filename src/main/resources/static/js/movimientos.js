// ─── FILTRO MOVIMIENTOS ──────────────────────────────
function filtrarMovimientos() {
    const buscar = document.getElementById('buscadorMov').value.toLowerCase();
    const tipo   = document.getElementById('filtroTipo').value.toLowerCase();
    const filas  = document.querySelectorAll('#tbodyMovimientos tr');

    filas.forEach(fila => {
        const texto      = fila.textContent.toLowerCase();
        const matchBuscar = texto.includes(buscar);
        const matchTipo   = tipo === '' || texto.includes(tipo);
        fila.style.display = (matchBuscar && matchTipo) ? '' : 'none';
    });
}