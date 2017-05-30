/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;
public class Quizweb {

    public static String[] question = {
        "3, 1, 4, 1, 5, <font style=\"color:red\"><b> ? </b></font>", // value of pi
        "1, 1, 2, 3, 5, <font style=\"color:red\"><b> ? </b></font>", // fibanonaci series
        "1, 4, 9, 16, 25, <font style=\"color:red\"><b> ? </b></font>",//perfect square
        "2, 3, 5, 7, 11, <font style=\"color:red\"><b> ? </b></font>",//prime number
        "1, 2, 4, 8, 16, <font style=\"color:red\"><b> ? </b></font>" // power of 2
    };
    public static String[] answer = {"9", "8", "36", "13", "32"};
    public static String[] hints = {"PI", "fibanonaci series", "perfect square", "prime number", "power of 2"};
    
    public String getQuestion(int index){
        return question[index];
    }
    public String getAnswer(int index){
        return answer[index];
    }
    public String getHint(int index){
        return hints[index];
    }
}