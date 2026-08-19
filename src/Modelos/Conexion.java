package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static String server = "localhost";
    private static String port = "1433";
    private static String database = "Alumnos_DB";
    private static String user = "sa";
    private static String password = "SqlServer2026!";
    
    //en server, puede ser "localhost" o la ip del sql server 
    //en database, es la base de datos por defecto para pruebas

    public static String getCadenaConexion() {
        return String.format(
                "jdbc:sqlserver://%s:%s;" + "databaseName=%s;" + "user=%s;" + "password=%s;" + "encrypt=true;" + "trustServerCertificate=true;",
                server, port, database, user, password);
    }

    public static Connection getConexion() throws Exception {
        return DriverManager.getConnection(getCadenaConexion());
    }
}
