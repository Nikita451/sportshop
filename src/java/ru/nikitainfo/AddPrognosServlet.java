/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ru.nikitainfo;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Никита
 */
public class AddPrognosServlet extends HttpServlet {

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
            out.println("<title>Servlet AddPrognosServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddPrognosServlet at " + request.getContextPath() + "</h1>");
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
     //   processRequest(request, response);
        response.getWriter().print("OK");
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
        //processRequest(request, response);
        ArrayList<String> pars = new ArrayList<String>();
        pars.add(request.getParameter("type"));
        pars.add(request.getParameter("event"));
        pars.add(request.getParameter("prognos"));
        pars.add(request.getParameter("price"));
        pars.add(request.getParameter("time"));
        pars.add(request.getParameter("kof"));
        pars.add(request.getParameter("foto1"));
        pars.add(request.getParameter("foto2"));
        pars.add(request.getParameter("foto3"));
        
        
        Prognos prognos = new Prognos();
        
        boolean flag = prognos.addPrognos(pars);
        
        String attr = "res";
        String goodans = "Проноз успешно добавлен!";
        String badans = "Ошибка добавления прогноза!";
        response.setCharacterEncoding("UTF-8");
        if (flag)
        {
            request.setAttribute(attr,goodans);
        }
        else {
            request.setAttribute(attr, badans);
        }
        
        response.sendRedirect("/Sport1/users/admin/addprognos.jsp");
        
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
