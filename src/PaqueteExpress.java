public class PaqueteExpress extends Paquete{
    public PaqueteExpress(String nombreDestinatario, Double pesoKg, EnvioExpress estrategiaEnvio) {
        super(nombreDestinatario, pesoKg, estrategiaEnvio);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
