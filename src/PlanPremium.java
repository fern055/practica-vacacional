public class PlanPremium implements PlanSuscripcion{
    @Override
    public Double calcularCosto(int meses) {
        return (double) (meses * 14) + 3;
    }
}
