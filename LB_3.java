import java.util.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String message1 = in.nextLine();
        String message2 = in.nextLine();
        String message3 = in.nextLine();

        byte[] bytes1 = hexStringToByteArray(message1);
        byte[] bytes2 = hexStringToByteArray(message2);
        byte[] bytes3 = hexStringToByteArray(message3);

        byte[] step1Result = xorByteArrays(bytes2, bytes3);

        byte[] originalMessageBytes = xorByteArrays(step1Result, bytes1);

        String clearMessage = new String(originalMessageBytes);
        System.out.println(clearMessage);
    }

    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    private static byte[] xorByteArrays(byte[] array1, byte[] array2) {
        byte[] result = new byte[array1.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = (byte) (array1[i] ^ array2[i]);
        }
        return result;
    }
}
