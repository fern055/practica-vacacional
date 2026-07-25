public class PlanBasico implements PlanSuscripcion{
    @Override
    public Double calcularCosto(int meses) {
        return (double) (meses * 5);
    }
}
