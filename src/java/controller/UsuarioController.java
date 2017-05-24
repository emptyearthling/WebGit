/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.UsuarioDAO;
import model.dto.Usuario;
import util.Ayudante;

public class UsuarioController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        UsuarioDAO UsDAO = new UsuarioDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        int id = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "eliminar":
                UsDAO.eliminar(id);
                response.sendRedirect("../listarUsuario.jsp");
                break;
            case "buscar":
                Usuario u = UsDAO.buscar(id);
                request.setAttribute("Usuario",u);
                request.getRequestDispatcher("../modificarUsuario.jsp").forward(request, response);

        }

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

        String Nombre = request.getParameter("Nombre");
        String Apellido = request.getParameter("Apellido");
        String User = request.getParameter("User");
        String Password = request.getParameter("Password");
        String Email = request.getParameter("Email");
        String idUpdate = request.getParameter("Id");
        
        System.out.print(idUpdate);
        UsuarioDAO UsDAO = new UsuarioDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        

        switch (accion) {
            case "ingresar":
                Usuario u = new Usuario();
                //u.setId(Integer.parseInt("id"));
                u.setPerfil_id(Integer.parseInt("perfil_id"));
                u.setNombre(Nombre);
                u.setApellido(Apellido);
                u.setUser(User);
                u.setPassword(Password);
                u.setEmail(Email);
                u.setFechacreacion(String.valueOf("fechacreacion"));
                
                UsDAO.ingresar(u);
                break;
            case "modificar":
                Usuario Us = new Usuario();
                //Us.setId(Integer.parseInt("id"));
                Us.setPerfil_id(Integer.parseInt("perfil_id"));
                Us.setNombre(Nombre);
                Us.setApellido(Apellido);
                Us.setUser(User);
                Us.setPassword(Password);
                Us.setEmail(Email);
                Us.setFechacreacion(String.valueOf("fechacreacion"));
                
                UsDAO.modificar(Us, Integer.parseInt(idUpdate));
                break;
            default:
                throw new AssertionError();
        }
        //Validaciones
        //Crear objeto profesor y cargar datos desde formulario

        //Redireccionar
        response.sendRedirect("../index.html");

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
