import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CuentaUsuario {
    private int id;
    private String correoElectronico;
    private int mesesActivo;
    private PlanSuscripcion plan;

    private CuentaUsuario(int id, String correoElectronico, int mesesActivo) {
        this.id = id;
        this.correoElectronico = correoElectronico;
        this.mesesActivo = mesesActivo;
    }

    public CuentaUsuario(String correoElectronico, int mesesActivo) {
        this.correoElectronico = correoElectronico;
        this.mesesActivo = mesesActivo;
    }

    public CuentaUsuario(String correoElectronico, int mesesActivo, PlanSuscripcion plan) {
        this.correoElectronico = correoElectronico;
        this.mesesActivo = mesesActivo;
        this.plan = plan;
    }

    public int save() throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("insert into Streaming.exa.Cuentas (correoElectronico, mesesActivos) values (?, ?)")
        ){
            stmt.setString(1, this.correoElectronico);
            stmt.setInt(2, this.mesesActivo);
            return stmt.executeUpdate();
        }
    }

    public static List<CuentaUsuario> showall() throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("select * from Streaming.exa.Cuentas")
        ){
            List<CuentaUsuario> cuentas = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                cuentas.add(new CuentaUsuario(rs.getInt("id"), rs.getString("correoElectronico"), rs.getInt("mesesActivo")));
            }
            return cuentas;
        }
    }

    public int update(String correoElectronico) throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("update Streaming.exa.Cuentas set correoEñectronico = ?, mesesActivo = ? where correoElectronico = ?")
        ){
            stmt.setString(1, this.correoElectronico);
            stmt.setInt(2, this.mesesActivo);
            return stmt.executeUpdate();
        }
    }

    public static int delete(String correoElectronico) throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("delete from Streaming.exa.Cuentas where correoElectronico = ?")
        ){
            stmt.setString(1, correoElectronico);
            return stmt.executeUpdate();
        }
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
