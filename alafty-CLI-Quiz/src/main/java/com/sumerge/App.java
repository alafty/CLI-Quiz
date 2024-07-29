package com.sumerge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sumerge.classes.Admin;
import com.sumerge.classes.Player;
import com.sumerge.classes.Quiz;
import com.sumerge.classes.User;

/**
 * Hello world!
 *
 */
public class App 
{
    static User currentUser;
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Quiz> quizzesPool = new ArrayList<Quiz>();

    public static void main( String[] args )
    {
        
        StartMenu();
    }

    public static void StartMenu() {
        LoadDB();
        System.out.println("Welcome to Alafty's Ultimate Quiz Generator");
        System.out.print("Please Wait ");
        DotDotDot();

        System.out.println("Please enter your name");
        String _name = sc.nextLine();
        
        System.out.println("Confidential: Are you an admin? Y or N");
        String _admin = sc.nextLine();

        ParseAdmin(_name, _admin);

        System.out.println("Welcome, " + currentUser.getUsername());
        
    }

    static void LoadDB() {
        Quiz _q1 = new Quiz();
        ArrayList<String> _answers1 = new ArrayList<>(List.of("Cristiano Ronaldo", "Lionel Messi", "Johan Cruyff"));
        
        ArrayList<String> _answers2 = new ArrayList<>(List.of("Real Madrid", "FC Barcelona", "AC Milan"));

        ArrayList<String> _answers3 = new ArrayList<>(List.of("Manchester United", "Manchester City", "Chelsea"));

        _q1.AddQuestion("Who won the most ballon d'Ors in history?", "2", _answers1);
        _q1.AddQuestion("Which team won the most champions league titles in history ?", "1", _answers2);
        _q1.AddQuestion("Which team won the most premier league titles in history ?", "1", _answers3);

        //------------------------------------------------------------------------------

        Quiz _q2 = new Quiz();
        ArrayList<String> _answers4 = new ArrayList<>(List.of("Ronaldo Nazario", "Lionel Messi", "Zlatan Ibrahimovic"));
        
        ArrayList<String> _answers5 = new ArrayList<>(List.of("Real Madrid", "FC Barcelona", "Atletico Madrid"));

        ArrayList<String> _answers6 = new ArrayList<>(List.of("Manchester United", "Arsenal", "Manchester City"));

        _q2.AddQuestion("Who won the most golden shoes in history?", "2", _answers4);
        _q2.AddQuestion("Which team won the most la liga titles in history ?", "1", _answers5);
        _q2.AddQuestion("Which team won the most fa cup titles in history ?", "2", _answers6);

        //---------------------------------------------------------------------------------
        quizzesPool.add(_q1);
        quizzesPool.add(_q2);
    }

    static void ParseAdmin(String _name, String _admin) {
        if(_admin.equals("Y") || _admin.equals("y")) {
            currentUser = new Admin(_name);
        } else if(_admin.equals("N") || _admin.equals("n")) {
            currentUser = new Player(_name);
        } else {
            System.out.println("Incorrect Input. Please try again");
            ParseAdmin(_name, sc.nextLine());
        }
    }

    static void DotDotDot() {
        for(int i = 0; i < 3; i++) {
            System.out.print(". ");
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println();
    }
}
