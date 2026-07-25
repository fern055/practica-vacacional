import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    PlanBasico planB = new PlanBasico();
    PlataformaStreaming ps = new PlataformaStreaming();
    CuentaUsuario usuario0 = new CuentaBasica("usuario0@prueba.com", 6);
    ps.agregarCuentaUsuario(usuario0);
    CuentaUsuario usuario01 = new CuentaEstandar("usuario01@prueba.com", 12);
    ps.agregarCuentaUsuario(usuario01);
    CuentaUsuario usuario02 = new CuentaPremium("usuario02@prueba.com", 3);
    ps.agregarCuentaUsuario(usuario02);

    Scanner sc = new Scanner(System.in);
    int opcion;
    int op;

    do{
      System.out.println("Seleccione la accion que desea realizar: ");
      System.out.println("1.Cuenta usuario");
      System.out.println("2.Mostrar lista de cuentas y dinero recaudado");
      System.out.println("3.Salir");
      opcion = sc.nextInt();
      switch (opcion){

        case 1:
          System.out.println("Seleccione el tipo de cuenta: ");
          System.out.println("1.Basica");
          System.out.println("2.Estandar");
          System.out.println("3.Premium");
          int opcionCuenta = sc.nextInt();
          switch (opcionCuenta){
            case 1:
              System.out.println("Ingrese el correo electronico: ");
              String correoElectronico = sc.next();
              System.out.println("Ingrese el numero de meses activos: ");
              int mesesActivo = sc.nextInt();
              CuentaBasica cuentaBasica = new CuentaBasica(correoElectronico,mesesActivo);
              ps.agregarCuentaUsuario(cuentaBasica);
              break;
            case 2:
              System.out.println("Ingrese el correo electronico: ");
              String correoEstandar = sc.next();
              System.out.println("Ingrese el numero de meses activos: ");
              int mesesEstandar = sc.nextInt();
              CuentaEstandar cuentaEstandar = new CuentaEstandar(correoEstandar,mesesEstandar);
              ps.agregarCuentaUsuario(cuentaEstandar);
              break;
            case 3:
              System.out.println("Ingrese el correo electronico: ");
              String correoPremium = sc.next();
              System.out.println("Ingrese el numero de meses activos: ");
              int mesesPremium = sc.nextInt();
              CuentaPremium cuentaPremium = new CuentaPremium(correoPremium,mesesPremium);
              ps.agregarCuentaUsuario(cuentaPremium);
              break;
          }
          break;
        case 2:
          System.out.println(ps.mostrarListaCuentaUsuario());
          System.out.println(ps.mostrarTotalRecaudado());
          break;
        case 3:
          System.exit(0);
          break;
      }
      System.out.println("¿Desea continuar?");
      System.out.println("1.Si");
      System.out.println("2.No");
      op = sc.nextInt();
    }while (op == 1);

    System.out.println("Aqui termine el menu");

  }
}