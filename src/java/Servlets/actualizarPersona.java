
package Servlets;

import Control.AccionesPersonas;
import Modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class actualizarPersona extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
          
           String nom, direc, tel, email, rol;
           int cedula = Integer.parseInt(request.getParameter("cedula2"));
            
           
            nom = request.getParameter("nombre2");
            direc = request.getParameter("direccion2");
            tel = request.getParameter("telefono2");
            email = request.getParameter("email2");
            rol = request.getParameter("rol2");
            
            Persona per = new Persona();
            
            per.setCedula(cedula);
            per.setNombre(nom);
            per.setDireccion(direc);
            per.setTelefono(tel);
            per.setEmail(email);
            per.setRol(rol);
            
            
            int estatus = AccionesPersonas.actualizarPersona(per);
            if(estatus > 0){
                response.sendRedirect("consultarPersonas.jsp");
            }else{
                response.sendRedirect("Error.jsp");
            }
        }
    }

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
