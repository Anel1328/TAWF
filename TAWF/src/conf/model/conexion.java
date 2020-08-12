package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    private String url;
    private String user;
    private String password;
    private Connection connection;

    public conexion() {
        url = "jdbc:postgresql://localhost:5432/scodigos";
        user = "postgres";
        password = "bd";
    }

    public Connection obtenerConnexion() {
        try {
            Class.forName("org.postgresql.Driver");
            return connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        conexion c = new conexion();
        c.obtenerConnexion();
    }
}
