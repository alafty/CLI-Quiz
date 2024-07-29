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

    public String toString() {
        String _possibleAnswers = "";
        for(int i = 1; i <= possibleAnswers.size(); i++) {
            _possibleAnswers += i + ") " + possibleAnswers.get(i) + "\n";
        }
        
        return 
        "The Question: " + questionText + "\n" +
        "The Proposed Answers: " + "\n" + 
        _possibleAnswers + 
        "The Correct Answer: " + "\n" +
        correctAnswer;

    }

    
}
