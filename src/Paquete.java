import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Paquete {
    private int id;
    private String nombreDestinatario;
    private Double pesoKg;
    private EstrategiaEnvio estrategiaEnvio;

    public Paquete(){

    }

    private Paquete(int id, String nombreDestinatario, Double pesoKg) {
        this.id = id;
        this.nombreDestinatario = nombreDestinatario;
        this.pesoKg = pesoKg;
    }

    public Paquete(String nombreDestinatario, Double pesoKg) {
        this.nombreDestinatario = nombreDestinatario;
        this.pesoKg = pesoKg;
    }

    public Paquete(String nombreDestinatario, Double pesoKg, EstrategiaEnvio estrategiaEnvio) {
        this.nombreDestinatario = nombreDestinatario;
        this.pesoKg = pesoKg;
        this.estrategiaEnvio = estrategiaEnvio;
    }

    public int save() throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("insert into Paqueteria.exa.Paquetes (nombreDestinario, pesoKg) values (?, ?)")
        ){
            stmt.setString(1, this.nombreDestinatario);
            stmt.setDouble(2, this.pesoKg);
            return stmt.executeUpdate();
        }
    }

    public static List<Paquete> showall() throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("select * from Paqueteria.exa.Paquetes")
        ){
            List<Paquete> paquetes = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                paquetes.add(new Paquete(rs.getInt("id"), rs.getString("nombreDestinatario"), rs.getDouble("pesoKg")));
            }
            return paquetes;
        }
    }

    public int modify() throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("update Paqueteria.exa.Paquetes set nombreDestinatario = ?, pesoKg = ? where id = ?")
        ){
            stmt.setString(1, this.nombreDestinatario);
            stmt.setDouble(2, this.pesoKg);
            stmt.setInt(3, this.id);
            return stmt.executeUpdate();
        }
    }

    public static int delete(String nombreDestinatario) throws Exception{
        try(Connection con = Conexion.getConexion();
        PreparedStatement stmt = con.prepareStatement("delete from Paqueteria.exa.Paquetes where nombreDestinatario = ?")
        ){
            stmt.setString(1, nombreDestinatario);
            return stmt.executeUpdate();
        }
    }

    public Double obtenerCostoEnvio(){
        return this.estrategiaEnvio.calcularCosto(this.pesoKg);
    }
    public String getNombreDestinatario() {
        return nombreDestinatario;
    }
    public Double getPesoKg() {
        return pesoKg;
    }
    public EstrategiaEnvio getEstrategiaEnvio() {
        return estrategiaEnvio;
    }
    public void setEstrategiaEnvio(EstrategiaEnvio estrategiaEnvio) {
        this.estrategiaEnvio = estrategiaEnvio;
    }

    @Override
    public String toString() {return "Paquete: " + nombreDestinatario + pesoKg + estrategiaEnvio;}
}