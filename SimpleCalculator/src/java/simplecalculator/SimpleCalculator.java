/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santosh
 */
public class SimpleCalculator extends HttpServlet {

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
            out.println("<title>Servlet SimpleCalculator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SimpleCalculator at " + request.getContextPath() + "</h1>");
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

       // processRequest(request, response);
        if (request.getParameter("submit") != null && request.getParameter("submit") != "submit") {
            int fstnum;
            int secondNumnum;
            int thrdNum;
            int forthNum;

            PrintWriter out=response.getWriter();
            out.print("<html><head><title>calculation</title></head><body>");
            int resultsum;
            if(request.getParameter("addfst")!="" && request.getParameter("addsecond")!=""){
            fstnum = Integer.parseInt(request.getParameter("addfst"));
            secondNumnum = Integer.parseInt(request.getParameter("addsecond"));
            resultsum = fstnum + secondNumnum;
            out.print(fstnum+"+"+ secondNumnum +"="+resultsum);
            }
            int resultmultiply;
             if(request.getParameter("multyfst")!="" && request.getParameter("multysecond")!=""){
            thrdNum = Integer.parseInt(request.getParameter("multyfst"));
            forthNum = Integer.parseInt(request.getParameter("multysecond"));
            resultmultiply = thrdNum * forthNum;
            out.print("<br><br>"+thrdNum+"*"+ thrdNum +"="+resultmultiply);
            }
            out.print("</body></html>");
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
