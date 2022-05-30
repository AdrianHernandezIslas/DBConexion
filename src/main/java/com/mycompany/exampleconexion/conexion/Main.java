/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.exampleconexion.conexion;

import com.mycompany.exampleconexion.mapper.implement.AlumnoMapper;
import com.mycompany.exampleconexion.model.Alumno;
import java.util.List;

/**
 *
 * @author shaka
 */
public class Main {

    public static void main(String[] args) {
        try {
            AlumnoMapper alumnoMapper = new AlumnoMapper();
            String query = "select * from alumno WHERE no_control = ''15161200'";
            List<Alumno> listaAlumnos = alumnoMapper.findAll(query);
            //String nombre = "Alexis";
            System.out.println(listaAlumnos);
            /*String sqlInsert = "INSERT INTO alumno(nombre,primer_apellido,no_control,segundo_apellido) \n" +
"VALUES('"+nombre+"','Ruiz','15161200','Luis')";
            System.out.println(sqlInsert);
            alumnoMapper.executeUpdate(sqlInsert);*/

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
