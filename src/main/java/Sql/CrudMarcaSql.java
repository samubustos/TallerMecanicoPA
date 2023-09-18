package Sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Clase que realiza operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una 
 * tabla de marcas en una base de datos PostgreSQL.
 */

public class CrudMarcaSql extends ConexionSql{
    
    java.sql.Statement st;
    ResultSet rs;
    
    /**
     * Inserta un nuevo registro de marca en la base de datos.
     *
     * @param nombre Nombre de la marca.
     * @param estado Estado de la marca (Activo/Inactivo).
     */
    
    public void insertar(String nombre, Object estado) {
    try {
        Connection conexion = conectar();
        st = conexion.createStatement();

        boolean estadoBooleano;

        if (estado.equals("Activo")) {
            estadoBooleano = true;
        } else {
            estadoBooleano = false;
        }

        // Validar que 'nombre' solo contenga letras antes de insertar
        if (nombre.matches("^[A-Za-z]+$")) {
            // Verificar si el nombre de la marca ya existe en la base de datos
            String consultaExistencia = "SELECT COUNT(*) FROM marca WHERE LOWER(nombre) = LOWER(?)";
            PreparedStatement pstmtExistencia = conexion.prepareStatement(consultaExistencia);
            pstmtExistencia.setString(1, nombre.toLowerCase());
            ResultSet resultadoExistencia = pstmtExistencia.executeQuery();

            resultadoExistencia.next();
            int contador = resultadoExistencia.getInt(1);

            if (contador > 0) {
                JOptionPane.showMessageDialog(null, "El nombre de la marca ya existe en la base de datos", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // El nombre de la marca no existe, proceder con la inserción
                String sql = "INSERT INTO marca VALUES (default, ?, ?)";
                PreparedStatement pstmt = conexion.prepareStatement(sql);
                pstmt.setString(1, nombre.toLowerCase());
                pstmt.setBoolean(2, estadoBooleano);

                pstmt.executeUpdate();
                pstmt.close();
                JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }

            resultadoExistencia.close();
            pstmtExistencia.close();
        } else {
            JOptionPane.showMessageDialog(null, "El nombre debe contener solo letras y no estar vacío.", "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }

        conexion.close();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "El registro NO se guardó correctamente: " + e.getMessage(), "Mensaje de Error", JOptionPane.ERROR_MESSAGE);
    }
}

    /**
     * Consulta un registro de marca en la base de datos por su nombre.
     *
     * @param marca Nombre de la marca a consultar.
     * @param txtid Campo de texto para mostrar el ID.
     * @param txtnombre Campo de texto para mostrar el nombre.
     * @param cbestado ComboBox para mostrar el estado.
     */
    
    public void consultar(String marca, JTextField txtid,JTextField txtnombre,JComboBox <String> cbestado){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from marca where nombre='"+marca.toLowerCase()+"';";
            rs = st.executeQuery(sql);
            if (rs.next()){
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String estado = rs.getBoolean("estado") ? "Activo" : "Inactivo";
                
                
                txtid.setText(id);
                txtnombre.setText(nombre);
                cbestado.setSelectedItem(estado);
                
            }else{
                txtid.setText("");
                txtnombre.setText("");
                cbestado.setSelectedItem(false);
                JOptionPane.showMessageDialog(null,"no se encontro registro","Sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error en el sistema de busqueda"+e,"Error Busqueda", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Modifica un registro de marca en la base de datos.
     *
     * @param nombre Nuevo nombre de la marca.
     * @param estado Nuevo estado de la marca (Activo/Inactivo).
     * @param id ID del registro a modificar.
     */
    public void modificar(String nombre, boolean estado, int id) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();

            if (nombre == null || nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                String consulta = "UPDATE marca SET nombre=?, estado=? WHERE id=?";
                PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
                preparedStatement.setString(1, nombre.toLowerCase());
                preparedStatement.setBoolean(2, estado);
                preparedStatement.setInt(3, id);

                preparedStatement.executeUpdate();
                preparedStatement.close();
                conexion.close();

                JOptionPane.showMessageDialog(null, "El registro se actualizó", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR: Ingrese solo caracteres de A-Z ", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Elimina un registro de marca en la base de datos por su ID.
     *
     * @param id ID del registro a eliminar.
     */
    public void eliminar(int id){
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete  from marca where id='"+id+"';";
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
                JOptionPane.showMessageDialog(null,"El registro se borro corectamente","Eliminado",JOptionPane.INFORMATION_MESSAGE);
            } else {
                // El usuario eligió "No" o cerró el cuadro de diálogo, no hacer nada
                
            }

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al eliminar registro"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carga los nombres de las marcas desde la base de datos y los agrega a un JComboBox.
     *
     * @param cbmarca JComboBox para mostrar los nombres de las marcas.
     * @return El JComboBox actualizado.
     */
    public JComboBox cargarNombresMarcas(JComboBox<String> cbmarca) {
            try {
                try (Connection conexion = conectar();) {
                    String sql = "SELECT Nombre FROM Marca";
                    try (PreparedStatement statement = conexion.prepareStatement(sql)) {
                        ResultSet resultSet = statement.executeQuery();
                        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();

                        while (resultSet.next()) {
                            model.addElement(resultSet.getString("Nombre"));
                        }

                        cbmarca.setModel(model);
                    }
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar los nombres de las marcas" + e, "Error", JOptionPane.ERROR_MESSAGE);
            }
            return cbmarca;
        }
    
    /**
     * Obtiene el nombre de una marca a partir de su ID.
     *
     * @param idMarca ID de la marca a consultar.
     * @return El nombre de la marca o null si no se encuentra.
     */
    String getMarca(int idMarca){
        String nombre = null;

        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "SELECT nombre FROM marca WHERE id = '" + idMarca + "';";
            st.execute(sql);
            ResultSet nombreMarca = st.getResultSet();
            if (nombreMarca.next()) { // Mover el cursor al primer resultado si existe
                nombre = nombreMarca.getString("nombre"); // 1 representa el índice de la columna en el resultado
                // Haz algo con el valor int aquí
            } else {
                // Manejar el caso en que no haya resultados en el ResultSet
            }

            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró la Marca seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return nombre;
    }

}
