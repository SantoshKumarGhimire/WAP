/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import service.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Manish
 */
public class QuizJSP extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Quizweb obj = new Quizweb();
        String question = obj.getQuestion(0);
        HttpSession session = request.getSession();
        String age = request.getParameter("age");
        String agevalue = "none";
        String inserted = "block";
        try {
            if (Integer.parseInt(age) > 4 && Integer.parseInt(age) < 100) {

                agevalue = "block";
            }
        } catch (Exception e) {

        }
        session.setAttribute("age", age);
        session.setAttribute("inserted", inserted);
        session.setAttribute("agevalue", agevalue);
        session.setAttribute("question", question);
        session.setAttribute("hints", obj.getHint(0));//hints
        session.setAttribute("checkAns", true);
        session.setAttribute("score", 0);
        session.setAttribute("index", 0);
        session.setAttribute("attempts", 0);
        session.setAttribute("msg", null);
        session.setAttribute("correctAns", "");
        session.setAttribute("myname", "");

        //last answer was not correct! Please try again
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher view = request.getRequestDispatcher("quiz.jsp");
            view.forward(request, response);
            //response.sendRedirect("quiz.jsp");
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
        HttpSession session = request.getSession();

        Service service = new Service();
        String answer = request.getParameter("txtAnswer");

        Boolean correct = (Boolean) session.getAttribute("checkAns");

        Boolean isLastTrue = false;
        String age = request.getParameter("age");
        String agevalue = "none";
        String inserted = "block";
        String last = session.getAttribute("inserted").toString();
        try {
            boolean isNumber = Pattern.matches("[0-9]+", age);
            if (isNumber) {
                if (Integer.parseInt(age) > 4 && Integer.parseInt(age) < 100) {
                    inserted = "none";
                    agevalue = "block";
                }
                else{
                    session.setAttribute("ageMsg", "Age Should Be In Between 4 and 100 " );
                }
            }else{
                session.setAttribute("ageMsg", "Only numbers allowed" );
            }
        } catch (Exception e) {

        }
        session.setAttribute("age", age);
        session.setAttribute("inserted", inserted);
        session.setAttribute("agevalue", agevalue);
        session.setAttribute("checkAns", false);
        session.setAttribute("msg", null);
        session.setAttribute("correctAns", "");

        int index = Integer.parseInt(session.getAttribute("index").toString());
        //System.out.println("correct== "+correct+", index= "+index);
        int score = Integer.parseInt(session.getAttribute("score").toString());
        int attempts = Integer.parseInt(session.getAttribute("attempts").toString());

        Quizweb obj = new Quizweb();

        if ((service.checkAnswer(index, answer)) || (correct == true && attempts > 0)) {
            isLastTrue = true;
            session.setAttribute("attempts", 0);
            session.setAttribute("checkAns", true);
            session.setAttribute("index", index + 1);

            switch (attempts) {
                case 0:
                    session.setAttribute("score", score + 10);
                    break;
                case 1:
                    session.setAttribute("score", score + 5);
                    break;
                case 2:
                    session.setAttribute("score", score + 2);
                    break;
                default:
                    break;
            }

            if (index < 4) {
                String question = obj.getQuestion(index + 1);
                session.setAttribute("question", question);
            }

        } else if (last.equals("none")) {
            session.setAttribute("attempts", attempts + 1);
            session.setAttribute("msg", "Your last answer was not correct! Please try again");
        }

        System.out.println("T== " + attempts + " , correct== " + correct);

        if (attempts + 1 == 3 && isLastTrue == false) {//if this is third attempt
            //display answer...
            session.setAttribute("checkAns", true);
            String ans = obj.getAnswer(index);
            session.setAttribute("correctAns", ans);
            session.setAttribute("msg", "No more Attempts allowed!! Correct answer is " + ans);
        }

        if ((index == 4 && (attempts + 1 == 4)) || (index == 4 && isLastTrue == true)) {//if last one
            int scoreFinal = Integer.parseInt(session.getAttribute("score").toString());
            String myGrade = service.findGrade(scoreFinal);
            session.setAttribute("myGrade", myGrade);
            RequestDispatcher view = request.getRequestDispatcher("gameover.jsp");
            view.forward(request, response);
        } else {
            session.setAttribute("hints", obj.getHint((Integer) session.getAttribute("index")));//hints
            RequestDispatcher view = request.getRequestDispatcher("quiz.jsp");
            view.forward(request, response);
        }
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
