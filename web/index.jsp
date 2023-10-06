<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Modelos.Usuarios" %>



<!DOCTYPE html>
<html>
    <head>
        <title>Login SGAF</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/css-login.css"/>        
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    </head>
   

    <body>
        <div id="loginbox">
            <center> 
                <form class="form" action="LoginServlet" method="POST"><br>
                    <img src="img/SAFI.png" id="logoOF" alt=""/><br>
                    <div class="input-container">
                        <input type="email" placeholder="Correo electronico" name="email">
                        <span>
                        </span>
                    </div>
                    <div class="input-container" id="input-passw">
                        <input type="password" placeholder="Contraseña" name="password">
                    </div>
                    <button type="submit" class="submit">
                        Iniciar Sesión
                    </button>

                    <p class="signup-link">
                        ¿No tienes cuenta?
                        <a href="vistas/Usuarios/userform.html">Registrate</a>
                    </p>
                </form>
            </center>  
        </div>
    </body>

</html>
