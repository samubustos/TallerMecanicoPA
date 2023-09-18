
package Sql;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase que proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * en una tabla de técnicos en una base de datos PostgreSQL.
 */
public class CrudTecnicoSql extends ConexionSql {
    
    java.sql.Statement st;
    ResultSet rs;
    
    /**
     * Inserta un nuevo técnico en la base de datos.
     *
     * @param nombre    Nombre del técnico.
     * @param apellido  Apellido del técnico.
     * @param telefono  Número de teléfono del técnico.
     * @param dni       DNI del técnico.
     * @param estado    Estado del técnico (Activo/Inactivo).
     */
    public void insertar(String nombre, String apellido, String telefono, String dni, String estado) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();

            boolean estadoBooleano = estado.equals("true");

            
            // Verificar si el DNI ya existe en la base de datos
            String consultaExistencia = "SELECT COUNT(*) FROM tecnico WHERE dni = ?";
            PreparedStatement pstmtExistencia = conexion.prepareStatement(consultaExistencia);
            pstmtExistencia.setString(1, dni);
            ResultSet resultadoExistencia = pstmtExistencia.executeQuery();

            resultadoExistencia.next();
            int contador = resultadoExistencia.getInt(1);

            if (contador > 0) {
                JOptionPane.showMessageDialog(null, "El DNI ya existe en la base de datos", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // El DNI no existe, proceder con la inserción
                String sql = "INSERT INTO tecnico VALUES (default, ?, ?, ?, ?, ?);";

                // Utiliza PreparedStatement para evitar SQL Injection
                PreparedStatement pstmt = conexion.prepareStatement(sql);
                pstmt.setString(1, nombre.toLowerCase());
                pstmt.setString(2, apellido.toLowerCase());
                pstmt.setString(3, telefono);
                pstmt.setBoolean(4, estadoBooleano);
                pstmt.setString(5, dni);

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
     * Consulta un técnico en la base de datos por su DNI y muestra sus datos en los campos correspondientes.
     *
     * @param dni       DNI del técnico a consultar.
     * @param txtid     Campo de texto para mostrar el ID del técnico.
     * @param txtnombre Campo de texto para mostrar el nombre del técnico.
     * @param txtapellido Campo de texto para mostrar el apellido del técnico.
     * @param txttelefono Campo de texto para mostrar el teléfono del técnico.
     * @param cbestado  ComboBox para mostrar el estado del técnico.
     */
   public void consultar(String dni,JTextField txtid, JTextField txtnombre, JTextField txtapellido, JTextField txttelefono, JComboBox<String> cbestado) {
    if (!dni.matches("^[0-9]+$")) {
        JOptionPane.showMessageDialog(null, "El DNI solo debe contener números y no debe estar vacío", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si el DNI no es válido
    }

    try {
        Connection conexion = conectar();
        String sql = "SELECT id,nombre, apellido, telefono, estado FROM tecnico WHERE dni = ?;";

        // Utiliza PreparedStatement para evitar SQL Injection
        PreparedStatement pstmt = conexion.prepareStatement(sql);
        pstmt.setString(1, dni);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            // Si se encontró un tecnico con el DNI dado, obtén los datos y muestra un mensaje
            String id = rs.getString("id");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String telefono = rs.getString("telefono");
            String estado = rs.getBoolean("estado") ? "Activo" : "Inactivo";

            txtid.setText(id);
            txtnombre.setText(nombre);
            txtapellido.setText(apellido);
            txttelefono.setText(telefono);
            
            cbestado.setSelectedItem(estado); // Configura el estado en el JComboBox
        } else {
            // Si no se encontró un tecnico con el DNI dado, muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "tecnico no encontrado", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar el tecnico: " + e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
    }
    }
 
     /**
     * Modifica los datos de un técnico en la base de datos.
     *
     * @param dni       DNI del técnico a modificar.
     * @param nombre    Nuevo nombre del técnico.
     * @param apellido  Nuevo apellido del técnico.
     * @param telefono  Nuevo número de teléfono del técnico.
     * @param estado    Nuevo estado del técnico (Activo/Inactivo).
     */
    public void modificarTecnico(String nombre, String apellido, String telefono, boolean estado,String dni ) {
      try {
          try (Connection conexion = conectar()) {
              String sql = "UPDATE tecnico SET nombre = ?, apellido = ?, telefono = ?, estado = ? WHERE dni = ?";

              try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                  statement.setString(1, nombre);
                  statement.setString(2, apellido);
                  statement.setString(3, telefono);
                  statement.setBoolean(4, estado);
                  statement.setString(5, dni);

                  statement.executeUpdate();
              }
          }

          JOptionPane.showMessageDialog(null, "Datos del técnico actualizados correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
      } catch (HeadlessException | SQLException e) {
          JOptionPane.showMessageDialog(null, "Error al actualizar los datos del técnico: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
      }
  }


    
    /**
     * Elimina un técnico de la base de datos por su DNI.
     *
     * @param dni DNI del técnico a eliminar.
     */
    public void eliminarTecnico(String dni){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from tecnico where dni='"+dni+"';";
            int contador = 0;
            
            /*por las dudas*/
            
            int opcion = JOptionPane.showConfirmDialog(
            null, 
            "¿Realmente desea eliminar este elemento?", 
            "Confirmar Eliminación", 
            JOptionPane.YES_NO_OPTION
            );
            
            if (opcion == JOptionPane.YES_OPTION) {
            // El usuario eligió "Sí", realizar la eliminación aquí
                st.executeUpdate(sql);
                st.close();
                conexion.close();
                JOptionPane.showMessageDialog(null,"El tecnico se borro corectamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            } else {
                // El usuario eligió "No" o cerró el cuadro de diálogo, no hacer nada
                
            }

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al eliminar tecnico"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
        
    
    
}