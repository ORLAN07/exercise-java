
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class laser {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int R = 0;
        int C = 0;
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            String[] inputRC = input.split(" ");
            R = Integer.parseInt(inputRC[0]);
            C = Integer.parseInt(inputRC[1]);

            if (R+C != 0) {
                String[][] mirror = new String[R][C];
                int i = 0;
                while(i < R) {
                    String[] inputLine = bufferedReader.readLine().split("");
                    mirror[i] = inputLine;
                    i++;
                }
            } else {
                break;
            }

        }

    }
}
