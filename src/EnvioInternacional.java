public class EnvioInternacional implements EstrategiaEnvio{
    @Override
    public Double calcularCosto(double pesoKg){
        return ((pesoKg * 6) + 10);
    }
}
