function filtrarInventario() {
    const buscar  = document.getElementById('buscadorInv').value.toLowerCase();
    const categ   = document.getElementById('filtroCateg').value.toLowerCase();
    const estado  = document.getElementById('filtroEst').value.toLowerCase();
    const filas   = document.querySelectorAll('#tbodyInv tr');

    filas.forEach(fila => {
        const texto       = fila.textContent.toLowerCase();
        const matchBuscar = texto.includes(buscar);
        const matchCateg  = categ  === '' || texto.includes(categ);
        const matchEstado = estado === '' || texto.includes(estado);
        fila.style.display = (matchBuscar && matchCateg && matchEstado) ? '' : 'none';
    });
}

function limpiarFiltros() {
    document.getElementById('buscadorInv').value = '';
    document.getElementById('filtroCateg').value = '';
    document.getElementById('filtroEst').value   = '';
    filtrarInventario();
}