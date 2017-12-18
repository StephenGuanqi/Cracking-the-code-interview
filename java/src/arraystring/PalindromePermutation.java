package arraystring;

public class PalindromePermutation {

    // assume all letters, case insensitive matching
    public boolean isPanlindromePermutation(String str) {
        int bitVector = createBitVector(str);
        return checkZeroOrOneBitSet(bitVector);
    }

    public int createBitVector(String str) {
        int bitVector = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = getNumericValue(str.charAt(i));
            bitVector ^= (1 << val);
        }
        return bitVector;
    }

    // map character to a number
    // 'a' and 'A' --> 0
    public int getNumericValue(char c) {
        int a = Character.getNumericValue('a');
        int A = Character.getNumericValue('A');

        int val = Character.getNumericValue(c);

        if ( A <= val && val < a) {
            return val - 'A';
        }

        return val - 'a';
    }

    boolean checkZeroOrOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }


}
