package es.examenparte3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.examenparte1.clases.CursoImpl;

public class ConsultaSQL {

    private static final Logger logger = LoggerFactory.getLogger(CursoImpl.class);

    private static final String CONSULTA = "SELECT ID, NOMBRE, TIPO, PRECIO, STOCK FROM TB_PRODUCTOS";

    public static void main(String[] args) {

        consultaEmpleados(CONSULTA);

    }

    public static void consultaEmpleados(String consulta) {

        Connection conexion = ServicioSQL.crearConexion();
        Statement st = null;
        ResultSet rs = null;

        try {

            st = conexion.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {

                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                String tipo = rs.getString("TIPO");
                double precio = rs.getDouble("PRECIO");
                int stock = rs.getInt("STOCK");

                logger.info("Datos de la tabla TB_PRODUCTOS=  [ id: " + id + ", nombre: " + nombre
                        + ", tipo: " + tipo + ", precio: " + precio + ", stock:" + stock + "]");

                ServicioSQL productos = new ServicioSQL(id, nombre, tipo, precio, stock);

                List<ServicioSQL> listaProductos = new ArrayList<>();
                listaProductos.add(productos);

                for (ServicioSQL producto : listaProductos) {
                    logger.info("" + producto.getNombre() + " tiene el precio de: " + producto.getPrecio() + " euros.");
                    logger.info("El producto " + producto.getNombre() + ", tiene un stock de: " + producto.getStock()
                            + " unidades");
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            ServicioSQL.cierraConexion(conexion);
            try {
                st.close();
                rs.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

        logger.info("Consulta terminada.");
    }

}