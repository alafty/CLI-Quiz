package com.sumerge.classes;

import java.util.ArrayList;

import com.sumerge.interfaces.Checkable;

public class Quiz {

    ArrayList<Checkable> questionPool = new ArrayList<Checkable>();

    public String DisplayQuestion(int index) {
        return questionPool.get(index).toString();
    }

    public void AddQuestion(String  _qT, String _ca, ArrayList<String> _pA) {
        Checkable _question = new Question(_qT, _ca, _pA);
        questionPool.add(_question);
    }
    
}
