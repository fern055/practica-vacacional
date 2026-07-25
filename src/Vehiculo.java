public abstract class Vehiculo {
    private String placa;
    private int horas;
    private Tarifa tarifas;

    public Vehiculo(){

    }

    public Vehiculo(String placa, int horas, Tarifa tarifas) {
        this.placa = placa;
        this.horas = horas;
        this.tarifas = tarifas;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Tarifa getTarifas() {
        return tarifas;
    }

    public void setTarifas(Tarifa tarifas) {
        this.tarifas = tarifas;
    }

    public double calcularcosto(){
        return tarifas.calcular(this.horas);
    }
}
