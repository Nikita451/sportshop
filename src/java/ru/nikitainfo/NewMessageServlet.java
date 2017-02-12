/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.nikitainfo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;
import javax.xml.xpath.XPathExpressionException;
import org.apache.jasper.runtime.PageContextImpl;

/**
 *
 * @author Никита
 */
public class NewMessageServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewMessageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewMessageServlet at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
        String message = request.getParameter("message");
        String user_name = request.getParameter("name");
        //String rra = Thread.currentThread().getContextClassLoader().getResource("com.xml").toString();
        ServletContext sc = this.getServletContext();
        
        //File file = new File("C:/Users/Никита/Documents/NetBeansProjects/Sport1/web/users/xml/com.xml");
        
        ServletContext sv = this.getServletContext();
        
        
        File file = new File(sv.getRealPath("") + "/users/xml/com.xml");
        //File file = new File(System.getProperty("user.dir") + "/com.xml");
        XMLWork xmlWork = new XMLWork(file);
        xmlWork.beginWork();
        try {
            xmlWork.addNewElement(user_name, message);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(NewMessageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        xmlWork.saveChangeInXml();
        
        response.getWriter().print(sc.getRealPath(""));
        //response.getWriter().print(user_name + "  " + message);
        
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
