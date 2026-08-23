import java.util.ArrayList;
import java.util.Scanner;

public class quize {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> Questions = new ArrayList<String>();

        int score = 0;
        String[][] options = {
                { "A) int x", "B) integer x", "C) x int", "D) declare int" },
                { "A) Stack", "B) Queue", "C) Tree", "D) Graph" },
                { "A) 21", "B) 11", "C) 15", "D) 13" },
                { "A) for", "B) while", "C) do-while", "D) none" },
                { "A) 2", "B) 4", "C) 8", "D) system dependent" },
                { "A) function", "B) define", "C) class", "D) struct" },
                { "A) Hyper Trainer", "B) Hyper Text Markup Language", "C) Hyper Tool", "D) None" },
                { "A) =", "B) ==", "C) :=", "D) +" },
                { "A) O(1)", "B) O(log n)", "C) O(n)", "D) O(n^2)" }
        };
        String[] main_answer = { "A", "B", "B", "C", "B", "C", "B", "B", "C" };
        System.out.println("WELCOME TO KBC ! ");
        System.out.println("Loading Qusetions ! ");
        System.out.println("How many Qutions You want ! ");
        int Question = input.nextInt();
        for (int i = 0; i < Question + 1; i++) {
            Questions.add("What is the correct way to declare an integer in Java?");
            Questions.add("Which data structure uses FIFO (First In First Out)?");
            Questions.add("What is the output of: 5 + 2 * 3 ?");
            Questions.add("Which loop is guaranteed to execute at least once?");
            Questions.add("What is the size of an int in Java?");
            Questions.add("Which keyword is used to define a class in Java?");
            Questions.add("What does HTML stand for?");
            Questions.add("Which operator is used for comparison in Java?");
            Questions.add("What is the time complexity of linear search?");
        }
        System.out.println("View Info ! ");

        for (int i = 0; i < Questions.size() + 1 ; i++) {
            System.out.println(" Q = " + i + " " + Questions.get(i));
            for (int j = 0; j < 4; j++) {
                System.out.println(" Options = " + options[i][j]);
            }
            {
                System.out.print("Enter Your Answer ! ");
                String Answer = input.next().toUpperCase();
                if (Answer.equals(main_answer[i])) {
                    System.out.println("It was Correct ! ");
                    score++;
                } else {
                    System.out.println("It Was Incorrect ! ");
                }
            }
            System.out.println("Your Total Score " + score);
        }
    }

}