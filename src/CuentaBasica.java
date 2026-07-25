public class CuentaBasica extends CuentaUsuario{

    public CuentaBasica(String correoElectronico, int mesesActivo) {
        super(correoElectronico,mesesActivo,new PlanBasico());
    }
    @Override
    public String toString() {
        return "CuentaBasica{}";
    }

}
