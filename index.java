
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class index {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = 0;
        int Q = 0;
        
        while (true) {
            String[] readLineNQ = bufferedReader.readLine().split(" ");
            N = Integer.parseInt(readLineNQ[0]);
            Q = Integer.parseInt(readLineNQ[1]);

            if ((N + Q) != 0) {
                String[] ccpl = new String[N];
                String[] ccplSearch = new String[Q];
                int nCCPL = 0;
                int qCCPL = 0;
                while (nCCPL < N) {
                    ccpl[nCCPL] = bufferedReader.readLine();
                    nCCPL++;
                }
                while (qCCPL < Q) {
                    ccplSearch[qCCPL] = bufferedReader.readLine();
                    qCCPL++;
                }

                int iWord = 0;
                while (iWord <= ccplSearch.length -1) {
                    int iLine = 0;
                    while (iLine <= ccpl.length -1) {
                        boolean flag = kmpSearch(ccpl[iLine], ccplSearch[iWord]);
                        if (flag) {
                            System.out.println((iLine + 1));
                            break;
                        } else if (iLine == ccpl.length - 1) {
                            System.out.println("n");
                            break;
                        }
                        iLine++;
                    }
                    iWord++;
                }
            } else {
                break;
            }
        }

    }


    public static boolean kmpSearch(String ccpl, String word) {
        int[] next = kmpNext(word);
        for(int i = 0,j = 0;i<ccpl.length();i++){
            while (j > 0 && ccpl.charAt(i) != word.charAt(j)){
                j = next[j - 1];
            }
            if(ccpl.charAt(i) == word.charAt(j)){
                j++;
            }
            if(j == word.length()){
                return true;
            }
        }

        return false;
    }

    public static int[] kmpNext(String word) {
        int[] next = new int[word.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < word.length(); i++) {

            while(j > 0 && word.charAt(i) != word.charAt(j)){
                j = next[j - 1];
            }

            if(word.charAt(i) == word.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }


}
