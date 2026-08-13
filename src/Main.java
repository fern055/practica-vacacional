import java.util.Scanner;

public class Main {
    public static void Main(String Args[]) {
        Scanner scan = new Scanner(System.in);
        Estacionamiento parking = new Estacionamiento();
        int opcion = 0;
        System.out.println("Sistema de Gestion de Estacionamiento");
        System.out.println("Incluyendo tarifas");
        while(opcion != 4) {
            System.out.println("-------------------------");
            System.out.println("Que accion vas a realizar: ");
            System.out.println("1) Registrar nuevo vehiculo");
            System.out.println("2) Mostrar vehiculos");
            System.out.println("3) Mostrar cantidad de vehiculos por cantidad");
            System.out.println("4) Salir");
            opcion = scan.nextInt();
            System.out.println("-------------------------");
            switch(opcion){
                case 1:
                    System.out.println("Registrando vehiculo...");
                    System.out.println("-------------------------");
                    int opcveh = 0;
                    while(opcveh < 1 && opcveh > 3) {
                        System.out.println("Que tipo de vehiculo es: ");
                        System.out.println("1) Auto");
                        System.out.println("2) Moto");
                        System.out.println("3) Camion");
                        opcveh = scan.nextInt();
                        switch(opcveh){
                            case 1:
                                System.out.println("Ingresa su placa: ");
                                String placa = scan.next();
                                System.out.println("Cuantas horas lleva estacionado: ");
                                int horas = scan.nextInt();
                                Vehiculo v1 = new Auto(placa, horas);
                                parking.registrar(v1);
                                System.out.println("Vehiculo registrado");
                                break;
                            case 2:
                                System.out.println("Ingresa su placa: ");
                                placa = scan.next();
                                System.out.println("Cuantas horas lleva estacionado: ");
                                horas = scan.nextInt();
                                Vehiculo v2 = new Moto(placa, horas);
                                parking.registrar(v2);
                                System.out.println("Vehiculo registrado");
                                break;
                            case 3:
                                System.out.println("Ingresa su placa: ");
                                placa = scan.next();
                                System.out.println("Cuantas horas lleva estacionado: ");
                                horas = scan.nextInt();
                                Vehiculo v3 = new Camion(placa, horas);
                                parking.registrar(v3);
                                System.out.println("Vehiculo registrado");
                                break;
                            default:
                                System.out.println("Tipo de vehiculo invalido");
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Mostrando todos los vehiculos...");
                    System.out.println("-------------------------");
                    parking.mostrartodo();
                    break;
                case 3:
                    System.out.println("Mostrando cantidad por separado");
                    System.out.println("-------------------------");
                    parking.mostrarcantidad();
                    break;
                case 4:
                    System.out.println("Muchas gracias");
                    break;
                default:
                    System.out.println("Opcion no disponible");
                    break;
            }
        }
    }
}