/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exampleconexion.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shaka
 */
public class Conexion {

    private static Conexion instancia;
    private final Connection connection;
    private final String NAME_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_NAME = "escuela";
    private final String URL_DB = "jdbc:mysql://localhost:3306/" + DB_NAME;
    private final String USER_DB = "root";
    private final String PASSWORD_DB = "Ahi.290795";

    private Conexion() throws ClassNotFoundException, SQLException {
        Class.forName(NAME_DRIVER);
        connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
        System.out.println("Connected");
    }

    public synchronized static Conexion getConexion() {
        if (instancia == null) {
            try {
                instancia = new Conexion();
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getCause());
            } catch (SQLException ex) {
                System.err.println(ex.getCause());
            }
        }

        return instancia;
    }
    
    public synchronized Connection getConnection(){
        return connection;
    }
}
