public class TarifaAuto implements Tarifa{
    @Override
    public Double calcular(int h) {
        return (double) (h * 2);
    }
}
