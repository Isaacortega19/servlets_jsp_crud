
package Control;

import Modelo.Persona;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AccionesPersonas {
    /* 
    Requerimientos con los que el usuario operara el sistema 
    registrarPersona -> Persona per
    actualizarPersona -> Persona per
    eliminarPersona -> cedula per
    buscarPersonaporCD -> cedula per
    buscarTodoslasPersonas -> Arraylist
    verificarPersona -> 
    */
    
    
    // aqui insertaremos los registros de personas a la tabla Persona
    
    public static int registrarPersona (Persona per){
        int estatus = 0;

        try {
            Connection con = Conexion.getConnection();
            String q = "insert into Persona (cedula,nombre,direccion,telefono,email,rol)" 
                    +  "values(?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setInt(1, per.getCedula());
            ps.setString(2, per.getNombre());
            ps.setString(3, per.getDireccion());
            ps.setString(4, per.getTelefono());
            ps.setString(5, per.getEmail());
            ps.setString(6, per.getRol());
           
            estatus = ps.executeUpdate();
            System.out.println("Registro Exitoso de la persona");
            con.close();
            
            
            
        } catch (Exception e) {
            System.out.println("Error al registrar a la persona");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    //Ahora actualizaremos la persona
    
    public static int actualizarPersona (Persona per){
        int estatus = 0;

        try {
            Connection con = Conexion.getConnection();
            String q = "update persona set nombre = ?, direccion = ?, telefono = ?, email = ?, rol = ? where cedula = ?";

            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getDireccion());
            ps.setString(3, per.getTelefono());
            ps.setString(4, per.getEmail());
            ps.setString(5, per.getRol());
            ps.setInt(6, per.getCedula());
           
            estatus = ps.executeUpdate();
            System.out.println("Actualización  Exitosa de la persona");
            con.close();
            
        } catch (Exception e) {
            System.out.println("Error al actualizar a la persona");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    //Ahora borraremos a la persona
    
    public static int borrarPersona (int cedula){
        int estatus = 0;

        try {
            Connection con = Conexion.getConnection();
            String q = "delete from persona where cedula = ?";
            PreparedStatement ps = con.prepareStatement(q);
            
            //usar getter and setter
            ps.setInt(1,cedula);
            
           
            estatus = ps.executeUpdate();
            System.out.println("Se ha eliminado la persona de manera exitosa");
            
            con.close();
            
        } catch (Exception e) {
            System.out.println("Error al eliminar a la persona");
            System.out.println(e.getMessage());
        }
        return estatus;
    }
    
    //Buscar persona por identificador
    
    public static Persona buscarPersonaById (int cedula){
        Persona per = new Persona();

        try {
            Connection con = Conexion.getConnection();
            String q = "select * from persona where cedula = ?";
            PreparedStatement ps = con.prepareStatement(q);
            
            ps.setInt(1, cedula);
           
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                per.setCedula(rs.getInt(1));
                per.setNombre(rs.getString(2));
                per.setDireccion(rs.getString(3));
                per.setTelefono(rs.getString(4));
                per.setEmail(rs.getString(5));
                per.setRol(rs.getString(6));
                
            }
            System.out.println("Persona encontrada");
            con.close();
            
            
            
        } catch (Exception e) {
            System.out.println("Error al encontrar a la persona");
            System.out.println(e.getMessage());
        }
        return per;
    }
    
    //ahora buscaremos a todos los empleados
    
    public static List<Persona> buscarAllPersona (){
        List<Persona> lista = new ArrayList<Persona>();
        

        try {
            Connection con = Conexion.getConnection();
            String q = "select * from persona";
            PreparedStatement ps = con.prepareStatement(q);
            
           
           
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Persona per = new Persona();
                per.setCedula(rs.getInt(1));
                per.setNombre(rs.getString(2));
                per.setDireccion(rs.getString(3));
                per.setTelefono(rs.getString(4));
                per.setEmail(rs.getString(5));
                per.setRol(rs.getString(6));
                lista.add(per);
                
            }
            System.out.println("Personas encontradas");
            con.close();
            
            
            
        } catch (Exception e) {
            System.out.println("Error al encontrar a las personas");
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
}
