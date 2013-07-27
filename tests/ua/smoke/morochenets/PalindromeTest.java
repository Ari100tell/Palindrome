package ua.smoke.morochenets;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static junit.framework.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * @author Morochenets Olexiy
 * @version 1.00.03
 * @data 27.05.2013
 */
public class PalindromeTest {

    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    @Rule
    public final StandardOutputStreamLog standardOutputStreamLog = new StandardOutputStreamLog();

    /**
     * Test for checking the input and error checking
     */
    @Test
    public  void testInputPolindrome() {
        systemInMock.provideText("abba\n");
        assertEquals("abba", Palindrome.inputPolindrome());
    }

    /**
     * Test for palindrome checking
     */
    @Test
    public void testCheckingPalindrome() {
        Palindrome palindrome = new Palindrome();
        int lengthPartOfPalindrome = 3;
        char partOfPalindrome[] = {'b', 'a', 'b'};
        palindrome.checkingPalindrome(lengthPartOfPalindrome, partOfPalindrome);
        String wordForTest = "bab";
        assertEquals(wordForTest, standardOutputStreamLog.getLog());
    }
}