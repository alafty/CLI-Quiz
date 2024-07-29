package com.sumerge.classes;

import java.util.ArrayList;

public abstract class User {
    private String username;
    private int latestScore = 0;
    private boolean isAdmin;
    private ArrayList<String> lastestAnswers = new ArrayList<String>();

    public String getUsername(){
            return this.username;
    }

    void setUsername(String newName) {
        username = newName;
    }

    public int getLatestScore(){
        return this.latestScore;
    }

    public void updateLatestScore() {
        latestScore++;
    }

    public ArrayList<String> getLastestAnswers(){
        return this.lastestAnswers;
    }

    public void updateLatestAnswers(String newAnswer) {
        lastestAnswers.add(newAnswer);
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void gameOver() {
        latestScore = 0;
        lastestAnswers.clear();
    }


}
