public class EnvioEstandar implements EstrategiaEnvio{
    @Override
    public Double calcularCosto(double pesoKg){
        return (pesoKg * 2);
    }
}
