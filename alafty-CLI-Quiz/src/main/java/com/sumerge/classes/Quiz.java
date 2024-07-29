package com.sumerge.classes;

import java.util.ArrayList;

import com.sumerge.interfaces.Checkable;

public class Quiz {

    ArrayList<Checkable> questionPool = new ArrayList<Checkable>();

    public String DisplayQuestionForAdmin(int index) {
        return questionPool.get(index).adminToString();
    }

    public String DisplayQuestionForPlayer(int index) {
        return questionPool.get(index).playerToString();
    }

    public String DisplayQuestionForUser(int index) {
        return questionPool.get(index).toString();
    }

    public boolean AnswerQuestion(int index, String answer) {
        return questionPool.get(index).checkAnswer(answer);
    }

    public void AddQuestion(String  _qT, String _ca, ArrayList<String> _pA) {
        Checkable _question = new Question(_qT, _ca, _pA);
        questionPool.add(_question);
    }

    public int getQuestionPoolSize() {
        return questionPool.size();
    }
    
}
