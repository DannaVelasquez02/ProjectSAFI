package Controlador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author OMAR OROZCO
 */
public class Conexion {
    public static Connection conn = null;
    public Connection AbrirConexion() throws SQLException, java.sql.SQLException {
        if (conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_safi?serverTimezone=UTC", "root", "2556229");
            } catch (ClassNotFoundException e) {
                System.out.println("error: " + e.getMessage());
            }
        }
        return conn;
    }
    public void cerrarConexion() {
    }
} 