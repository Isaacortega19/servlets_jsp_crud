package Control;

import java.sql.*;

public class Conexion {

    public static Connection getConnection() {
        String url, userName, password;

        url = "jdbc:mysql://localhost:3306/drogueria";
        userName = "root";
        password = "";

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexion exitosa con la BD");

        } catch (Exception e) {
            System.out.println("Error al conectar a la BD");
            System.out.println(e.getMessage());
        }
        return con;
    }

}
