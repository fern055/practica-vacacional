package Modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private int id;
    private int matricula; 
    private String nombre;
    private int edad;
    private String sexo;
    private String correo;

    private Alumno(int id, int matricula, String nombre, int edad, String sexo, String correo) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
    }

    public Alumno(int matricula, String nombre, int edad, String sexo, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.correo = correo;
    }

    public Alumno(int matricula){
        this.matricula = matricula;
    }

    public int guardar() throws Exception {
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("insert into Alumnos_DB.exa.Alumnos (matricula, nombre, edad, sexo, correo) values(?, ?, ?, ?, ?)");
        ) {
            stmt.setInt(1, this.matricula);
            stmt.setString(2, this.nombre);
            stmt.setInt(3, this.edad);
            stmt.setString(4, this.sexo);
            stmt.setString(5, this.correo);
            return stmt.executeUpdate();
        }
    }

    public static List<Alumno> mostrar() throws Exception {
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("select * from Alumnos_DB.exa.Alumnos");
            ResultSet rs = stmt.executeQuery();
                ){
                    List <Alumno> lista = new ArrayList<>();
                    while(rs.next()){
                        lista.add(new Alumno(rs.getInt("id"),
                                rs.getInt("matricula"),
                                rs.getString("nombre"),
                                rs.getInt("edad"),
                                rs.getString("sexo"),
                                rs.getString("correo")));
                    }
                    return lista;
        }
    }

    public static Alumno buscarpormatricula(int matricula) throws Exception {
        try( Connection con= Conexion.getConexion();
        PreparedStatement stmt = con.prepareStatement("select * from Alumnos_DB.exa.Alumnos where matricula = ?");
        ) {
            stmt.setInt(1, matricula);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Alumno(rs.getInt("id"), rs.getInt("matricula"), rs.getString("nombre"), rs.getInt("edad"), rs.getString("sexo"), rs.getString("correo"));
            }
            return null;
        }
    }

    public int modificarpormatricula(int matricula) throws Exception {
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("update Alumnos_DB.exa.Alumnos set nombre = ?, edad = ?, sexo = ?, correo = ? where matricula = ?");
        ){
            stmt.setString(1, this.nombre);
            stmt.setInt(2, this.edad);
            stmt.setString(3, this.sexo);
            stmt.setString(4, this.correo);
            stmt.setInt(5, this.matricula);
            stmt.setInt(6, this.id);
            return stmt.executeUpdate();
        }
    }

    public static int eliminarpormatricula(int matricula) throws Exception {
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("delete from Alumnos_DB.exa.Alumnos where matricula = ?");
        ) {
            stmt.setInt(1, matricula);
            return stmt.executeUpdate();
        }
    }

    public static int conteohym() throws Exception {
        try(Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement("select sexo, count(*) as total_count from Alumnos_DB.exa.Alumnos group by sexo");
            ResultSet rs = stmt.executeQuery();
        ){
            while(rs.next()){
                rs.getString("sexo");
                rs.getInt("total_count");
            }
            return stmt.executeUpdate();
            //no estoy segura de que deberia devolver aqui
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
