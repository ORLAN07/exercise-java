
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class decode {

    static String A;
    static String B;
    static String M;
    static int numberMod = 1010101;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = bufferedReader.readLine()) != null) {
            String[] inputRC = input.split(" ");
            M = inputRC[0];
            A = inputRC[1];
            B = inputRC[2];
                //0101011011010101 1011 00
            if (M.equals("0") && A.equals("0") && B.equals("0")) {
                break;
            } else {
                int numberSumEqual = 0;
                if (M.length() > A.length() && M.length() > B.length()) {
                    numberSumEqual = findEquals(0, 0, 0, numberSumEqual);
                }
                if (numberSumEqual > 1) {
                    numberSumEqual = numberSumEqual / 2;
                }
                System.out.println(numberSumEqual);
            }
        }
    }

    public static int findEquals(int iM, int iA, int iB, int numberSumEqual) {
        if (M.length() == iM) {
            return numberSumEqual + 1;
        }
        if (A.length() == iA) {
            return numberSumEqual += 1;
        }
        if (B.length() == iB) {
            return numberSumEqual += 1;
        }
        if (M.charAt(iM) == A.charAt(iA) && M.charAt(iM) != B.charAt(iB)) {
            return numberSumEqual + (findEquals(iM + 1, (iA + 1) % A.length(), iB, numberSumEqual)%numberMod);
        }

        if (M.charAt(iM) != A.charAt(iA) && M.charAt(iM) == B.charAt(iB)) {
            return numberSumEqual + (findEquals(iM + 1, iA, (iB + 1) % B.length(), numberSumEqual)%numberMod);
        }

        if (M.charAt(iM) == A.charAt(iA) && M.charAt(iM) == B.charAt(iB)) {
            return numberSumEqual + (findEquals(iM + 1, (iA + 1) % A.length(), iB, numberSumEqual)%numberMod) + (findEquals(iM+1, iA, (iB+1)%B.length(), numberSumEqual)%numberMod);
        }
        return numberSumEqual;
    }

}
