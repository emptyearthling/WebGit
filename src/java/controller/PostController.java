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
import model.dao.PostDAO;
import model.dto.Post;
import util.Ayudante;

public class PostController extends HttpServlet {

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
        PostDAO PoDAO = new PostDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        int id = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "eliminar":
                PoDAO.eliminar(id);
                response.sendRedirect("../listarPost.jsp");
                break;
            case "buscar":
                Post p = PoDAO.buscar(id);
                request.setAttribute("Post",p);
                request.getRequestDispatcher("../modificarPost.jsp").forward(request, response);

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

        String id = request.getParameter("id");
        String usuario_id = request.getParameter("Usuario_id");
        String titulo = request.getParameter("Titulo");
        String cuerpo = request.getParameter("Cuerpo");
        String postestado = request.getParameter("Postestado");
        String fechacreacion = request.getParameter("Fechacreacion");
        
        String idUpdate = request.getParameter("Id");
        
        System.out.print(idUpdate);
        PostDAO PoDAO = new PostDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        

        switch (accion) {
            case "ingresar":
                Post p = new Post();
                //p.setId(Integer.parseInt("id"));
                p.setUsuario_id(Integer.parseInt("usurio_id"));
                p.setTitulo(titulo);
                p.setCuerpo(cuerpo);
                p.setPostedado_id(Integer.parseInt("postestado"));
                p.setFechacreacion(fechacreacion);
                
                PoDAO.ingresar(p);
                break;
            case "modificar":
                Post Pos = new Post();
                //Pos.setId(Integer.parseInt("id"));
                Pos.setUsuario_id(Integer.parseInt("usurio_id"));
                Pos.setTitulo(titulo);
                Pos.setCuerpo(cuerpo);
                Pos.setPostedado_id(Integer.parseInt("postestado"));
                Pos.setFechacreacion(fechacreacion);

                PoDAO.modificar(Pos, Integer.parseInt(idUpdate));
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
