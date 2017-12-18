package arraystring;

public class OneEditAway {

    public boolean oneAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if ((second.length() - first.length()) == 1) {
            return oneEditInsert(first, second);
        } else if ((first.length() - second.length()) == 1){
            return oneEditInsert(second, first);
        }
        return false;
    }

    // can also use xor
    public boolean oneEditInsert(String first, String second) {
        int i = 0, j = 0;
        boolean insertOccurred = false;
        while ( i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                if (insertOccurred) {
                    return false;
                } else {
                    j++;
                }
                insertOccurred = true;
            }
        }
        return true;
    }

    // can also use xor
    public boolean oneEditReplace(String first, String second) {
        boolean diffOccured = false;
        for(int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (diffOccured) {
                    return false;
                }
                diffOccured = true;
            }
        }
        return true;
    }

}
