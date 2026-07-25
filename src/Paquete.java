public abstract class Paquete {
    private String nombreDestinatario;
    private Double pesoKg;
    private EstrategiaEnvio estrategiaEnvio;

    public Paquete(){

    }

    public Paquete(String nombreDestinatario, Double pesoKg, EstrategiaEnvio estrategiaEnvio) {
        this.nombreDestinatario = nombreDestinatario;
        this.pesoKg = pesoKg;
        this.estrategiaEnvio = estrategiaEnvio;
    }

    public Double obtenerCostoEnvio(){
        return this.estrategiaEnvio.calcularCosto(this.pesoKg);
    }
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }
    public Double getPesoKg() {
        return pesoKg;
    }
    public EstrategiaEnvio getEstrategiaEnvio() {
        return estrategiaEnvio;
    }
    public void setEstrategiaEnvio(EstrategiaEnvio estrategiaEnvio) {
        this.estrategiaEnvio = estrategiaEnvio;
    }

    @Override
    public String toString() {return "Paquete: " + nombreDestinatario + pesoKg + estrategiaEnvio;}
}