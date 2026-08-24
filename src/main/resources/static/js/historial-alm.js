function filtrarHistorial() {
    const buscar = document.getElementById('buscadorHist').value.toLowerCase();
    const tipo   = document.getElementById('filtroTipoHist').value.toLowerCase();
    const filas  = document.querySelectorAll('#tbodyHistorial tr');

    filas.forEach(fila => {
        const texto       = fila.textContent.toLowerCase();
        const matchBuscar = texto.includes(buscar);
        const matchTipo   = tipo === '' || texto.includes(tipo);
        fila.style.display = (matchBuscar && matchTipo) ? '' : 'none';
    });
}

function limpiarFiltrosHist() {
    document.getElementById('buscadorHist').value    = '';
    document.getElementById('filtroTipoHist').value  = '';
    filtrarHistorial();
}