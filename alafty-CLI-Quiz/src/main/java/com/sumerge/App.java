package com.sumerge;

import java.util.Scanner;

import com.sumerge.classes.Admin;
import com.sumerge.classes.Player;
import com.sumerge.classes.User;

/**
 * Hello world!
 *
 */
public class App 
{
    static User currentUser;
    static Scanner sc = new Scanner(System.in);

    public static void main( String[] args )
    {
        
        StartMenu();
    }

    public static void StartMenu() {
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

    public static void ParseAdmin(String _name, String _admin) {
        if(_admin.equals("Y") || _admin.equals("y")) {
            currentUser = new Admin(_name);
        } else if(_admin.equals("N") || _admin.equals("n")) {
            currentUser = new Player(_name);
        } else {
            System.out.println("Incorrect Input. Please try again");
            ParseAdmin(_name, sc.nextLine());
        }
    }

    public static void DotDotDot() {
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
