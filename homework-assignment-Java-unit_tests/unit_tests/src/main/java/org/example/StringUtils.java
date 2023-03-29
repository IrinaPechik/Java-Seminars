package org.example;

public class StringUtils {
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int i = 0, j = str.length() - 1;

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
