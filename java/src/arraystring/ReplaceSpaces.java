package arraystring;

public class ReplaceSpaces {

    void replaceSpaces(char[] str, int length) {
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        int newCount = length + 2 * spaceCount;
        str[newCount] = '\0';

        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[newCount - 1] = '0';
                str[newCount - 1] = '2';
                str[newCount - 1] = '%';
                newCount = newCount - 3;
            } else {
                str[newCount - 1] = str[i];
                newCount = newCount - 1;
            }
        }

    }

}
