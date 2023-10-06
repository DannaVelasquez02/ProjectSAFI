<%-- 
    Document   : verubicaciones
    Created on : 6 oct. 2023, 06:55:05
    Author     : OMAR OROZCO
--%>

<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelos.Ubicaciones"%>
<%@page import="Modelos.UbicacionesDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubicaciones</title>
        
        <link rel="stylesheet" href="../../css/css-verubicaciones.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
        
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="../css/css-menu.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        
    </head>
    <body>
        
        
        
        
        <div id="body_box">
            <h1 id="titulo">Ubicaciones</h1>
            <table class="table table-hover" id="tabla_users">
                <thead>
                    <tr class="table-info">
                        <th scope="col">Codigo</th>         
                        <th scope="col">Descripcion</th>
                        <th scope="col">Centro de costo</th>
                        <th scope="col">Acciones</th>

                    </tr>
                </thead>  
                <% 
                    // Se crea un objeto UbicacionesDAO para interactuar con la base de datos
                    UbicacionesDAO ubiDAO = new UbicacionesDAO();
                    // Se obtiene una lista de ubicaciones desde la base de datos
                    List<Ubicaciones> list = ubiDAO.MostrarUbicaciones();
                    //Se crea un iterador (iter) para recorrer los elementos de la lista 
                    Iterator<Ubicaciones> iter = list.iterator();
                    // Se inicializa una variable 'ubi' de tipo Ubicaciones, para ir almacenando los valores que se jalen de la base de datos
                    Ubicaciones ubi = null;
                    //en el while En cada iteración, se obtiene el siguiente elemento de la lista y se asigna a la variable ubi.
                    while (iter.hasNext()){
                        ubi = iter.next();
                    
                %>

                    <tr>
                        <td><%= ubi.getUbi_codigo() %></td>
                        <td><%= ubi.getUbi_descripcion() %></td>
                        <td><%= ubi.getUbi_centro_costo() %></td>                        
                        <td id="acciones">                           
                            <a href="#" class="btn btn-warning"><i class="fa-solid fa-pen-to-square"></i></a>
                            <a href="#" class="btn btn-danger"><i class="fa-regular fa-trash-can"></i></a>                    
                        </td>                           
                    </tr>     
                <%}%>
            </table> 
        </div>
        <div id="btnsBox">             
            <button id="btnAdd"  class="btn btn-light" data-toggle="modal" data-target="#AgregarModal">Agregar Ubicación</button>
            <a id="btnclose" href="../inicio.html" class="btn btn-dark">Volver</a>            
        </div>
                
        <div class="modal fade" id="AgregarModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Agregar Ubicación</h5>                       
                        <a class="close  btn btn-danger" data-dismiss="modal"><i class="fa-regular fa-circle-xmark"></i></a>
                    </div>
                    <div class="modal-body">
                        <form action="addubicacion.jsp" method="post" id="editForm">
                            <div class="form-group">
                                <label for="editCodigo">Código</label>
                                <input type="number" class="form-control" name="ubi_codigo" id="inputform" required/>
                            </div>
                            <div class="form-group">
                                <label for="editFamilia">Descripción</label>
                                <input type="text" class="form-control" name="ubi_descripcion" id="inputform" required/>
                            </div>
                            <div class="form-group">
                                <label for="editUbicacion">Centro de costo</label>
                                <input type="text" class="form-control" name="ubi_centro_costo" id="inputform" required/>     
                            </div>                            


                            <div class="modal-footer">
                                <button type="button" class="btn btn-dark" data-dismiss="modal">Cancelar</button>
                                <button type="submit" class="btn btn-success" id="saveChanges">Crear Ubicación</button>                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
        
        
    </body>
</html>
