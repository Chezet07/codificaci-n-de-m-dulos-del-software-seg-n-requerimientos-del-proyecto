package com.asistente.IA;

import com.tuempresa.asistente.datos.OperacionesDB;

public class AsistenteApp {
    public static void main(String[] args) {
        OperacionesDB operaciones = new OperacionesDB();

        // Insertar un nuevo registro
        operaciones.insertar("Ejemplo", "Valor de ejemplo");

        // Consultar registros
        operaciones.consultar();

        // Actualizar un registro
        operaciones.actualizar(1, "Nuevo valor");

        // Eliminar un registro
        operaciones.eliminar(1);
    }
}
