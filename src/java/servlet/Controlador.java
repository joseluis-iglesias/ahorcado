/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Ahorcado;

/**
 *
 * @author josei_000
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Paso1"})
public class Controlador extends HttpServlet {

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
        HttpSession sesion = request.getSession();
        String pagina = "";
        String nombre;
        int nivel;
        if (sesion != null
                && !request.getParameter("nombre").equals("")
                && request.getParameter("nombre") != null) {
            nombre = request.getParameter("nombre");
            sesion.setAttribute("nombre", nombre);
            Ahorcado ahorcado = (Ahorcado) sesion.getAttribute("ahorcado");

            ahorcado.setError(false);

            nivel = Integer.parseInt(request.getParameter("nivel"));
            ahorcado.inicializa(nivel);
            ahorcado.setJuego(true);

            if ((nombre != null) && (!nombre.equals(""))) {
                ahorcado.setNombre(nombre);
            } else {
                ahorcado.setError(true);
                ahorcado.setMensajeError("Debe introducir un nombre");
            }

            if (!ahorcado.isError()) {
                pagina = "juego.jsp";
            }
        } else {
            pagina = "index.jsp";

        }
        request.getRequestDispatcher(pagina).forward(request, response);

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
