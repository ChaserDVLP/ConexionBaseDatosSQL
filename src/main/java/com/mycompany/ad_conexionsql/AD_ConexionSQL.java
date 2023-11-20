/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ad_conexionsql;

import java.sql.*;

/**
 *
 * @author xChas
 */
public class AD_ConexionSQL {
    
    //jdbc:mysql//direccion:3306/BBDD
    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "admin";
    static final String PASS = "1234";
    static final String QUERY = "SELECT * FROM videojuegos";

    public static void main(String[] args) throws SQLException {
        
        Statement stmt = null;
        
        try {
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
            
            while (rs.next()) {                
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " +rs.getString("Nombre"));
                System.out.println("Genero: " + rs.getString("Genero"));
                System.out.println("Fecha Lanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.println("Compañía: " + rs.getString("Compañia"));
                System.out.println("Precio: " + rs.getFloat("Precio")+"\n");
                
            }
            
            //INSERTAR UN NUEVO JUEGO
            String queryInserar = "INSERT INTO videojuegos (Nombre) VALUES ('The witcher 3')";
            if (stmt.executeUpdate(queryInserar) > 0) { //Devuelve la cantidad de filas afectadas
                System.out.println("Se ha insertado el registro");
            }
            
            //BORRAR UN REGISTRO
            String queryBorrar = "DELETE FROM videojuegos WHERE Nombre = 'The witcher 3'";
            if (stmt.executeUpdate(queryBorrar) > 0) { //Devuelve la cantidad de filas afectadas
                System.out.println("Se ha eliminado el registro");
            }
            
            //MODIFICAR UN REGISTRO
            String queryModif = "UPDATE videojuegos set Precio = 45 WHERE ID = 5";
            if (stmt.executeUpdate(queryModif) > 0) { //Devuelve la cantidad de filas afectadas
                System.out.println("Se ha modificado el registro");
            }
            
        } catch (SQLException e) {
            System.out.println("Error al conectar la BBDD: "+e);
            e.printStackTrace();
            
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
        
    }
}
