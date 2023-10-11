/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.safi.servlet;

import Modelos.ActivosFijos;
import Modelos.ActivosFijosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADSO
 */
public class ActivosFijosServlet extends HttpServlet {

    String verActivosFijos = "vistas/activosFijos/veractivosFijos.jsp";

    ActivosFijos acfi = new ActivosFijos();
    ActivosFijosDAO acfiDAO = new ActivosFijosDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActivosFijosServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActivosFijosServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
        //se define acceso
        String acceso = "";
        // se define la acccion
        String accion = request.getParameter("accion");

        //si la accion es igual a verubicaciones entonces dirigimos la pagina a la vista en donde se muestran las respectivas ubicaciones
        if (accion.equalsIgnoreCase("veractivosfijos")) {
            acceso = verActivosFijos;
        }
        else if(accion.equalsIgnoreCase("agractivofijo")){            
            //asignamos los valores escritos por el usuario en los input a un objeto tipo String
            String txtact_codigo = request.getParameter("txtact_codigo");
            String txtact_estado = request.getParameter("txtact_estado");
            String txtact_marca = request.getParameter("txtact_marca");              
            String txtact_modelo = request.getParameter("txtact_modelo");  
            String txtact_no_serie = request.getParameter("txtact_no_serie");  
            String txtact_fecha_adqu = request.getParameter("txtact_fecha_adqu");  
            String txtact_precio_adqu = request.getParameter("txtact_precio_adqu");  
            String txtact_vida_util = request.getParameter("txtact_vida_util");  
            String txtact_meses_depreciados = request.getParameter("txtact_meses_depreciados");  
            String txtact_descripcion = request.getParameter("txtact_descripcion");  
            String txttblfabricantes_id = request.getParameter("txttblfabricantes_id");  
            String txttbltiposactivosfijos_id = request.getParameter("txttbltiposactivosfijos_id");  
            String txttblubicacion_id = request.getParameter("txttblubicacion_id");  
            
            // enviamos los valores a el set de la clase POJO de ubicaciones
                      
            acfi.setAct_codigo(Integer.parseInt(txtact_codigo));
            System.out.println(txtact_codigo);
            
            acfi.setAct_estado(Integer.parseInt(txtact_estado));
            System.out.println(txtact_estado);
            
            acfi.setAct_marca(txtact_marca);
            System.out.println(txtact_marca);
            
            acfi.setAct_modelo(txtact_modelo);
            System.out.println(txtact_modelo);
            
            acfi.setAct_no_serie(Integer.parseInt(txtact_no_serie));
            System.out.println(txtact_no_serie);
            
            acfi.setAct_fecha_adqu(txtact_fecha_adqu);
            System.out.println(txtact_fecha_adqu);
            
            acfi.setAct_precio_adqu(Integer.parseInt(txtact_precio_adqu));
            System.out.println(txtact_precio_adqu);
            
            acfi.setAct_vida_util(Integer.parseInt(txtact_vida_util));
            System.out.println(txtact_vida_util);
            
            acfi.setAct_meses_depreciados(Integer.parseInt(txtact_meses_depreciados));
            System.out.println(txtact_meses_depreciados);
            
            acfi.setAct_descripcion(txtact_descripcion);
            System.out.println(txtact_descripcion);
            
            acfi.setTblfabricantes_id(Integer.parseInt(txttblfabricantes_id));
            System.out.println(txttblfabricantes_id);
            
            acfi.setTbltiposactivosfijos_idtbltiposactivosfijos(Integer.parseInt(txttbltiposactivosfijos_id));
            System.out.println(txttbltiposactivosfijos_id);
            
            acfi.setTblubicacion_id(Integer.parseInt(txttblubicacion_id));                       
            System.out.println(txttblubicacion_id);
            
            
            //enviamos los datos a el DAO
            acfiDAO.CrearActivoFijo(acfi);            
            //asignamos la vista a la que queremos redirigir
            acceso = verActivosFijos;            
            
        }

        
        
        
        response.sendRedirect(acceso);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
