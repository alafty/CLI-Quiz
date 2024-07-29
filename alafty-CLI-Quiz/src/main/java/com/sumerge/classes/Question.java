package com.sumerge.classes;

import java.util.ArrayList;

import com.sumerge.interfaces.Checkable;

public class Question implements Checkable{

    private String questionText;
    private String correctAnswer;
    private ArrayList<String> possibleAnswers =  new ArrayList<String>();

    public Question(String  _qT, String _ca, ArrayList<String> _pA) {
        questionText = _qT;
        correctAnswer = _ca;
        possibleAnswers.addAll(_pA);
    }

    public boolean checkAnswer(String proposedAnswer) {

        if(proposedAnswer.trim().equals(correctAnswer)) {
            return true;
        }
        return false;
    }

    public String playerToString() {
        String _possibleAnswers = "";
        for(int i = 0; i < possibleAnswers.size(); i++) {
            _possibleAnswers += i+1 + ") " + possibleAnswers.get(i) + "\n";
        }
        
        return 
        "The Question: " + questionText + "\n" +
        _possibleAnswers + "\n";

    }

    public String toString() {
        return playerToString() + 
        "The Correct Answer: " + "\n" +
        correctAnswer;

    }

    
}
