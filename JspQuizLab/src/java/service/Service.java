/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import web.Quizweb;

/**
 *
 * @author Manish
 */
public class Service {
    public boolean checkAnswer(int index,String input){
        Quizweb obj = new Quizweb();
        String answer = obj.getAnswer(index);
        if(input.equals(answer))
            return true;
        return false;
    }
    public String findGrade(int score){
    	if(score >= 45 && score <= 50) return "A";
    	if(score >= 35 && score <= 44) return "B";
    	if(score >= 25 && score <= 34) return "C";
    	return "NC";
    }
}