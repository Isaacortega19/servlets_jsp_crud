

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="containerRegistro">
                <form method="post" name="registrarPersona" action="GuardarPersona">
                    <table border="3">
                        <tr>
                            <td>Cédula:</td>
                            <td><input type="text" name="cedula" size="45" placeholder="Ingrese el número de cédula" ></td> 
                        </tr>
                        <tr>
                            <td>Nombre:</td>
                            <td><input type="text" name="nombre" size="45"></td> 
                        </tr>
                        <tr>
                            <td>Direccion:</td>
                            <td><input type="text" name="direccion" size="45"></td> 
                        </tr>
                        <tr>
                            <td>Telefono:</td>
                            <td><input type="text" name="telefono" size="45"></td> 
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type="text" name="email" size="45"></td> 
                        </tr>
                        <tr>
                            <td>Rol:</td>
                            <td><select name="rol">
                                    <option>Administrador</option>
                                    <option>Vendedor</option>
                                    <option>Cliente</option>
                                </select></td> 
                        </tr>
                         <tr>
                             <td colspan="2"><input type="submit" value="Registrar Persona"></td> 
                        </tr>
                    </table>
                </form>
            </div>
            <br>
            <div class="consultarPersonas" >
                <a href="consultarPersonas.jsp" >Consultar las personas registradas</a>
            </div>
        </div>
    </body>
</html>
