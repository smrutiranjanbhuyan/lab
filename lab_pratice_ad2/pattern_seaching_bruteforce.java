package lab_pratice_ad2;

public class pattern_seaching_bruteforce {
    public static int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String text = "ABCDABCD";
        String pattern = "CD";
        int index = search(text, pattern);
        System.out.println("Pattern found at index: " + index);
    }
}
