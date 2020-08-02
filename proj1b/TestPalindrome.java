import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalidrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("dog"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    // test the Palidrome function using OffByOne rule
    @Test
    public void testPalidromeOffByOne() {
        assertFalse(palindrome.isPalindrome("ace", offByOne));
        assertFalse(palindrome.isPalindrome("fcedsfwb", offByOne));
        assertFalse(palindrome.isPalindrome("ac#a%db", offByOne));
        assertTrue(palindrome.isPalindrome("acegfdb", offByOne));
        assertTrue(palindrome.isPalindrome("facdbe", offByOne));
        assertTrue(palindrome.isPalindrome("&hjlnmki%", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
    }

    // test the Palidrome function using OffByN rule
    @Test
    public void testPalidromeOffByN() {
        assertFalse(palindrome.isPalindrome("ace", new OffByN(1)));
        assertFalse(palindrome.isPalindrome("fcedsfwb", new OffByN(2)));
        assertFalse(palindrome.isPalindrome("ac#a%db", new OffByN(3)));
        assertTrue(palindrome.isPalindrome("acegfdb", new OffByN(1)));
        assertTrue(palindrome.isPalindrome("abfdc", new OffByN(2)));
        assertTrue(palindrome.isPalindrome("abcafed", new OffByN(3)));
    }
}
