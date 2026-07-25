public class PlanEstandar implements PlanSuscripcion{
    @Override
    public Double calcularCosto(int meses) {
        return (double) (meses * 9);
    }
}
