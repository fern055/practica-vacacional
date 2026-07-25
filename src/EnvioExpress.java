public class EnvioExpress implements EstrategiaEnvio{
    @Override
    public Double calcularCosto(double pesoKg){
        return ((pesoKg * 4.5) + 3);
    }
}
