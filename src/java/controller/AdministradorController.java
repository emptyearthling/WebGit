/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.AdministradorDAO;
import model.dto.Administrador;
import util.Ayudante;

public class AdministradorController extends HttpServlet {

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
        AdministradorDAO AdminDAO = new AdministradorDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        int id = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "eliminar":
                AdminDAO.eliminar(id);
                response.sendRedirect("../listarAdministrador.jsp");
                break;
            case "buscar":
                Administrador a = AdminDAO.buscar(id);
                request.setAttribute("Administrador", a);
                request.getRequestDispatcher("../modificarAdministrador.jsp").forward(request, response);

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

        String nombres = request.getParameter("name");
        String apellidos = request.getParameter("apel"); 
        String correo = request.getParameter("mail");
        int idUpdate = 1;
        
        //hola kev!
         
        System.out.print(idUpdate);
        AdministradorDAO AdminDAO = new AdministradorDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        

        switch (accion) {
            case "ingresar":
                Administrador a = new Administrador();
                a.setNombre(nombres);
                a.setApellido(apellidos);
                a.setEmail(correo);
                AdminDAO.ingresar(a);
                break;
            case "modificar":
                Administrador pro = new Administrador();
                pro.setNombre(nombres);
                pro.setApellido(apellidos);
                AdminDAO.modificar(pro, 1);
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
