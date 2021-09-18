import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++ i) {
            if (!Character.isLetter(s.charAt(i))) {
                sb.append(String.valueOf(s.charAt(i)));
                continue;
            }
            sb.append(String.valueOf(encodeChar(s.charAt(i), k)));
        }
        return sb.toString();
    }
    
    public static char encodeChar (char c, int k) {
        int asciiNum = (int) c;
        int newAscii = asciiNum + k % 26;
        if (c >= 'a' && c <= 'z') {
            if (newAscii > (int)'z') {
                newAscii = (newAscii - (int)'z' - 1) + (int)'a';
            }
        }   
        if (c >= 'A' && c <= 'Z') {
            if (newAscii > (int)'Z') {
                newAscii = (newAscii - (int)'Z' - 1) + (int)'A';
            }           
        }
        return (char)newAscii;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
