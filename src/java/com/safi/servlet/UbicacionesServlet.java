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

/**
 *
 * @author ADSO
 */
public class UbicacionesServlet extends HttpServlet {  
    String verubicaciones = "vistas/ubicaciones/verubicaciones.jsp";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        
        
        if (accion.equalsIgnoreCase("verubicaciones")){
            acceso = verubicaciones;
        }
        
        
        //redirigimos a la vista seleccionada
//        RequestDispatcher vista=request.getRequestDispatcher(acceso);
//        vista.forward(request, response);
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
