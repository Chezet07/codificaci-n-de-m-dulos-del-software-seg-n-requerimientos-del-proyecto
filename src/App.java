package com.ia.asistente;

import com.ia.asistente.controller.AsistenteController;
import com.ia.asistente.model.Documento;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Bienvenido a IA Asistente");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar documento");
        System.out.println("2. Obtener documento");
        System.out.println("3. Actualizar documento");
        System.out.println("4. Eliminar documento");
        System.out.println("5. Obtener todos los documentos");
        System.out.println("6. Salir");

        try (Scanner scanner = new Scanner(System.in)) {
            AsistenteController controller = new AsistenteController();
            boolean continuar = true;

            while (continuar) {
                System.out.print("Ingrese su opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del documento: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el contenido del documento: ");
                        String contenido = scanner.nextLine();
                        Documento nuevoDocumento = new Documento();
                        nuevoDocumento.setNombre(nombre);
                        nuevoDocumento.setContenido(contenido);
                        controller.agregarDocumento(nuevoDocumento);
                        break;
                    case 2:
                        System.out.print("Ingrese el ID del documento: ");
                        int id = scanner.nextInt();
                        Documento documento = controller.obtenerDocumento(id);
                        if (documento != null) {
                            System.out.println("Documento encontrado: " + documento.getNombre());
                        } else {
                            System.out.println("Documento no encontrado.");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el ID del documento a actualizar: ");
                        int idActualizar = scanner.nextInt();
                        scanner.nextLine(); // Consumir el salto de línea
                        System.out.print("Ingrese el nuevo nombre del documento: ");
                        String nuevoNombre = scanner.nextLine();
                        System.out.print("Ingrese el nuevo contenido del documento: ");
                        String nuevoContenido = scanner.nextLine();
                        Documento documentoActualizar = new Documento();
                        documentoActualizar.setId(idActualizar);
                        documentoActualizar.setNombre(nuevoNombre);
                        documentoActualizar.setContenido(nuevoContenido);
                        controller.actualizarDocumento(documentoActualizar);
                        break;
                    case 4:
                        System.out.print("Ingrese el ID del documento a eliminar: ");
                        int idEliminar = scanner.nextInt();
                        controller.eliminarDocumento(idEliminar);
                        break;
                    case 5:
                        System.out.println("Lista de documentos:");
                        for (Documento doc : controller.obtenerTodosLosDocumentos()) {
                            System.out.println(doc.getId() + ": " + doc.getNombre());
                        }
                        break;
                    case 6:
                        continuar = false;
                        controller.cerrarConexion();
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

