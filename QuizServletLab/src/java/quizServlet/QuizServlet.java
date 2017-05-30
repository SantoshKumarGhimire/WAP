/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import seperateClass.Quiz;
import sun.security.krb5.internal.Krb5;

/**
 *
 * @author Santosh
 */
public class QuizServlet extends HttpServlet {

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
            out.println("<title>Servlet QuizServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuizServlet at " + request.getContextPath() + "</h1>");
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

        HttpSession s = request.getSession();
        if (s.isNew()) {
            int qnum = 0;
            String Question = Quiz.questions[qnum];
            int ans = Quiz.answers[qnum];
            int score = 0;
            s.setAttribute("score", score);
            s.setAttribute("CurrentQuestion", qnum);
            PrintWriter out = response.getWriter();
            out.print("<html><head><title>Quiz Servlet</title></head><body>");
            out.print("<form method='get'>");
            out.print("<H1>The Number Quiz</H1>");
            out.print("Your Current Score is &nbsp;" + score +"<br>");
            out.print("<p>Guess the next number in the sequence.</p>");
            out.print("<p>" + Question + "</p>");
            out.print("Your answer:&nbsp<input name='answer' size=2><br>");
            out.print("<input type='submit' name='submit'>");
            out.print("</form>");
            out.print("</body></html>");
            s.setAttribute("CurrentQuestion", qnum + 1);

        } else {

            int qnum = (int) s.getAttribute("CurrentQuestion");

            if (qnum >= Quiz.questions.length) {
                
                PrintWriter out = response.getWriter();
                out.print("<html><head><title>Quiz Servlet</title></head><body>");
                out.print("<form method='get'>");
                out.print("<H1>The Number Quiz</H1>");
                out.print("<p>Your Current Score is &nbsp;" + s.getAttribute("score") + "<p>");
                out.print("<p>You have completed the number quiz with the score &nbsp;" +  s.getAttribute("score") + ".Out of 5. </p><br>");
                out.print("</form>");
                out.print("</body></html>");
                s.invalidate();

            } else {

                String Question = Quiz.questions[qnum];
                int ans = Quiz.answers[qnum - 1];
                System.out.println("user score"+request.getParameter("score"));
                 System.out.println("user answer"+request.getParameter("answer"));
                 int score = Integer.parseInt(s.getAttribute("score").toString());
               // int score = Integer.parseInt(request.getParameter("score"));
                int userAnsWer = Integer.parseInt(request.getParameter("answer"));
                if (request.getParameter("answer") != null && userAnsWer == ans) {
                    score = score + 1;
                    s.setAttribute("score", score);
                }

                s.setAttribute("CurrentQuestion", qnum);
                PrintWriter out = response.getWriter();
                out.print("<html><head><title>Quiz Servlet</title></head><body>");
                out.print("<form method='get'>");
                out.print("<H1>The Number Quiz</H1>");
                out.print("Your Current Score is&nbsp;"+score+"<br>");
              // out.print("Your Current Score is&nbsp;<input type='text' size=1 name='score' value="+score+"><br>");
                out.print("<p>Guess the next number in the sequence.</p>");
                out.print("<p>" + Question + "</p>");
                out.print("Your answer:&nbsp;<input name='answer' size=2><br>");
                out.print("<input type='submit' name='submit'>");
                out.print("</form>");
                out.print("</body></html>");
                s.setAttribute("CurrentQuestion", qnum + 1);
            }

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

        HttpSession s = request.getSession();
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
