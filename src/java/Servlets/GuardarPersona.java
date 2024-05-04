

package Servlets;

import Control.AccionesPersonas;
import Modelo.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GuardarPersona extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String cedulaStr = request.getParameter("cedula");
            String nom, direc, tel, email, rol;
            
            int cedula = Integer.parseInt(cedulaStr);
            nom = request.getParameter("nombre");
            direc = request.getParameter("direccion");
            tel = request.getParameter("telefono");
            email = request.getParameter("email");
            rol = request.getParameter("rol");
            
            Persona per = new Persona();
            
            per.setCedula(cedula);
            per.setNombre(nom);
            per.setDireccion(direc);
            per.setTelefono(tel);
            per.setEmail(email);
            per.setRol(rol);
            
            
            int estatus = AccionesPersonas.registrarPersona(per);
            if(estatus > 0){
                response.sendRedirect("registropersonas.jsp");
            }else{
                response.sendRedirect("Error.jsp");
            }
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

