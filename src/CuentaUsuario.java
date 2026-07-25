public abstract class CuentaUsuario {

    private String correoElectronico;
    private int mesesActivo;
    private PlanSuscripcion plan;


    public CuentaUsuario(String correoElectronico, int mesesActivo, PlanSuscripcion plan) {
        this.correoElectronico = correoElectronico;
        this.mesesActivo = mesesActivo;
        this.plan = plan;
    }

    public Double obtenerTotalAPagar(){
        return plan.calcularCosto(mesesActivo);
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getMesesActivo() {
        return mesesActivo;
    }

    public void setMesesActivo(int mesesActivo) {
        this.mesesActivo = mesesActivo;
    }

    public PlanSuscripcion getPlan() {
        return plan;
    }

    public void setPlan(PlanSuscripcion plan) {
        this.plan = plan;
    }

    @Override
    public String toString() {
        return "CuentaUsuario" +
                " correoElectronico: " + correoElectronico +
                ", mesesActivo: " + mesesActivo +
                ", plan: " + plan;
    }
}
