// ─── EVENTO CLICK EDITAR ─────────────────────────────
document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.btn-editar-usuario').forEach(btn => {
        btn.addEventListener('click', function () {
            editarUsuario(
                this.dataset.id,
                this.dataset.username,
                this.dataset.nombre,
                this.dataset.rol
            );
        });
    });
});

function filtrarUsuarios() {
    const buscar = document.getElementById('buscadorUsuario').value.toLowerCase();
    const filas  = document.querySelectorAll('#tbodyUsuarios tr');
    filas.forEach(fila => {
        fila.style.display = fila.textContent.toLowerCase().includes(buscar) ? '' : 'none';
    });
}

function limpiarModalUsuario() {
    document.getElementById('modalTituloUsuario').innerHTML =
        '<i class="bi bi-person-plus me-2"></i>Nuevo Usuario';
    document.getElementById('uId').value       = '';
    document.getElementById('uNombre').value   = '';
    document.getElementById('uUsername').value = '';
    document.getElementById('uPassword').value = '';
    document.getElementById('uRol').value      = 'USER';
    document.getElementById('passHint').style.display = 'none';
}

function editarUsuario(id, username, nombre, rol) {
    document.getElementById('modalTituloUsuario').innerHTML =
        '<i class="bi bi-pencil me-2"></i>Editar Usuario';
    document.getElementById('uId').value       = id;
    document.getElementById('uNombre').value   = nombre;
    document.getElementById('uUsername').value = username;
    document.getElementById('uPassword').value = '';
    document.getElementById('uRol').value      = rol;
    document.getElementById('passHint').style.display = 'inline';

    new bootstrap.Modal(document.getElementById('modalUsuario')).show();
}

function togglePassModal() {
    const input = document.getElementById('uPassword');
    const icon  = document.getElementById('eyeIconModal');
    if (input.type === 'password') {
        input.type     = 'text';
        icon.className = 'bi bi-eye-slash';
    } else {
        input.type     = 'password';
        icon.className = 'bi bi-eye';
    }
}