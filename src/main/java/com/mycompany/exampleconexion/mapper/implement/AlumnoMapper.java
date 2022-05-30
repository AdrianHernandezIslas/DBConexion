/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exampleconexion.mapper.implement;

import com.mycompany.exampleconexion.mapper.Mapper;
import com.mycompany.exampleconexion.model.Alumno;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author shaka
 */
public class AlumnoMapper extends Mapper<Alumno> {

    public AlumnoMapper() {
        super();
    }

    @Override
    public List<Alumno> findAll(String sql) {
        List<Alumno> listaAlumnos = new LinkedList();
        try {
            Statement s = conexion.getConnection().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("id_alumno"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setPrimerApellido(rs.getString("primer_apellido"));
                
                listaAlumnos.add(alumno);
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return listaAlumnos;
    }

    @Override
    public Alumno findOne(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
