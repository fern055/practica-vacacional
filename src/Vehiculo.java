import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Vehiculo {
    private int id;
    private String placa;
    private int horas;
    private Tarifa tarifas;

    public Vehiculo(){

    }

    private Vehiculo(int id, String placa, int horas) {
        this.id = id;
        this.placa = placa;
        this.horas = horas;
    }

    public Vehiculo(String placa, int horas, Tarifa tarifas) {
        this.placa = placa;
        this.horas = horas;
        this.tarifas = tarifas;
    }

    public int save() throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("insert into Estacionamiento.exa.Vehiculos (placa, horas, tarifas) values (?, ?, ?)");
        ){
            stmt.setString(1, this.placa);
            stmt.setInt(2, this.horas);
            return stmt.executeUpdate();
        }
    }

    //como le hago con tarifas?

    public static List<Vehiculo> showall() throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("select * from Estacionamiento.exa.Vehiculos")
        ){
            List<Vehiculo> vehiculos = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                vehiculos.add(new Vehiculo(rs.getInt("id"), rs.getString("placa"), rs.getInt("horas")));
            }
            return vehiculos;
        }
    }

    public static int delete(String placa) throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("delete from Estacionamiento.exa.Vehiculos where placa = ?")
        ){
            stmt.setString(1, placa);
            return stmt.executeUpdate();
        }
    }

    public int update(String placa) throws Exception{
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("update Estacionamiento.exa.Vehiculo set horas = ? where placa = ? ")
        ){
            stmt.setInt(1, this.horas);
            stmt.setInt(2, this.id);
            return stmt.executeUpdate();
        }
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public Tarifa getTarifas() {
        return tarifas;
    }

    public void setTarifas(Tarifa tarifas) {
        this.tarifas = tarifas;
    }

    public double calcularcosto(){
        return tarifas.calcular(this.horas);
    }
}
