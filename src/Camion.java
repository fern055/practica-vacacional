public class Camion extends Vehiculo{
    public Camion(String placa, int horas){
        Tarifa TC = new TarifaCamion();
        super(placa, horas, TC);
    }
}
