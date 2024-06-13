package lab_pratice_ad2;

import java.util.ArrayList;
import java.util.List;

public class pattern_matching_rabincarp {

    public static List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int prime = 101; 

        int patternHash = calculateHash(pattern, m, prime);
        int textHash = calculateHash(text, m, prime);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && checkEqual(text, pattern, i, m)) {
                result.add(i);
            }
            if (i < n - m) {
                textHash = updateHash(text, textHash, i, m, prime);
            }
        }
        return result;
    }

    private static int calculateHash(String str, int len, int prime) {
        int hash = 0;
        for (int i = 0; i < len; i++) {
            hash = hash * prime + str.charAt(i);
        }
        return hash;
    }

    private static int updateHash(String str, int oldHash, int oldIndex, int len, int prime) {
        int newHash = oldHash - str.charAt(oldIndex) * (int)Math.pow(prime, len - 1);
        newHash = newHash * prime + str.charAt(oldIndex + len);
        return newHash;
    }

    private static boolean checkEqual(String text, String pattern, int start, int len) {
        for (int i = 0; i < len; i++) {
            if (text.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "ABCDABCD";
        String pattern = "DA";
        List<Integer> result = search(text, pattern);
        if (!result.isEmpty()) {
            System.out.println("Pattern found at indices: " + result);
        } else {
            System.out.println("Pattern not found");
        }
    }
}
