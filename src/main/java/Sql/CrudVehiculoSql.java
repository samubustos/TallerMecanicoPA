
package Sql;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase que proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * en una tabla de vehículos en una base de datos PostgreSQL.
 */
public class CrudVehiculoSql extends ConexionSql {
    
    java.sql.Statement st;
    ResultSet rs;
    
    /**
     * Busca el ID de un modelo por su nombre.
     *
     * @param nombre Nombre del modelo a buscar.
     * @return ID del modelo si se encuentra; de lo contrario, retorna -1.
     */
    public int buscarIdModelo(String nombre) {
        int valor = -1; // Inicializamos con un valor predeterminado en caso de que no se encuentre ningún resultado

        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "SELECT id FROM modelo WHERE nombre = '" + nombre + "';";
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
            JOptionPane.showMessageDialog(null, "No se encontró el Modelo seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return valor;
    }
    
    /**
     * Registra un nuevo vehículo en la base de datos.
     *
     * @param marca    Nombre de la marca del vehículo.
     * @param modelo   Nombre del modelo del vehículo.
     * @param patente  Patente del vehículo.
     * @param estado   Estado del vehículo (Activo/Inactivo).
     */
    public void registrar(String marca, String modelo, String patente, Object estado) {
        CrudModeloSql crudModelo = new CrudModeloSql();
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();

            boolean estadoBooleano = estado.equals("Activo");


            // Verificar si la patente ya existe en la base de datos
            String consultaExistencia = "SELECT COUNT(*) FROM vehiculo WHERE LOWER(patente) = LOWER(?)";
            PreparedStatement pstmtExistencia = conexion.prepareStatement(consultaExistencia);
            pstmtExistencia.setString(1, patente.toLowerCase());
            ResultSet resultadoExistencia = pstmtExistencia.executeQuery();

            resultadoExistencia.next();
            int contador = resultadoExistencia.getInt(1);

            if (contador > 0) {
                JOptionPane.showMessageDialog(null, "La patente ya existe en la base de datos", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // La patente no existe, proceder con la inserción
                Integer idmarca = crudModelo.buscarIdMarca(marca);
                Integer idmodelo = this.buscarIdModelo(modelo);
                String sql = "INSERT INTO vehiculo VALUES (default, ?, ?, ?, ?);";

                // Utiliza PreparedStatement para evitar SQL Injection
                PreparedStatement pstmt = conexion.prepareStatement(sql);
                pstmt.setInt(1, idmarca);
                pstmt.setInt(2, idmodelo);
                pstmt.setString(3, patente);
                pstmt.setBoolean(4, estadoBooleano);

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
     * Carga las patentes de los vehículos en un JComboBox.
     *
     * @param cbpatentes JComboBox para cargar las patentes.
     * @return JComboBox actualizado con las patentes.
     */
    public JComboBox cargarPatentes(JComboBox <String> cbpatentes){
        try {
                try (Connection conexion = conectar();) {
                    String sql = "SELECT patente FROM vehiculo";
                    try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                        ResultSet resultSet = statement.executeQuery();
                        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

                        while (resultSet.next()) {
                            model.addElement(resultSet.getString("patente"));
                        }

                        cbpatentes.setModel(model);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los nombres de las marcas" + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        return cbpatentes;
    }
    
    /**
     * Consulta los datos de un vehículo por su patente y muestra la información en los campos correspondientes.
     *
     * @param patente  Patente del vehículo a consultar.
     * @param txtmarca Campo de texto para mostrar la marca del vehículo.
     * @param txtmodelo Campo de texto para mostrar el modelo del vehículo.
     * @param cbestado ComboBox para mostrar el estado del vehículo.
     */
    public void consultarDatos(String patente,JTextField txtmarca,JTextField txtmodelo,JComboBox<String> cbestado) throws SQLException {
        CrudMarcaSql crudMarca = new CrudMarcaSql();
        CrudModeloSql crudModelo = new CrudModeloSql();
        try (Connection conexion = conectar();
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM vehiculo WHERE patente = ?")) {

            statement.setString(1, patente);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int marca = resultSet.getInt("marca");
                    int modelo = resultSet.getInt("modelo");
                    boolean estado = resultSet.getBoolean("estado");
                    
                    String stringMarca = crudMarca.getMarca(marca);
                    String stringModelo = crudModelo.getModelo(modelo);
                    
                    
                    txtmodelo.setText("" + stringModelo);
                    txtmarca.setText("" + stringMarca);
                    cbestado.setSelectedItem(estado ? "Activo" : "Inactivo"); 
                }
            }
        }
       
    }
    
    /**
     * Actualiza el estado de un vehículo en la base de datos.
     *
     * @param patente Patente del vehículo a actualizar.
     * @param estado  Nuevo estado del vehículo (Activo/Inactivo).
     */
    public void modificar(String patente, boolean estado) {
        try {

            String sql = "UPDATE vehiculo SET estado = ? WHERE patente = ?";

            try (Connection conexion = conectar();
                 PreparedStatement statement = conexion.prepareStatement(sql)) {
                // Establece los valores de los parámetros
                statement.setBoolean(1, estado);
                statement.setString(2, patente);

                // Ejecuta la actualización
                statement.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Datos del vehiculo actualizados correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | SQLException e) {
            // Imprime el mensaje de la excepción para depuración
            e.printStackTrace();

            JOptionPane.showMessageDialog(null, "Error al actualizar los datos del vehiculo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    /**
     * Elimina un vehículo de la base de datos por su patente.
     *
     * @param patente Patente del vehículo a eliminar.
     */
    public void eliminarVehiculo(String patente) {
        try {
            try (Connection conexion = conectar()) {
                String sql = "DELETE from vehiculo WHERE patente = '" +patente+"'";
                try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                    statement.executeUpdate();
                }
            }
            JOptionPane.showMessageDialog(null, "Datos del vehiculo eliminados correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos del vehiculo" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    
}
