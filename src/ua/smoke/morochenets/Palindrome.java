package ua.smoke.morochenets;

import java.util.Scanner;

/**
 * Class search for palindromes longer than two characters in the given word
 *
 * @author Morochenets Olexiy
 * @version 1.00.03
 * @data 27.05.2013
 */

public class Palindrome {
    private static final int LONG_MINIMAL_SUBSTRING = 3;
    public static String palindrome = new String();

    public static void main(String[] args) {
        new Palindrome().findAllPalindromes();
    }

    /**
     * Input words to search in it palindromes
     *
     * @return The value of the palindrome
     */

    public static String inputPolindrome() {
        boolean onlySpace = true;
        Scanner scanner = new Scanner(System.in);
        do {
            outputHint("Input your word");
            palindrome = scanner.nextLine();
            onlySpace = checkInputWord(onlySpace);
        } while ((palindrome.length() < LONG_MINIMAL_SUBSTRING) || (onlySpace == true));
        return palindrome;
    }

    /**
     * Check the correctness of the word
     *
     * @param onlySpace if true then user input incorrect word which consists with only spaces
     * @return
     */

    private static boolean checkInputWord(boolean onlySpace) {
        if (palindrome.length() < LONG_MINIMAL_SUBSTRING)
            outputHint("Line must to be more than 2 characters");
        for (int i = 1; i < palindrome.length(); i++) {
            if (palindrome.charAt(i) != ' ') {
                onlySpace = false;
            }
        }
        if (onlySpace == true) {
            outputHint("Line must have at least one character other than zero");
        }
        return onlySpace;
    }

    /**
     * Output hint and instructions for user
     *
     * @param hint Text for displayed
     */

    public static void outputHint(String hint) {
        System.out.println(hint + ' ');
    }

    /**
     * Searches for all polynomials in a given word and display result
     */
    public void findAllPalindromes() {
        String palindrome = inputPolindrome();
        palindrome = (palindrome.toUpperCase().toLowerCase());
        String reversePolindrom = new StringBuffer(palindrome).reverse().toString();
        if (palindrome.equals(reversePolindrom)) {
            outputHint("All word palindrome: ");
            outputPalindrome(palindrome);
        }
        selectAllSubwords(palindrome);
    }

    /**
     * Select all subwords in specified word
     *
     * @param palindrome Word for selecting subwords
     */
    private void selectAllSubwords(String palindrome) {
        int lengthPalindrome = palindrome.length();
        for (int lengthPartOfPalindrome = LONG_MINIMAL_SUBSTRING; lengthPartOfPalindrome < lengthPalindrome; lengthPartOfPalindrome++) {
            for (int i = 0; i < lengthPalindrome - lengthPartOfPalindrome + 1; i++) {
                char partOfPalindrome[] = new char[lengthPalindrome];
                palindrome.getChars(i, i + lengthPartOfPalindrome, partOfPalindrome, 0);
                checkingPalindrome(lengthPartOfPalindrome, partOfPalindrome);
            }
        }
    }

    /**
     * Checks the word is a palindrome or not
     *
     * @param lengthPartOfPalindrome Length of the subword for search palindromes
     * @param partOfPalindrome       Subword for search palindromes
     */
    public void checkingPalindrome(int lengthPartOfPalindrome, char partOfPalindrome[]) {
        boolean bool = true;
        for (int w = 0; w <= (int) lengthPartOfPalindrome / 2; w++) {
            if (partOfPalindrome[w] != partOfPalindrome[lengthPartOfPalindrome - w - 1]) {
                bool = false;
            }
        }
        if (bool) {
            outputPalindrome(partOfPalindrome);
        }
    }

    /**
     * Output palindrome
     *
     * @param buf Palindrom for output
     */
    public void outputPalindrome(char buf[]) {
        System.out.print(buf);
    }

    /**
     * Output palindrome
     *
     * @param palindrom Palindrom for output
     */
    public void outputPalindrome(String palindrom) {
        System.out.println(palindrom);
    }
}