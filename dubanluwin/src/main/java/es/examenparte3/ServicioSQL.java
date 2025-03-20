package es.examenparte3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServicioSQL {

    private static final Logger logger = LoggerFactory.getLogger(ServicioSQL.class);

    private static final String URL_DB_ORACLE = "jdbc:oracle:thin:@10.2.1.25:1522:XE";
    private static final String USER_DB_ORACLE = "Luwin";
    private static final String PASSWORD_DB_ORACLE = "password";
    private static Connection connection = null;

    private int id;
    private String nombre;
    private String tipo;
    private double precio;
    private int stock;

    public ServicioSQL(int id, String nombre, String tipo, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ServicioSQL [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", stock="
                + stock + "]";
    }

    public static Connection crearConexion() {
        connection = crearConexion(URL_DB_ORACLE, USER_DB_ORACLE, PASSWORD_DB_ORACLE);

        return connection;
    }

    public static Connection crearConexion(String url, String user, String password) {

        try {
            connection = DriverManager.getConnection(url, user, password);
            logger.info("Conexion a la base de datos realizada exitosamente.");
        } catch (SQLException e) {
            logger.info("Error crear la sesión" + e.getMessage());
        }

        return connection;
    }

    public static void cierraConexion(Connection connection) {

        try {
            connection.close();
        } catch (SQLException e) {
            logger.info("Error al cerrar la sesión " + e.getMessage());
        }

    }

    

}
