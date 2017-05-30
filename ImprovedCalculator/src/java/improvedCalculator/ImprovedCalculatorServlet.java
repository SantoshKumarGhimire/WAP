/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvedCalculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santosh
 */
public class ImprovedCalculatorServlet extends HttpServlet {

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
        if (request.getParameter("submit") != null ) {
            System.out.println(1  +request.getParameter("a"));
                System.out.println(2+request.getParameter("b"));
                System.out.println(3+request.getParameter("c"));
                System.out.println(1+request.getParameter("d"));
            int fstnum;
            int secondNumnum;
            int thrdNum;
            int forthNum;

            PrintWriter out = response.getWriter();
            out.print("<html><head><title>calculation</title></head><body>");
            int resultsum;
            if ((request.getParameter("a") != "" && request.getParameter("a") != null) && (request.getParameter("b") != "" && request.getParameter("b") != null)) {
                
                fstnum = Integer.parseInt(request.getParameter("a"));
                secondNumnum = Integer.parseInt(request.getParameter("b"));
                resultsum = fstnum + secondNumnum;
                out.print("<form method=get>");
                out.print("<INPUT TYPE='TEXT' NAME='a' VALUE=" + fstnum + "> +  <INPUT TYPE='TEXT' name='b' VALUE=" + secondNumnum + ">= <INPUT TYPE='TEXT' VALUE=" + resultsum + ">");
            } else if (request.getParameter("a") == "" ||request.getParameter("a") == null || request.getParameter("b") == "" || request.getParameter("b") == null) {
                if (request.getParameter("a") == "") {
                    fstnum = 0;
                } else {
                    fstnum = Integer.parseInt(request.getParameter("a"));
                }
                if (request.getParameter("b") == ""){
                    secondNumnum = 0;
                } else {
                    secondNumnum = Integer.parseInt(request.getParameter("b"));
                }
                resultsum = fstnum + secondNumnum;
                out.print("<INPUT TYPE='TEXT'name='a' VALUE=" + fstnum + "> +  <INPUT TYPE='TEXT' name='b' VALUE=" + secondNumnum + "> = <INPUT TYPE='TEXT' value=" + resultsum + ">");
            }
            int resultmultiply;
            if (request.getParameter("c") != "" && request.getParameter("c") != null && request.getParameter("d") != "" && request.getParameter("d") != null) {
                System.out.println("///////////"+request.getParameter("d"));
                thrdNum = Integer.parseInt(request.getParameter("c"));
                forthNum = Integer.parseInt(request.getParameter("d"));
                resultmultiply = thrdNum * forthNum;
                out.print("<br><INPUT TYPE='TEXT'name='c' VALUE=" + thrdNum + "> *  <INPUT TYPE='TEXT'name='d' VALUE=" + forthNum + "> = <INPUT TYPE='TEXT' VALUE=" + resultmultiply + ">");

            } else if (request.getParameter("c") == "" ||request.getParameter("c") == null || request.getParameter("d") == "" || request.getParameter("d") == null) {
                if (request.getParameter("c") == "" || request.getParameter("c") == "") {
                    thrdNum = 0;
                } else {
                    thrdNum = Integer.parseInt(request.getParameter("c"));
                }
                if (request.getParameter("d") == "" || request.getParameter("d") == null) {
                    forthNum = 0;
                } else {
                    forthNum = Integer.parseInt(request.getParameter("b"));
                }
                resultmultiply = thrdNum + thrdNum;
                out.print("<br><INPUT TYPE='TEXT'name='c' VALUE=" + thrdNum+ "> *  <INPUT TYPE='TEXT'name='d' VALUE=" +  forthNum + "> = <INPUT TYPE='TEXT' value=" + resultmultiply + ">");

            }
            out.print(" <BR> <INPUT TYPE='SUBMIT' name='submit' VALUE='submit'>");
            out.print("</form>");
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

       
        
          if (request.getParameter("submit") != null ) {
            System.out.println(1  +request.getParameter("a"));
                System.out.println(2+request.getParameter("b"));
                System.out.println(3+request.getParameter("c"));
                System.out.println(1+request.getParameter("d"));
            int fstnum;
            int secondNumnum;
            int thrdNum;
            int forthNum;

            PrintWriter out = response.getWriter();
            out.print("<html><head><title>calculation</title></head><body>");
            int resultsum;
            if ((request.getParameter("a") != "" && request.getParameter("a") != null) && (request.getParameter("b") != "" && request.getParameter("b") != null)) {
                
                fstnum = Integer.parseInt(request.getParameter("a"));
                secondNumnum = Integer.parseInt(request.getParameter("b"));
                resultsum = fstnum + secondNumnum;
                out.print("<form method=get>");
                out.print("<INPUT TYPE='TEXT' NAME='a' VALUE=" + fstnum + "> +  <INPUT TYPE='TEXT' name='b' VALUE=" + secondNumnum + ">= <INPUT TYPE='TEXT' VALUE=" + resultsum + ">");
            } else if (request.getParameter("a") == "" ||request.getParameter("a") == null || request.getParameter("b") == "" || request.getParameter("b") == null) {
                if (request.getParameter("a") == "") {
                    fstnum = 0;
                } else {
                    fstnum = Integer.parseInt(request.getParameter("a"));
                }
                if (request.getParameter("b") == ""){
                    secondNumnum = 0;
                } else {
                    secondNumnum = Integer.parseInt(request.getParameter("b"));
                }
                resultsum = fstnum + secondNumnum;
                out.print("<INPUT TYPE='TEXT'name='a' VALUE=" + fstnum + "> +  <INPUT TYPE='TEXT' name='b' VALUE=" + secondNumnum + "> = <INPUT TYPE='TEXT' value=" + resultsum + ">");
            }
            int resultmultiply;
            if (request.getParameter("c") != "" && request.getParameter("c") != null && request.getParameter("d") != "" && request.getParameter("d") != null) {
                System.out.println("///////////"+request.getParameter("d"));
                thrdNum = Integer.parseInt(request.getParameter("c"));
                forthNum = Integer.parseInt(request.getParameter("d"));
                resultmultiply = thrdNum * forthNum;
                out.print("<br><INPUT TYPE='TEXT'name='c' VALUE=" + thrdNum + "> *  <INPUT TYPE='TEXT'name='d' VALUE=" + forthNum + "> = <INPUT TYPE='TEXT' VALUE=" + resultmultiply + ">");

            } else if (request.getParameter("c") == "" ||request.getParameter("c") == null || request.getParameter("d") == "" || request.getParameter("d") == null) {
                if (request.getParameter("c") == "" || request.getParameter("c") == "") {
                    thrdNum = 0;
                } else {
                    thrdNum = Integer.parseInt(request.getParameter("c"));
                }
                if (request.getParameter("d") == "" || request.getParameter("d") == null) {
                    forthNum = 0;
                } else {
                    forthNum = Integer.parseInt(request.getParameter("b"));
                }
                resultmultiply = thrdNum + thrdNum;
                out.print("<br><INPUT TYPE='TEXT'name='c' VALUE=" + thrdNum+ "> *  <INPUT TYPE='TEXT'name='d' VALUE=" +  forthNum + "> = <INPUT TYPE='TEXT' value=" + resultmultiply + ">");

            }
            out.print(" <BR> <INPUT TYPE='SUBMIT' name='submitt' VALUE='submit'>");
            out.print("</form>");
            out.print("</body></html>");
        }
          
          //
           if (request.getParameter("submitt") != null ) {
            System.out.println(1  +request.getParameter("a"));
                System.out.println(2+request.getParameter("b"));
                System.out.println(3+request.getParameter("c"));
                System.out.println(1+request.getParameter("d"));
            int fstnum;
            int secondNumnum;
            int thrdNum;
            int forthNum;

            PrintWriter out = response.getWriter();
            out.print("<html><head><title>calculation</title></head><body>");
            int resultsum;
            if ((request.getParameter("a") != "" && request.getParameter("a") != null) && (request.getParameter("b") != "" && request.getParameter("b") != null)) {
                
                fstnum = Integer.parseInt(request.getParameter("a"));
                secondNumnum = Integer.parseInt(request.getParameter("b"));
                resultsum = fstnum + secondNumnum;
                out.print("<form method=get>");
                out.print("<INPUT TYPE='TEXT' NAME='a' VALUE=" + fstnum + "> +  <INPUT TYPE='TEXT' name='b' VALUE=" + secondNumnum + ">= <INPUT TYPE='TEXT' VALUE=" + resultsum + ">");
            } else if (request.getParameter("a") == "" ||request.getParameter("a") == null || request.getParameter("b") == "" || request.getParameter("b") == null) {
                if (request.getParameter("a") == "") {
                    fstnum = 0;
                } else {
                    fstnum = Integer.parseInt(request.getParameter("a"));
                }
                if (request.getParameter("b") == ""){
                    secondNumnum = 0;
                } else {
                    secondNumnum = Integer.parseInt(request.getParameter("b"));
                }
                resultsum = fstnum + secondNumnum;
                out.print("<INPUT TYPE='TEXT'name='a' VALUE=" + fstnum + "> +  <INPUT TYPE='TEXT' name='b' VALUE=" + secondNumnum + "> = <INPUT TYPE='TEXT' value=" + resultsum + ">");
            }
            int resultmultiply;
            if (request.getParameter("c") != "" && request.getParameter("c") != null && request.getParameter("d") != "" && request.getParameter("d") != null) {
                System.out.println("///////////"+request.getParameter("d"));
                thrdNum = Integer.parseInt(request.getParameter("c"));
                forthNum = Integer.parseInt(request.getParameter("d"));
                resultmultiply = thrdNum * forthNum;
                out.print("<br><INPUT TYPE='TEXT'name='c' VALUE=" + thrdNum + "> *  <INPUT TYPE='TEXT'name='d' VALUE=" + forthNum + "> = <INPUT TYPE='TEXT' VALUE=" + resultmultiply + ">");

            } else if (request.getParameter("c") == "" ||request.getParameter("c") == null || request.getParameter("d") == "" || request.getParameter("d") == null) {
                if (request.getParameter("c") == "" || request.getParameter("c") == "") {
                    thrdNum = 0;
                } else {
                    thrdNum = Integer.parseInt(request.getParameter("c"));
                }
                if (request.getParameter("d") == "" || request.getParameter("d") == null) {
                    forthNum = 0;
                } else {
                    forthNum = Integer.parseInt(request.getParameter("b"));
                }
                resultmultiply = thrdNum + thrdNum;
                out.print("<br><INPUT TYPE='TEXT'name='c' VALUE=" + thrdNum+ "> *  <INPUT TYPE='TEXT'name='d' VALUE=" +  forthNum + "> = <INPUT TYPE='TEXT' value=" + resultmultiply + ">");

            }
            out.print(" <BR> <INPUT TYPE='SUBMIT' name='submit' VALUE='submit'>");
            out.print("</form>");
            out.print("</body></html>");
        }
          //
        
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
