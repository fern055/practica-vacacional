public class CuentaEstandar extends CuentaUsuario{

    public CuentaEstandar(String correoElectronico, int mesesActivo) {
        super(correoElectronico,mesesActivo,new PlanEstandar());
    }
    @Override
    public String toString() {
        return "CuentaEstandar{}";
    }
}
