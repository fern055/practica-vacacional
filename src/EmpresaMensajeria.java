import java.util.ArrayList;
import java.util.List;

public class EmpresaMensajeria {

    List<Paquete> paqueteList = new ArrayList<>();

    public void agregarPaquete(Paquete paquete){
        this.paqueteList.add(paquete);
    }

    public List<Paquete> imprimirListaPaquete(){ return this.paqueteList; }

    public double calcularTotalGanancias() {
        double totalAcumulado = 0.0;
        for (Paquete paquete: this.paqueteList){ totalAcumulado += paquete.obtenerCostoEnvio();}
        return totalAcumulado;
    }

}
