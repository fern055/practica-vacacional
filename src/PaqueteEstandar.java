public class PaqueteEstandar extends Paquete{
    public PaqueteEstandar(String nombreDestinatario, Double pesoKg, EnvioEstandar estrategiaEnvio) {
        super(nombreDestinatario, pesoKg, estrategiaEnvio);
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
