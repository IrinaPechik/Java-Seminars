package org.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class PalindromeCheckerTest {
    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("racecar"));
        assertTrue(StringUtils.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(StringUtils.isPalindrome("hello"));
        assertFalse(StringUtils.isPalindrome("world"));
        assertFalse(StringUtils.isPalindrome(null));
    }
}

