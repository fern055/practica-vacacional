public class TarifaMoto implements Tarifa{
    @Override
    public Double calcular(int h) {
        return (double) h;
    }
}
