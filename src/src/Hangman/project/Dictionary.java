package Hangman.project;

import java.util.Random;

public class Dictionary {
    private static final String[] words = {"scratch", "number", "brother", "ship", "christmas", "help", "space", "pack", "skill", "research", "disorientation"};

    static Random word = new Random();

    static int index = word.nextInt(words.length);

    public static String randomWord() {
        return words[index];
    }
}
