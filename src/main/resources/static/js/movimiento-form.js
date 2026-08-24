let stockActual = 0;
let tipoActual  = '';

// ─── INFO HERRAMIENTA ────────────────────────────────
function actualizarInfo() {
    const select = document.getElementById('selectHerramienta');
    const option = select.options[select.selectedIndex];

    if (!option.value) {
        document.getElementById('infoHerramienta').style.display = 'none';
        return;
    }

    stockActual = parseInt(option.dataset.stock) || 0;
    const estado    = option.dataset.estado    || '-';
    const ubicacion = option.dataset.ubicacion || '-';

    document.getElementById('infoStock').textContent    = stockActual;
    document.getElementById('infoEstado').textContent   = estado;
    document.getElementById('infoUbicacion').textContent = ubicacion;

    const iconEstado = document.getElementById('infoEstadoIcon');
    iconEstado.style.color = estado === 'DISPONIBLE' ? '#16a34a' :
                             estado === 'AGOTADO'    ? '#dc2626' : '#d97706';

    document.getElementById('infoHerramienta').style.display = 'block';
    actualizarPreview();
}

// ─── TIPO MOVIMIENTO ─────────────────────────────────
function cambiarTipo(tipo) {
    tipoActual = tipo;
    actualizarPreview();
}

// ─── VALIDAR CANTIDAD ────────────────────────────────
function validarCantidad() {
    const cantidad = parseInt(document.getElementById('inputCantidad').value) || 0;
    const error    = document.getElementById('errorCantidad');
    const btn      = document.getElementById('btnGuardar');

    if (tipoActual === 'SALIDA' && cantidad > stockActual) {
        error.style.display = 'block';
        btn.disabled        = true;
    } else {
        error.style.display = 'none';
        btn.disabled        = false;
    }
    actualizarPreview();
}

// ─── PREVIEW ─────────────────────────────────────────
function actualizarPreview() {
    const cantidad = parseInt(document.getElementById('inputCantidad').value) || 0;
    const preview  = document.getElementById('previewMovimiento');

    if (!tipoActual || cantidad <= 0 || !stockActual) {
        preview.style.display = 'none';
        return;
    }

    let stockDespues = tipoActual === 'ENTRADA'
        ? stockActual + cantidad
        : stockActual - cantidad;

    document.getElementById('previewStockActual').textContent  = stockActual;
    document.getElementById('previewStockDespues').textContent = stockDespues;

    const el = document.getElementById('previewStockDespues');
    el.style.color = stockDespues <= 0 ? '#dc2626' :
                     stockDespues <= 2 ? '#d97706' : '#16a34a';

    preview.style.display = 'block';
}

// ─── INIT ─────────────────────────────────────────────
document.addEventListener('DOMContentLoaded', function () {
    const select = document.getElementById('selectHerramienta');
    if (select.value) actualizarInfo();

    document.getElementById('inputCantidad')
            .addEventListener('input', actualizarPreview);
});