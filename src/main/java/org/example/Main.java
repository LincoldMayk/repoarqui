         System.out.print("Nuevo Nombre: ");
                    String nomAct = sc.nextLine();
                    System.out.print("Nuevo Correo: ");
                    String corAct = sc.nextLine();
                    if (service.actualizar(new Estudiante(idAct, nomAct, corAct))) {
                        System.out.println("Estudiante actualizado correctamente.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Id a eliminar: ");
                    int idElim = sc.nextInt();
                    sc.nextLine();
                    if (service.eliminar(idElim)) {
                        System.out.println("Estudiante eliminado correctamente.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }
}
