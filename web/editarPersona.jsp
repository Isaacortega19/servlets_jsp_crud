
<%@page import="Modelo.Persona"%>
<%@page import="Control.AccionesPersonas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Actualización de datos personales</h1>
        <form method="post" name="actualizarDatos" action="actualizarPersona">
            <table border="3" >
                <%
                    int cedula = Integer.parseInt(request.getParameter("cedula"));
                    Persona per = AccionesPersonas.buscarPersonaById(cedula);
                 %>   
                 <tr>
                     <td>Cédula:</td>
                     <td><input type="hidden" name="cedula2" value="<%= per.getCedula() %>"></td>
                 </tr>
                 <tr>
                     <td>Nombre:</td>
                     <td><input type="text" name="nombre2" size="45" value="<%= per.getNombre()%>"></td> 
                 </tr>
                 <tr>
                     <td>Direccion:</td>
                     <td><input type="text" name="direccion2" size="45" value="<%= per.getDireccion()%>"></td> 
                 </tr>
                 <tr>
                     <td>Telefono:</td>
                     <td><input type="text" name="telefono2" size="45" value="<%= per.getTelefono()%>"></td> 
                 </tr>
                 <tr>
                     <td>Email:</td>
                     <td><input type="text" name="email2" size="45" value="<%= per.getEmail()%>"></td> 
                 </tr>
                 <tr>
                     <td>Rol:</td>
                     <td><select name="rol2">
                             <option>Administrador</option>
                             <option>Vendedor</option>
                             <option>Cliente</option>
                         </select></td> 
                 </tr>
                 <tr>
                     <td colspan="2"><input type="submit" value="Actualizar datos Persona"></td> 
                 </tr>
            </table>
            
        </form>
    </body>
</html>
