import java.util.ArrayList;
import java.util.List;

public class Estacionamiento {
    List <Vehiculo> vehiculos = new ArrayList<>();

    public void registrar(Vehiculo v){
        vehiculos.add(v);
    }

    public void mostrartodo(){
        Double total = 0.0;
        for (Vehiculo v : vehiculos){
            System.out.println("Placa: " + v.getPlaca());
            System.out.println("Tipo de vehiculo: " + v.toString());
            System.out.println("Horas estacionado: " + v.getHoras());
            System.out.println("Cobro: " + v.calcularcosto());
            total = total + v.calcularcosto();
            System.out.println("-------------------------");
        }
        System.out.println("=========================");
        System.out.println("Total recaudado: " + total);
    }

    public void mostrarcantidad(){
        int cantauto = 0;
        int cantmoto = 0;
        int cantcam = 0;
        for (Vehiculo v : vehiculos){
            if(v instanceof Auto){
                cantauto++;
            }
            if(v instanceof Moto){
                cantmoto++;
            }
            if(v instanceof Camion){
                cantcam++;
            }
        }
        System.out.println("Autos: " + cantauto);
        System.out.println("Motos: " + cantmoto);
        System.out.println("Camiones: " + cantcam);
    }
}
