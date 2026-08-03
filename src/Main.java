import Modelos.Alumno;

import java.util.Scanner;

public class Main {
    public static void main(String Args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int opcion = 0;
        int i = 0;
        while (opcion != 6) {
            System.out.println("Acciones: ");
            System.out.println("1) Guardar alumno");
            System.out.println("2) Mostrar listado de alumnos");
            System.out.println("3) Modificar alumno por matricula");
            System.out.println("4) Eliminar alumno por matricula");
            System.out.println("5) Mostrar cantidad de hombres y mujeres");
            System.out.println("6) Salir");
            opcion = scan.nextInt();

            switch(opcion) {
                case 1:
                    int j = i + 1;
                    System.out.println("Creando alumno");
                    System.out.println("Ingresa su matricula: ");
                    int matricula = scan.nextInt();
                    System.out.println("Ingresa el nombre: ");
                    String nombre = scan.nextLine();
                    System.out.println("Ingresa su edad: ");
                    int edad = scan.nextInt();
                    System.out.println("Ingresa su genero: ");
                    String sexo = scan.nextLine();
                    System.out.println("Ingresa su correo: ");
                    String correo = scan.nextLine();
                    Alumno a = new Alumno(j, matricula, nombre, edad, sexo, correo);
                    i = j;
                    a.guardar();
                    //tenia problemas en este parte y termine creando un paquete
                    //basado en el ejemplo de animales
                    //pero el problema era que me falto agregar throws Exception en main
                    System.out.println("Alumno creado y guardado");
                break;
                case 2:
                    System.out.println("Mostrando listado de alumnos");
                    for (Alumno a1 : Alumno.mostrar()){
                        System.out.println(a1.getNombre());
                    }
                break;
                case 3:
                    System.out.println("Modificando alumno");
                    System.out.println("Ingresa la matricula del alumno al que quieres modificar:");
                    matricula = scan.nextInt();
                    Alumno a2 = new Alumno(matricula);
                    a2.modificarpormatricula();

                break;
                case 4:
                    System.out.println("Eliminando alumno");
                    System.out.println("Ingresa la matricula del alumno al que quieres modificar:");
                    matricula = scan.nextInt();
                    Alumno a3 = new Alumno(matricula);
                    a3.eliminarpormatricula();
                break;
                case 5:

                break;
                case 6:
                    System.out.println("Proceso terminado");
                break;
                default:
                    System.out.println("Opcion no disponible");
                break;
            }
        }
    }
}