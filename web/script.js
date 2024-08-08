document.getElementById('insertForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const nombre = document.getElementById('nombre').value;
    const valor = document.getElementById('valor').value;

    fetch('/insertar', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nombre: nombre, valor: valor })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Insertar:', data);
        alert('Registro insertado correctamente');
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('consultarBtn').addEventListener('click', function() {
    fetch('/consultar')
    .then(response => response.json())
    .then(data => {
        const resultados = document.getElementById('resultados');
        resultados.innerHTML = '';
        data.forEach(item => {
            resultados.innerHTML += `<p>ID: ${item.id}, Nombre: ${item.nombre}, Valor: ${item.valor}</p>`;
        });
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('updateForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const id = document.getElementById('idActualizar').value;
    const nuevoValor = document.getElementById('nuevoValor').value;

    fetch('/actualizar', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id: id, valor: nuevoValor })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Actualizar:', data);
        alert('Registro actualizado correctamente');
    })
    .catch(error => console.error('Error:', error));
});

document.getElementById('deleteForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const id = document.getElementById('idEliminar').value;

    fetch('/eliminar', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id: id })
    })
    .then(response => response.json())
    .then(data => {
        console.log('Eliminar:', data);
        alert('Registro eliminado correctamente');
    })
    .catch(error => console.error('Error:', error));
});
