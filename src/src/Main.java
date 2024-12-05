import Hangman.project.Dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);

    static String alphabet = "qwertyuiopasdfghjklzxcvbnm";

    private static ArrayList<Character> usedLetters = new ArrayList<>();

    public static void main(String[] args) {

        String wordToGuess = Dictionary.randomWord();

        char[] guessedWord = new char[wordToGuess.length()];
        Arrays.fill(guessedWord, '_');

        int attemptsLeft = 6;
        boolean wordGuessed = false;

        System.out.println("Welcome to the game 'Hangman'");



        while (attemptsLeft > 0 && !wordGuessed) {

            System.out.print("Word: ");
            for (char c : guessedWord) {
                System.out.print(c + " ");
            }
            System.out.println();


            System.out.println("Enter the letter: ");
            char guessedLetter = scanner.nextLine().toLowerCase().charAt(0);

            if (alphabet.indexOf(guessedLetter) == -1) {
                System.out.println("This character is not from the English alphabet");
            }

            else if (usedLetters.contains(guessedLetter)) {
                System.out.println("You already used this letter, try another one");
            }

            else {
                usedLetters.add(guessedLetter);

                boolean correctGuess = false;
                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (wordToGuess.charAt(i) == guessedLetter && guessedWord[i] == '_') {
                        guessedWord[i] = guessedLetter;
                        correctGuess = true;
                    }
                }

                if (correctGuess) {
                    System.out.println("Correct!");
                }

                else {
                    attemptsLeft--;
                    System.out.println("Wrong! attempts left: " + attemptsLeft);
                }


                wordGuessed = true;
                for (char c : guessedWord) {
                    if (c == '_') {
                        wordGuessed = false;
                        break;

                    }
                }
            }

            System.out.println();
        }

        if (wordGuessed) {
            System.out.println("Congratulations, you guessed the word: " + wordToGuess);
        }
        else {
            System.out.println("Game over, hidden word: " + wordToGuess);
        }

        scanner.close();

    }
}