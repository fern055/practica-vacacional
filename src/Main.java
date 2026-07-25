import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    EmpresaMensajeria empresa = new EmpresaMensajeria();
    int opcion;
    int op;

    do{
      System.out.println("Ingrese una opcion");
      System.out.println("1.Paquete");
      System.out.println("2.Reporte final");
      System.out.println("3.Salir");
      opcion = sc.nextInt();
      switch (opcion){
        case 1:
          System.out.println("Seleccionar el tipo de envio: ");
          System.out.println("1. Estandar");
          System.out.println("2. Express");
          System.out.println("3. Internacional");
          int opcenv = sc.nextInt();
          switch(opcenv) {
            case 1:
              System.out.println("Cual es el nombre del destinatario: ");
              String nombreDestinatario = sc.next();
              System.out.println("Cuanto pesa en Kg");
              Double pesoKg = sc.nextDouble();
              EnvioEstandar envioEstandar = new EnvioEstandar();
              envioEstandar.calcularCosto(pesoKg);
              PaqueteEstandar envest = new PaqueteEstandar(nombreDestinatario, pesoKg, envioEstandar);
              empresa.agregarPaquete(envest);
              break;
            case 2:
              System.out.println("Cual es el nombre del destinatario: ");
              String nombreDestinatarioExpress = sc.next();
              System.out.println("Cuanto pesa en Kg");
              Double pesoKgExpress = sc.nextDouble();
              EnvioExpress envioExpress = new EnvioExpress();
              PaqueteExpress envesxp = new PaqueteExpress (nombreDestinatarioExpress, pesoKgExpress, envioExpress);
              empresa.agregarPaquete(envesxp);
              break;
            case 3:
              System.out.println("Cual es el nombre del destinatario: ");
              String nombreDestinatarioInternacional = sc.next();
              System.out.println("Cuanto pesa en Kg");
              Double pesoKgInternacional = sc.nextDouble();
              EnvioInternacional envioInternacional = new EnvioInternacional();
              PaqueteInternacional envint = new PaqueteInternacional (nombreDestinatarioInternacional, pesoKgInternacional,envioInternacional);
              empresa.agregarPaquete(envint);
              break;
          }
          break;
        case 2:
          System.out.println(empresa.imprimirListaPaquete());
          System.out.println(empresa.calcularTotalGanancias());
          break;
        case 3:
          System.exit(0);
          break;
      }
      System.out.println("Desea continuar?");
      System.out.println("1.Si");
      System.out.println("2.No");
      op = sc.nextInt();
    }while(op == 1);
  }
}