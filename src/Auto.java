public class Auto extends Vehiculo{
    public Auto (String placa, int horas){
        Tarifa TA = new TarifaAuto();
        super(placa, horas, TA);
    }

    public String toString(){
        return "Auto";
    }
}
