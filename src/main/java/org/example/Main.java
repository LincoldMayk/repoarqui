package org.example;

import org.example.business.Estudiante;
import org.example.business.EstudianteService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EstudianteService service = new EstudianteService();

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE ESTUDIANTES =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Listar estudiantes");
            System.out.println("3. Actualizar estudiante");
            System.out.println("4. Eliminar estudiante");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Id: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Correo: ");
                    String correo = sc.nextLine();

                    service.registrar(new Estudiante(id, nombre, correo));

                    System.out.println("Estudiante registrado correctamente.");
                    break;

                case 2:
                    List<Estudiante> estudiantes = service.listar();

                    System.out.println("\n===== LISTA DE ESTUDIANTES =====");

                    for (Estudiante e : estudiantes) {
                        System.out.println(
                                "ID: " + e.getId()
                                + " | Nombre: " + e.getNombre()
                                + " | Correo: " + e.getCorreo()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Id a actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo Nombre: ");
                    String nomAct = sc.nextLine();

                    System.out.print("Nuevo Correo: ");
                    String corAct = sc.nextLine();

                    if (service.actualizar(
                            new Estudiante(idAct, nomAct, corAct))) {

                        System.out.println(
                                "Estudiante actualizado correctamente.");

                    } else {
                        System.out.println(
                                "Estudiante no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Id a eliminar: ");
                    int idElim = sc.nextInt();
                    sc.nextLine();

                    if (service.eliminar(idElim)) {
                        System.out.println(
                                "Estudiante eliminado correctamente.");
                    } else {
                        System.out.println(
                                "Estudiante no encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
