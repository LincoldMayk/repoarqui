package org.example.presentacion;
import org.example.business.Estudiante;
import org.example.business.EstudiateService;
import java.util.Scanner;


public class EstudianteUI {
    private static final EstudiateService service= new EstudiateService();
    public static void mostrarMenu(Scanner sc){
        int opcion;
        do{
            System.out.println("\n=== GESTIÓN ESTUDIANTE ===");
            System.out.println("1.Registrar ");
            System.out.println("2.Listar");
            System.out.println("3. Actualizar");
            System.out.print("4.Eliminar ");
            System.out.print("0.Regresar ");
            System.out.print("Sellecione una opcion ")
            opcion=sc.nextInt();
            sc.nextLine();
            switch (opcion){
            case 1:
                System.out.print("Id:");
                int id= sc.nextInt();
                sc.nextLine();
                System.out.print("Nombre:");
                String nombre=sc.nextLine();
                System.out.print("Correo:");
                String correo=sc.nextLine();
                service.registrar(new Estudiante(id, nombre,correo));
                System.out.println("Estudiante Registrado");
                break;
            case 2:
                service.listar().forEach(e-> System.out.println(e.getId()+" "+e.getNombre()+" "+ e.getCorreo()+"\n"));
                break;
            case 3:
                break;
            case 4:
                break;

            }


        } while (opcion!=0);


    }
}
