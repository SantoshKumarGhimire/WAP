package mum.cs472;

import app.Quiz;
import java.util.Scanner;

public class TestRunner {

    public static void main(String[] args) {
        try {
            Quiz quiz = new Quiz();

            Scanner sc = new Scanner(System.in);
            boolean questionsLeft = true;

            while (questionsLeft) { 
                System.out.println();
                System.out.println("Your score is:  " + quiz.getNumCorrect());
                System.out.println("Next sequence is:  " + quiz.getCurrentQuestion());

                System.out.println("Enter the next number for the given sequence.");
                String answer = sc.nextLine();

                boolean error = true;
                /* i.e., if answer is correct then increment the question index and score */
                if ((answer != null) && quiz.isCorrect(answer)) {
                    error = false;
                    quiz.markAnswerCorrect();
                }

                /* give error message if wrong */
                if (error) {
                    System.out.println();
                    System.out.println("Wrong answer, please try again.");
                    System.out.println();
                }

                if (quiz.getNumCorrect() == quiz.getTotNumQuestions()) {
                    questionsLeft = false;
                    System.out.println("Congratulations, you have completed the quiz!");
                }
            }
        } catch (Exception ex) {
            System.out.format("%s: %s", ex.getClass().getName(), ex.getMessage());
        }
    }
}
