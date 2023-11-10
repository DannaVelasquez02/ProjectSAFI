/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.safi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.safi.pojo.Ubicaciones;
import com.safi.dao.UbicacionesDAO;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author ADSO
 */
@WebServlet(name = "UbicacionesServlet", urlPatterns = {"/UbicacionesServlet"})
public class UbicacionesServlet extends HttpServlet {  
    String verubicaciones = "vistas/ubicaciones/verubicaciones.jsp";
    
    UbicacionesDAO ubDAO = new UbicacionesDAO();
    Ubicaciones ub = new Ubicaciones();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UbicacionesServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UbicacionesServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }   
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //se define acceso
        String acceso = "";
        // se define la acccion
        String accion = request.getParameter("accion");
        
        //si la accion es igual a verubicaciones entonces dirigimos la pagina a la vista en donde se muestran las respectivas ubicaciones
        if (accion.equalsIgnoreCase("verubicaciones")){
            acceso = verubicaciones;
        }
        //
        else if(accion.equalsIgnoreCase("agrubicacion")){            
            //asignamos los valores escritos por el usuario en los input a un objeto tipo String
            String txtubi_codigo = request.getParameter("txtubi_codigo");
            String txtubi_descripcion = request.getParameter("txtubi_descripcion");
            String txtubi_centro_costo = request.getParameter("txtubi_centro_costo");                        
            // enviamos los valores a el set de la clase POJO de ubicaciones
            ub.setUbi_codigo(Integer.parseInt(txtubi_codigo));
            ub.setUbi_descripcion(txtubi_descripcion);
            ub.setUbi_centro_costo(txtubi_centro_costo);            
            //enviamos los datos a el DAO
            ubDAO.CrearUbicaciones(ub);            
            //asignamos la vista a la que queremos redirigir
            acceso = verubicaciones;            
            
        }else if (accion.equalsIgnoreCase("actubicacion")){
            //asignamos los valores escritos por el usuario en los input a un objeto tipo String
            String txtubi_codigo = request.getParameter("txtubi_codigoEdit");
            String txtubi_descripcion = request.getParameter("txtubi_descripcionEdit");
            String txtubi_centro_costo = request.getParameter("txtubi_centro_costoEdit");    
            int txtubi_id = Integer.parseInt(request.getParameter("txtubi_idEdit"));
            // enviamos los valores a el set de la clase POJO de ubicaciones
            ub.setUbi_codigo(Integer.parseInt(txtubi_codigo));
            ub.setUbi_descripcion(txtubi_descripcion);
            ub.setUbi_centro_costo(txtubi_centro_costo);   
            ub.setId(txtubi_id);
            //enviamos los datos a el DAO
            ubDAO.ActualizarUbicacion(ub);            
            //asignamos la vista a la que queremos redirigir
            acceso = verubicaciones;    
        }
        
        
        
        //redirigimos a la vista seleccionada
        //RequestDispatcher vista=request.getRequestDispatcher(acceso); vista.forward(request, response);
        response.sendRedirect(acceso);
        
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
