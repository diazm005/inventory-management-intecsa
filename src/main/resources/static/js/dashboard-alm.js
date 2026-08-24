document.addEventListener('DOMContentLoaded', function () {
    const fecha = new Date();
    const opciones = {
        weekday: 'long',
        year: 'numeric',
        month: 'long',
        day: 'numeric'
    };
    const el = document.getElementById('fechaHoy');
    if (el) {
        el.textContent = fecha.toLocaleDateString('es-PE', opciones);
    }
});