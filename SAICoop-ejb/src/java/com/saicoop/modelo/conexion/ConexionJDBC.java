package com.saicoop.modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gerardo Treviño Montelongo
 * @version 1.00.001
 * @fecha 17 de Julio de 2017
 * @descripción: Clase que realiza la conexion a la base de datos por JDBC
 */
public class ConexionJDBC {

    // -------------------------------------------------------------------------
    // --- CONEXION JDBC -------------------------------------------------------
    // -------------------------------------------------------------------------
    public Connection Conexion(String ip, String bd, String props) {
        String usuario = "saicoop";
        String password = "slufpana?";
        String puerto = "5432";
        String conector = "jdbc:postgresql://";
        String url = conector + ip + ":" + puerto + "/" + bd + "?" + props + "user=" + usuario + "&password=" + password;
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al generar la conexion: Driver no encontrado. " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al recibir base de datos. " + ex.getMessage());
        }
        return null;
    }

}
