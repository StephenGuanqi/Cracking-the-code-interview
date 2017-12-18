package arraystring;

import java.util.Arrays;

public class CheckPermutation {

    // method 1
    public boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        // can also consider bit vector with double type
        int[] char_set = new int[256];
        for(char c : a.toCharArray()) {
            char_set[c]++;
        }

        for (int i = 0; i < b.length(); i++) {
            char bc = b.charAt(i);
            char_set[bc]--;
            if (char_set[bc] < 0) {
                return false;
            }
        }

        return true;

    }


    // method 2

    public String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public boolean isPermutaiotn2(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        return sort(a).equals(sort(b));
    }


}
