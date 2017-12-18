package arraystring;

public class IsUnique {

    boolean isUniqueChars(String str) {
        // unicode or ascii
        if (str.length() > 128) {
            return false;
        }

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    boolean isUniqueChars2(String str) {
        // we assume str only contain 26 characters
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= 1 << val;
        }
        return true;
    }


}
