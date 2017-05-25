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
import model.dao.ComentarioDAO;
import model.dto.Comentario;
import util.Ayudante;

public class ComentarioController extends HttpServlet {

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
        ComentarioDAO ComDAO = new ComentarioDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        int id = Integer.parseInt(request.getParameter("id"));

        switch (accion) {
            case "eliminar":
                ComDAO.eliminar(id);
                response.sendRedirect("../listarComentario.jsp");
                break;
            case "buscar":
                Comentario c = ComDAO.buscar(id);
                request.setAttribute("Comentario", c);
                request.getRequestDispatcher("../modificarComentario.jsp").forward(request, response);

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
        String post_id = request.getParameter("Post_id");
        String comentario = request.getParameter("Comentario");
        String comentarioestado = request.getParameter("Comentarioestado");
        String fechacreacion = request.getParameter("Fechacreacion");
        
        String idUpdate = request.getParameter("Id");
        
        System.out.print(idUpdate);
        ComentarioDAO ComDAO = new ComentarioDAO();
        String ruta = request.getRequestURI();
        String accion = Ayudante.getAccion(ruta);
        

        switch (accion) {
            case "ingresar":
                Comentario c = new Comentario();
                
                //c.setId(Integer.parseInt(idUpdate));
                c.setUsuario_id(Integer.parseInt(usuario_id));
                c.setPost_id(Integer.parseInt(post_id));
                c.setComentario(comentario);
                c.setComentarioestado(Integer.parseInt(comentarioestado));
                c.setFechacreacion(fechacreacion);
                
                ComDAO.ingresar(c);
                break;
            case "modificar":
                Comentario com = new Comentario();
                //com.setUsuario_id(Integer.parseInt(usuario_id));
                com.setPost_id(Integer.parseInt(post_id));
                com.setComentario(comentario);
                com.setComentarioestado(Integer.parseInt(comentarioestado));
                com.setFechacreacion(fechacreacion);

                ComDAO.modificar(com, Integer.parseInt(idUpdate));
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
