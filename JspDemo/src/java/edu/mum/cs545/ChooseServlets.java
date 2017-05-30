/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs545;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Santosh
 */
public class ChooseServlets extends HttpServlet {

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
            out.println("<title>Servlet ChooseServlets</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ChooseServlets at " + request.getContextPath() + "</h1>");
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
        {
            System.out.println("-------tenson na de na mula");
            HttpSession s = request.getSession();
            s.invalidate();
            RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
            dispatch.forward(request, response);
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
       

        if (request.getParameter("btnSubmit") != null && request.getParameter("btnSubmit").equals("Submit")){
            String choiceJspCool = request.getParameter("radioJSPCool");
            String JSFwayCool = request.getParameter("JSFwayCool");
            String moonCheese = request.getParameter("moonCheese");

            if (choiceJspCool != null) {
                System.out.println("choice= " + choiceJspCool);
                request.getSession().setAttribute("radioJSPCool", choiceJspCool);
            } else {
                System.out.println("No choice made");
            }
            if (JSFwayCool != null) {
                System.out.println("choice= " + JSFwayCool);
                request.getSession().setAttribute("JSFwayCool", JSFwayCool);
            } else {
                System.out.println("No choice made");
            }
            if (moonCheese != null) {
                System.out.println("choice= " + moonCheese);
                request.getSession().setAttribute("moonCheese", moonCheese);
            } else {
                System.out.println("No choice made");
            }
           
        } else {
            System.out.println("session invalidate");
            request.getSession().invalidate();
           
        }
         RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
            dispatch.forward(request, response);

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
