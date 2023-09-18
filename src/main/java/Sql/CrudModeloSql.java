package Sql;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Esta clase proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * en una tabla de modelos de productos en una base de datos PostgreSQL.
 */

public class CrudModeloSql extends ConexionSql {
    
    java.sql.Statement st;
    ResultSet rs;

    /**
     * Busca el ID de una marca por su nombre en la base de datos.
     *
     * @param nombre Nombre de la marca a buscar.
     * @return El ID de la marca encontrada o -1 si no se encuentra.
     */
    public int buscarIdMarca(String nombre) {
        int valor = -1; // Inicializamos con un valor predeterminado en caso de que no se encuentre ningún resultado

        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "SELECT id FROM marca WHERE nombre = '" + nombre + "';";
            st.execute(sql);
            ResultSet numero = st.getResultSet();
            if (numero.next()) { // Mover el cursor al primer resultado si existe
                valor = numero.getInt(1); // 1 representa el índice de la columna en el resultado
                // Haz algo con el valor int aquí
            } else {
                // Manejar el caso en que no haya resultados en el ResultSet
            }

            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró la Marca seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return valor;
    }
    
    /**
     * Registra un nuevo modelo en la base de datos.
     *
     * @param nombre Nombre del modelo.
     * @param estado Estado del modelo (Activo/Inactivo).
     * @param marca ID de la marca asociada al modelo.
     * @param anio Año del modelo.
     */
    public void registrar(String nombre, Object estado, int marca, int anio) {
    try {
        Connection conexion = conectar();
        st = conexion.createStatement();

        boolean estadoBooleano;

        if (estado.equals("Activo")) {
            estadoBooleano = true;
        } else {
            estadoBooleano = false;
        }


        // Verificar si el nombre del modelo ya existe en la base de datos
        String consultaExistencia = "SELECT COUNT(*) FROM modelo WHERE LOWER(nombre) = LOWER(?)";
        PreparedStatement pstmtExistencia = conexion.prepareStatement(consultaExistencia);
        pstmtExistencia.setString(1, nombre.toLowerCase());
        ResultSet resultadoExistencia = pstmtExistencia.executeQuery();

        resultadoExistencia.next();
        int contador = resultadoExistencia.getInt(1);

        if (contador > 0) {
            JOptionPane.showMessageDialog(null, "El nombre del modelo ya existe en la base de datos", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // El nombre del modelo no existe, proceder con la inserción
            String sql = "INSERT INTO modelo VALUES (default, ?, ?, ?, ?)";
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, nombre.toLowerCase());
            pstmt.setBoolean(2, estadoBooleano);
            pstmt.setInt(3, marca);
            pstmt.setInt(4, anio);

            pstmt.executeUpdate();
            pstmt.close();
            JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }

        resultadoExistencia.close();
        pstmtExistencia.close();


        conexion.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "El registro NO se guardó correctamente: " + e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    /**
     * Consulta los modelos de una marca en la base de datos y los agrega a un JComboBox.
     *
     * @param idMarca ID de la marca para la consulta.
     * @param cbmodelo JComboBox para mostrar los modelos de la marca.
     * @return El JComboBox actualizado.
     */
    public JComboBox<String> consultarModelo(int idMarca, JComboBox<String> cbmodelo) throws SQLException {
        try (Connection conexion = conectar();
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM modelo WHERE marca = ?")) {

            statement.setInt(1, idMarca);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    cbmodelo.addItem(nombre);
                }
            }
        }
        return cbmodelo;
    }
    
    /**
     * Consulta los datos de un modelo por su nombre y los muestra en los campos de texto y JComboBox proporcionados.
     *
     * @param nombre Nombre del modelo a consultar.
     * @param txtid Campo de texto para mostrar el ID del modelo.
     * @param cbestado JComboBox para mostrar el estado del modelo.
     * @param txtanio Campo de texto para mostrar el año del modelo.
     */
    public void consultarDatos(String nombre, JTextField txtid, JComboBox<String> cbestado, JTextField txtanio) throws SQLException{
        try (Connection conexion = conectar();
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM modelo WHERE nombre = ?")) {

            statement.setString(1, nombre);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    boolean estado = resultSet.getBoolean("estado");
                    int anio = resultSet.getInt("anio");
                    
                    txtid.setText("" + id);
                    txtanio.setText("" + anio);
                    cbestado.setSelectedItem(estado ? "Activo" : "Inactivo"); 
                }
            }
        }

    }
    
    /**
     * Actualiza los datos de un modelo en la base de datos.
     *
     * @param id ID del modelo a actualizar.
     * @param estado Nuevo estado del modelo (Activo/Inactivo).
     * @param anio Nuevo año del modelo.
     */
    public void actualizarModelo(Integer id,boolean estado, Integer anio) {
    try {
        
        try (Connection conexion = conectar()) {
            String sql = "UPDATE modelo SET estado = '" + estado + "', anio = " + anio + " WHERE id = '" + id + "'";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.executeUpdate();
            }
        }

        JOptionPane.showMessageDialog(null, "Datos del modelo actualizados correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar los datos del modelo, revise los campos"+ e, "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    /**
     * Elimina un modelo de la base de datos por su ID.
     *
     * @param id ID del modelo a eliminar.
     */
    public void eliminarModelo(Integer id) {
    try {
        try (Connection conexion = conectar()) {
            String sql = "DELETE from modelo WHERE id = '" + id+"'";
            try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                statement.executeUpdate();
            }
        }
        JOptionPane.showMessageDialog(null, "Datos del modelo eliminados correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al eliminar los datos del modelo" + e, "Error", JOptionPane.ERROR_MESSAGE);
    }
    }
    
    /**
     * Obtiene el nombre de un modelo a partir de su ID.
     *
     * @param idModelo ID del modelo a consultar.
     * @return El nombre del modelo o null si no se encuentra.
     */
    String getModelo(int idModelo){
        String nombre = null;

        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "SELECT nombre FROM modelo WHERE id = '" + idModelo + "';";
            st.execute(sql);
            ResultSet nombreModelo = st.getResultSet();
            if (nombreModelo.next()) { // Mover el cursor al primer resultado si existe
                nombre = nombreModelo.getString("nombre"); // 1 representa el índice de la columna en el resultado
                // Haz algo con el valor int aquí
            } else {
                // Manejar el caso en que no haya resultados en el ResultSet
            }

            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró el Modelo seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return nombre;
    }


}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    