public class Moto extends Vehiculo{
    public Moto(String placa, int horas){
        Tarifa TM = new TarifaMoto();
        super(placa, horas, TM);
    }

    public String toString(){
        return "Moto";
    }
}
