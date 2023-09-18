package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 * Clase para establecer una conexión a una base de datos PostgreSQL.
 */
public class ConexionSql {

    // Atributos de la clase para conectarse al gestor de base de datos.

    private Connection conn = null;
    private String url = "jdbc:postgresql://localhost/tallermecanico";
    private String usuario = "postgres";
    private String clave = "postgres";
    
    /**
     * Establece una conexión a la base de datos.
     *
     * @return La conexión activa o null en caso de error.
     */
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar: " + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }
}
