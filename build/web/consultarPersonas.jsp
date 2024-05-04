
<%@page import="java.util.List"%>
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
        <h1>Estas son las personas registradas</h1>
        <br>
        <table border="2" >
            <thead>
                <tr>
                    <th>Cédula</th>
                    <th>Nombre</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                    <th>Email</th>
                    <th>Rol</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                   List<Persona> lista = AccionesPersonas.buscarAllPersona();
                   for (Persona per : lista) {
                        %>
                        <tr>
                            <td> <%=per.getCedula()%></td>
                            <td> <%=per.getNombre()%></td>
                            <td> <%=per.getDireccion()%></td>
                            <td> <%=per.getTelefono()%></td>
                            <td> <%=per.getEmail()%></td>
                            <td> <%=per.getRol()%></td>
                            <td> <a href="editarPersona.jsp?cedula=<%=per.getCedula()%>" > Editar</a> </td>
                            <td> <a href="borrarPersona?cedula=<%=per.getCedula()%>" > Borrar</a> </td>
                        </tr>
                        
                        <%
                    }
                %>
            </tbody>
        </table>
        <br>
        <a href="index.jsp" >Regresa a la página principal</a>
    </body>
</html>
