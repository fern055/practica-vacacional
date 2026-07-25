public class TarifaCamion implements Tarifa{
    @Override
    public Double calcular(int h) {
        return (double) (h * 4 + 5);
    }
}
