
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util. ArrayList;
import  java.util.Arrays;


public class main {

    // This program is a game where user needs to guess a phrase with maximum 5 tries



    public static final String[] hangmanW = {
            "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE",
            "CASE", "CATCH", "CHAR", "CLASS", "CONST",
            "CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE",
            "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY",
            "FLOAT", "FOR", "GOTO", "IF", "IMPLEMENTS",
            "IMPORT", "INSTANCEOF", "INT", "INTERFACE",
            "LONG", "NATIVE", "NEW", "NULL", "PACKAGE",
            "PRIVATE", "PROTECTED", "PUBLIC", "RETURN",
            "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH",
            "SYNCHRONIZED", "THIS", "THROW", "THROWS",
            "TRANSIENT", "TRUE", "TRY", "VOID", "VOLATILE", "WHILE"
    };
//
//
//
//private static void check(){
//    Scanner input = new Scanner(System.in);
//    System.out.println("Enter a letter");
//    String userLetterPick = input.nextLine();
//    userLetterPick = userLetterPick.trim();
//    userLetterPick = userLetterPick.toUpperCase();
//
//    boolean test = false;
//
//    for(String element : hangmanW ){
//        if(element == userLetterPick ){
//            test = true;
//            break;
//        }
//
//
//
//        System.out.println("Yes! The secret word is "+phrase1+"! You have won!");
//
//
//    }
//}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Hangman");

//        check();
//        System.out.println("Please enter the phrase to be used for this game :");
        String phrase = input.nextLine(); // takes input of the phrase
        phrase = phrase.trim(); // removes the spaces in the beginning and the end
        phrase = phrase.replaceAll(" ", " ");
        phrase = phrase.toUpperCase();
        String phrase1 = phrase.replaceAll("[A-Z]", "_ ");
        /*
         * Displays the phrase in underscores with single space between letters
         * And double space for 1 space in the original phrase
         */
        System.out.print("\n"); // prints in new line
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.println("Okay, let's play! Here is the board:");

        int attempts = 0;
        int incorrect = 0;
        String guess;
        char letter;
        boolean guessescontainsguess;
        String guesses = "";
        boolean phrasecontainsguess;

        /*
         * attempts = counts number of attempts incorrect = counts number of
         * incorrect attempts guess = stores the guessed letter input letter =
         * pulls out the first letter from guess for use guesses = stores all
         * the already guessed letters guessescontainsguess= boolean for guess
         * in already guessed letters phrasecontainsguess= boolean for guess in
         * phrase
         */

        while (incorrect <= 7 && phrase1.contains("_")) {// while loop begins

            System.out.println(phrase1);
            System.out.print("\n");
            System.out.println("You have " + incorrect + " incorrect guesses so far.");
            System.out.print("\n");
            if (incorrect == 1) { // for picture 1
                System.out.println(" +--+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("   ===");
                System.out.print("\n");
            } else if (incorrect == 2) { // for picture 2
                System.out.println(" +--+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.println("    |");
                System.out.print("\n");
            } else if (incorrect == 3) { // for picture 3
                System.out.println(" +--+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.print("\n");
            } else if (incorrect == 4) { // for picture 4
                System.out.println(" +--+");
                System.out.println("    |");
                System.out.println("    |");
                System.out.print("\n");
            } else if (incorrect == 5){
                System.out.println(" +--+");
                System.out.println("    |");
            } else if (incorrect == 6){
                System.out.println(" +--+");
            } else if (incorrect == 7){
                System.out.println(" You have Lost");
                break;

            }


            System.out.println("Guess a letter:");
            guess = input.nextLine(); // takes guess input
            guess = guess.toUpperCase(); // converts to uppercase for comparison
            letter = guess.charAt(0); // gets the first letter as guessed letter

            guessescontainsguess = (guesses.indexOf(letter)) != -1;
            guesses += letter; // stores every letter guessed in guesses

            letter = Character.toUpperCase(letter); // converts to uppercase for comparison
            System.out.print("\n");
            if (guessescontainsguess == true) { // if statement begins
                System.out.println("You ALREADY guessed " + letter + ".Choose again.");
                System.out.print("\n");
                if (incorrect > 0) { // inner if begins
                    incorrect--;
                } // inner if ends

            } // if statement begins

            phrasecontainsguess = (phrase.indexOf(letter)) != -1;
            if (phrasecontainsguess == true) { // if statement begins
                System.out.println(letter + " is in the phrase.");
                System.out.print("\n");
                for (int position = 0; position < phrase.length(); position++) { // for begins
                    if (phrase.charAt(position) == letter && phrase1.charAt(position) != letter) {
                        // inner if begins
                        phrase1 = phrase1.replaceAll("_ ", "_");
                        String phrase2;
                        phrase2 = phrase1.substring(0, position) + letter + phrase1.substring(position + 1);
                        phrase2 = phrase2.replaceAll("_", "_ ");
                        phrase1 = phrase2;
                    } // inner if ends
                } // for ends
            } else { // if statement ends, else if begins
                System.out.print("\n");
                System.out.println(letter + " is in not the phrase."); // prints
                System.out.print("\n");
                incorrect++; // incorrect = incorrect + 1, after every incorrect answer
            }

            attempts++; // attempts = attempts + 1, after every attempt

        } // while loop ends

        if (incorrect == 5) { // for picture 5
            System.out.println(" ____________");
            System.out.println(" | | |");
            System.out.println(" | O |");
            System.out.println(" | -|- |");
            System.out.println(" | | |");
            System.out.println("    | / \\ |");
            System.out.println(" ____________");
            System.out.print("\n");
            System.out.println("Sorry, youíve reached your maximum number of incorrect guesses. GAME OVER!");
        } else {


            System.out.println("Yes! The secret word is "+phrase1+"! You have won!");
        }

        input.close(); // Scanner closed
    }

}













