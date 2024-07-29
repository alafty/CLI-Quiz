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
        LoadDB();
        System.out.println("Welcome to Alafty's Ultimate Quiz Generator");
        System.out.print("Please Wait ");
        DotDotDot();
        StartMenu();
    }

    public static void StartMenu() {

        
       System.out.println("################## Start Menu #######################");
        System.out.println("Please enter your name");
        String _name = sc.nextLine();
        
        System.out.println("Confidential: Are you an admin? Y or N");
        String _admin = sc.nextLine();

        ParseAdmin(_name, _admin);

        System.out.println("Welcome, " + currentUser.getUsername());
        DotDotDot();

        if(currentUser.getAdmin()) {
            AdminWorkFlow();
        } else {
            PlayerWorkFlow();
        }
        
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

    static void AdminWorkFlow() {
        
       System.out.println("################## Admin Dashboard #######################");
        System.out.println("What do you wish to do?");
        System.out.println("1) Create a Quiz");
        System.out.println("2) Display a Question");
        System.out.println("3) Add a Question");
        System.out.println("4) Logout");

        String _response = sc.nextLine();


        switch (_response) {
            case "1":
                CreateQuiz();
                AdminWorkFlow();
                break;
            case "2":
                DisplayQuestion();
                AdminWorkFlow();
                break;
            case "3":
                AddQuestion();
                AdminWorkFlow();
                break;
            case "4":
                Logout();
                break;
            default:
                AdminWorkFlow();
                break;
        }
    }

    static void Logout() {
        StartMenu();
    }

    static void AddQuestion() {
        System.out.println("Write the number of the quiz you wish to investigate");
        String _quizResponse = sc.nextLine();
        try {
            int _quizIndex = Integer.parseInt(_quizResponse) - 1;
            if(_quizIndex > quizzesPool.size()){
                System.out.println("Incorrect Number");
            } else {
                CreateQuestion(quizzesPool.get(_quizIndex));
                System.out.println("Question Added Successfully!");
            }
        } catch (Exception e) {
            System.out.println("Incorrect Input");
        }
        DotDotDot();
        System.out.println();
    }

    static void DisplayQuestion() {
        
       System.out.println("################## Display Question #######################");
        System.out.println("Write the number of the quiz you wish to investigate");
        String _quizResponse = sc.nextLine();
        try {
            int _quizIndex = Integer.parseInt(_quizResponse) - 1;
            if(_quizIndex > quizzesPool.size()){
                System.out.println("Incorrect Number");
            } else {
                System.out.println("Write the number of the question you wish to investigate");
                String _questionResponse = sc.nextLine();
                try {
                    int _questionIndex = Integer.parseInt(_questionResponse) - 1;
                    if(_questionIndex > quizzesPool.get(_quizIndex).getQuestionPoolSize()){
                        System.out.println("Incorrect Number");
                    } else {
                        System.out.println(quizzesPool.get(_quizIndex).DisplayQuestionForAdmin(_questionIndex));
                    }
                } catch (Exception e) {
                    System.out.println("Incorrect Input");
                }
            }
        } catch (Exception e) {
            System.out.println("Incorrect Input");
        }
        DotDotDot();
       System.out.println();
    }

    static void CreateQuiz() {
        Quiz _quiz = new Quiz();
        String response = "n";
        
       System.out.println("################## New Quiz #######################");
        do {
            CreateQuestion(_quiz);
            System.out.println("Question Created. Do you wish to create more questions? Y or N");
            response = sc.nextLine();
        } while (response.equals("Y") || response.equals("y"));
        
        System.out.println();
        DotDotDot();
        quizzesPool.add(_quiz);
        System.out.println("Quiz Created Successfully.");
        System.out.println("Your new Quiz's number is " + quizzesPool.size() );
        DotDotDot();
        System.out.println();
    }

    static void CreateQuestion(Quiz quiz) {
        
       System.out.println("################## New Question #######################");
        System.out.println("Enter Question title");
        String _qt = sc.nextLine();
        
        ArrayList<String> answers = new ArrayList<>();
        while(true) {
            System.out.println("Enter all possible answers. Type \"N\" to stop.");
            String response = sc.nextLine();
            if(response.equals("n") || response.equals("N")) {break;}
            answers.add(response);
        }
        
        
        System.out.println("Enter the index of the correct answer starting from 1.");
        String _correctAnswer = sc.nextLine();

        System.out.println();
        quiz.AddQuestion(_qt, _correctAnswer, answers);
    }

    static void PlayerWorkFlow() {
        
       System.out.println("################## Player Dashboard #######################");
       System.out.println("Press Y to view your latest score and answers."); 
       String _answersResponse = sc.nextLine();
       if(_answersResponse.equals("Y") || _answersResponse.equals("y")) {
            System.out.println("Latest Answers: " + currentUser.getLastestAnswers());
            System.out.println("Latest Score: " + currentUser.getLatestScore());
       }
       System.out.println("Choose which quiz do you wish to play? from 1 to " + quizzesPool.size());
       String _quizResponse = sc.nextLine();
       try {
        int _quizIndex = Integer.parseInt(_quizResponse) - 1;
        while(_quizIndex > quizzesPool.size()) {
            System.out.println("Incorrect Number");
            System.out.println("Choose which quiz do you wish to play? from 1 to " + quizzesPool.size());
            _quizResponse = sc.nextLine();
            _quizIndex = Integer.parseInt(_quizResponse) - 1;
        }
        
        currentUser.gameOver();
        Quiz currentQuiz = quizzesPool.get(_quizIndex);
        for(int i = 0; i < currentQuiz.getQuestionPoolSize(); i++){
            System.out.println(currentQuiz.DisplayQuestionForPlayer(i));
            String _answer = sc.nextLine();
            if(currentQuiz.AnswerQuestion(i, _answer)) {
                currentUser.updateLatestAnswers(_answer);
                currentUser.updateLatestScore();
            }
        }
        
        System.out.println("Your Final Score is " + currentUser.getLatestScore());
        System.out.println("Press Y if you wish to play again.");
        String _response = sc.nextLine();
        if(_response.equals("Y") ||_response.equals("y")) {
            PlayerWorkFlow();
        }
       } catch (Exception e) { 
            System.out.println("Incorrect Input");
       }
       DotDotDot();
       StartMenu();
    }

    static void DotDotDot() {
        for(int i = 0; i < 3; i++) { 
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.print(". ");
        }
        System.out.println();
    }
}
