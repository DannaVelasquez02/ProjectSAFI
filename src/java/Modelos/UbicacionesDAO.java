/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADSO
 */
public class UbicacionesDAO {

    public List<Ubicaciones> MostrarUbicaciones() {
        ArrayList<Ubicaciones> list = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            Connection connection = con.AbrirConexion();
            PreparedStatement ps = connection.prepareStatement("call bd_safi.MostrarUbicaciones()");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ubicaciones ub = new Ubicaciones();
                ub.setUbi_codigo(rs.getInt("ubi_codigo"));
                ub.setUbi_descripcion(rs.getString("ubi_descripcion"));
                ub.setUbi_centro_costo(rs.getString("ubi_centro_costo"));
                list.add(ub);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public int CrearUbicaciones(Ubicaciones ub){
        int status = 0;
        try {
            Conexion con = new Conexion();
            Connection connection = con.AbrirConexion();
            PreparedStatement ps = connection.prepareStatement("call bd_safi.crearUbicacion('" + ub.getUbi_codigo()+ "','" + ub.getUbi_descripcion()+"','"+ub.getUbi_centro_costo()+"')");
            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
}
