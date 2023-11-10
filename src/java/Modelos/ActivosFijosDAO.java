/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import com.safi.controlador.Conexion;
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
public class ActivosFijosDAO {
    
    public List<ActivosFijos> MostrarActivos() {
        ArrayList<ActivosFijos> list = new ArrayList<>();

        try {
            Conexion con = new Conexion();
            Connection connection = con.AbrirConexion();
            PreparedStatement ps = connection.prepareStatement("call bd_safi.MostrarActivosFijos()");
            ResultSet rs = ps.executeQuery();
            //colocamos un while que recorra los valores de la tabla por cada dato que este
            while (rs.next()) {
                //declaramos el pojo de los activos fijos en un objeto
                ActivosFijos acfi = new ActivosFijos();
                //vamos añadiendo al objeto los datos de la base de datos
                acfi.setId(rs.getInt("id"));
                acfi.setAct_codigo(rs.getInt("act_codigo"));
                acfi.setAct_estado(rs.getInt("act_estado"));
                acfi.setAct_marca(rs.getString("act_marca"));                
                acfi.setAct_modelo(rs.getString("act_modelo"));                
                acfi.setAct_no_serie(rs.getInt("act_no_serie"));                
                acfi.setAct_fecha_adqu(rs.getString("act_fecha_adqu"));                
                acfi.setAct_precio_adqu(rs.getInt("act_precio_adqu"));                
                acfi.setAct_vida_util(rs.getInt("act_vida_util"));                
                acfi.setAct_meses_depreciados(rs.getInt("act_meses_depreciados"));
                acfi.setAct_descripcion(rs.getString("act_descripcion"));
                acfi.setTblfabricantes_id(rs.getInt("tblfabricantes_id"));                
                acfi.setTbltiposactivosfijos_idtbltiposactivosfijos(rs.getInt("tbltiposactivosfijos_idtbltiposactivosfijos"));                
                acfi.setTblubicacion_id(rs.getInt("tblubicacion_id"));                                                
                //añadimos a la lista los datos que se tomaron de la base de datos
                list.add(acfi);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public int CrearActivoFijo(ActivosFijos acfi){
        int status = 0;
        try {
            Conexion con = new Conexion();
            Connection connection = con.AbrirConexion();
            PreparedStatement ps = connection.prepareStatement("call bd_safi.crearActivoFijo('" + acfi.getAct_codigo()+ "','" + acfi.getAct_estado()+"','"+acfi.getAct_marca()+"','"+acfi.getAct_modelo()+
                    "','"+acfi.getAct_no_serie()+"','"+acfi.getAct_fecha_adqu()+"','"+acfi.getAct_precio_adqu()+"','"+acfi.getAct_vida_util()+"','"+acfi.getAct_meses_depreciados()+"','"+acfi.getAct_descripcion()+
                    "','"+acfi.getTblfabricantes_id()+"','"+acfi.getTbltiposactivosfijos_idtbltiposactivosfijos()+"','"+acfi.getTblubicacion_id()+"')");
            
            status = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return status;
    }
    
    
    
    
    
}
