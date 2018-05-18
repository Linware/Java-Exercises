/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.ConexionBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tablas.Propietarios;

/**
 *
 * @author Jonan
 */
@WebServlet(name = "ServletCambiarNumeroSecreto", urlPatterns = {"/ServletCambiarNumeroSecreto"})
public class ServletCambiarNumeroSecreto extends HttpServlet {
    
        @EJB
        ConexionBean bancoEJB;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Propietarios l=null;
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCambiarNumeroSecreto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado del cambio</h1>");
            String usuario = request.getParameter("usuario");
            String numero_secreto = request.getParameter("numero_secreto");
                        try{
            l =  bancoEJB.findByUsuario(usuario);
            }catch(Exception e){
                out.print("<br><b>El usuario NO existe </b>");
            }
            if(!l.getUsuario().equals(" ")){
                out.print("<br><b>El usuario ANTES DE LA ACTUALIZACIÓN ERA: </b><br><b>Usuario: </b>" + 
                        l.getUsuario()+ 
                        ", <b>Número secreto: </b>" + 
                        l.getNumeroSecreto());
            }else{out.print("<br><b>El usuario NO existe </b>");}
            out.println("<br>");
                        out.println("<form action=\"index.jsp\" method=\"POST\">"
                    + "<input type=\"submit\" name=\"volver\" value=\"Volver a la pagina inicial\" />"
                    + "</form>");
            out.println("</body>");
            out.println("</html>");
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
