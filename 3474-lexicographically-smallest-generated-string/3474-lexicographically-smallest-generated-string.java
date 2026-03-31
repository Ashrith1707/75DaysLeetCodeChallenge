import java.util.*;

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] word = new char[n + m - 1];
        Arrays.fill(word, '?');

        // 1. Apply all 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return ""; // conflict
                    }
                }
            }
        }

        // 2. Fill remaining with 'a' (lexicographically smallest)
        for (int i = 0; i < word.length; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // 3. Fix 'F' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (matches(word, i, str2)) {

                    boolean fixed = false;

                    // try modifying from right → minimal lexicographic damage
                    for (int j = m - 1; j >= 0 && !fixed; j--) {
                        int idx = i + j;
                        char original = word[idx];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == original) continue;

                            word[idx] = c;

                            // validate only affected region
                            if (!matches(word, i, str2) && validAllT(word, str1, str2)) {
                                fixed = true;
                                break;
                            }
                        }

                        if (!fixed) word[idx] = original;
                    }

                    if (!fixed) return "";
                }
            }
        }

        return new String(word);
    }

    // check if substring at i matches str2
    private boolean matches(char[] word, int i, String str2) {
        for (int j = 0; j < str2.length(); j++) {
            if (word[i + j] != str2.charAt(j)) return false;
        }
        return true;
    }

    // validate only 'T' constraints (important optimization)
    private boolean validAllT(char[] word, String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) return false;
                }
            }
        }
        return true;
    }
}