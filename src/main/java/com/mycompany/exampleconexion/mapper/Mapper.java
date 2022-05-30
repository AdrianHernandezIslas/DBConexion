/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exampleconexion.mapper;

import com.mycompany.exampleconexion.conexion.Conexion;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author shaka
 */
public abstract class Mapper<T> {

    protected final Conexion conexion;

    public Mapper() {
        conexion = Conexion.getConexion();
    }

    public abstract List<T> findAll(String sql);

    public abstract T findOne(String sql);

    public Boolean executeUpdate(String sql) throws SQLException {
        Statement stmt = conexion.getConnection().createStatement();
        stmt.executeUpdate(sql);
        return true;
    }

}
