import java.util.ArrayList;
import java.util.List;

public class PlataformaStreaming {
    List<CuentaUsuario> LU =  new ArrayList<CuentaUsuario>();

    public void agregarCuentaUsuario(CuentaUsuario cuenta){ LU.add(cuenta); }

    public List<CuentaUsuario> mostrarListaCuentaUsuario() { return LU; }

    public double mostrarTotalRecaudado(){
        double totalRecaudado = 0;
        for (CuentaUsuario cuenta : LU) { totalRecaudado += cuenta.obtenerTotalAPagar(); }
        return totalRecaudado;
    }
}
