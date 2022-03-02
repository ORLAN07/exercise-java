
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class coin {

    public static void main(String[] args) throws IOException {
        //System.out.println(System.currentTimeMillis());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberStack = 0;
        int numberMultiple = 0;
        String input;
        while ((input = bufferedReader.readLine()) != null) {
            String[] inputLine = input.split(" ");
            numberStack = Integer.parseInt(inputLine[0]);
            numberMultiple = Integer.parseInt(inputLine[1]);
            int numberSwap = 0;

            if (numberStack + numberMultiple != 0) {
                String[] coinsInput = bufferedReader.readLine().split(" ");
                Integer[] coins = new Integer[numberStack];

                int i = 0;
                while (i < coinsInput.length) {
                    coins[i] = (Integer.parseInt(coinsInput[i]) % numberMultiple);
                    i++;
                }
                Arrays.sort(coins);
                List<String> list = new ArrayList<>(Arrays.asList(coinsInput));
                list.removeAll(List.of("0"));
                coinsInput = list.toArray(new String[0]);

                int sum = 0;
                int s = 0;
                while (s < coinsInput.length) {
                    sum += Integer.parseInt(coinsInput[s]);
                    s++;
                }

                if ((sum % numberMultiple) != 0) {
                    System.out.println("Impossible");
                    //System.out.println(System.currentTimeMillis());
                } else if (numberMultiple == 1 || coinsInput.length == 0 ) {
                    System.out.println("0");
                    //System.out.println(System.currentTimeMillis());
                } else {

                    int numberRequired = 0;
                    int c = 0;
                    int j = coins.length - 1;
                    /*while (c < coins.length) {
                        if (coins[c] != 0) {
                            while (j >= 0) {
                                if (coins[j] != 0) {
                                    numberRequired = (numberMultiple - coins[j]);
                                    if (coins[c] <= numberRequired) {
                                        //swapEmit(coins, c, j);
                                        //coins[j] = (coins[j] + coins[c]);
                                        coins[j] = (coins[j] + coins[c]);
                                        numberSwap += coins[c];
                                        numberRequired = numberRequired - coins[c];
                                        //swapRemove(coins, c, coins[c]);
                                        coins[c] = 0;
                                    } else if (coins[c] > numberRequired) {
                                        //swapEmitNumberFixed(coins, j, numberRequired);
                                        coins[j] = (coins[j] + numberRequired);
                                        numberSwap += numberRequired;
                                        //swapRemove(coins, c, numberRequired);
                                        coins[c] = coins[c] - numberRequired;
                                        numberRequired = 0;
                                    }
                                } else {
                                    j = -1;
                                }
                                if (numberRequired > 0) {
                                    break;
                                } else {
                                    j--;
                                }
                            }
                        }
                        if (j == -2) {
                            break;
                        }
                        c++;
                    }*/

                    while (c < coins.length) {
                        if (coins[c] != 0) {
                            while (j >= 0) {
                                if (coins[j] != 0) {
                                    if (numberRequired == 0) {
                                        numberRequired = (numberMultiple - coins[j]);
                                    }
                                    if (coins[c] < numberRequired) {
                                        numberSwap += coins[c];
                                        numberRequired = numberRequired - coins[c];
                                        //coins[j] = (coins[j] + coins[c]);
                                        coins[c] = 0;
                                        c++;
                                    } else if (coins[c] == numberRequired) {
                                        //swapEmit(coins, c, j);
                                        //coins[j] = (coins[j] + coins[c]);
                                        numberSwap += coins[c];
                                        numberRequired = numberRequired - coins[c];
                                        coins[j] = 0;
                                        coins[c] = 0;
                                        c++;
                                        j--;

                                        //swapRemove(coins, c, coins[c]);
                                        //coins[c] = 0;
                                    } else if (coins[c] > numberRequired) {
                                        //swapEmitNumberFixed(coins, j, numberRequired);

                                        numberSwap += numberRequired;

                                        coins[j] = 0;
                                        //swapRemove(coins, c, numberRequired);
                                        coins[c] = coins[c] - numberRequired;
                                        numberRequired = 0;
                                        j--;
                                    }
                                } else {
                                    j = -1;
                                    break;
                                }
                            }
                        }
                        if (j == -1) {
                            break;
                        }
                        c++;
                    }
                    System.out.println(""+numberSwap);
                    //System.out.println(System.currentTimeMillis());
                }
            } else {
                break;
            }
        }
    }

    /*public static void swapEmit(Integer[] coins, int emit, int receiver) {
        coins[receiver] = (coins[receiver] + coins[emit]);
    }

    public static void swapEmitNumberFixed(Integer[] coins, int receiver, int numberQuit) {
        coins[receiver] = (coins[receiver] + numberQuit);
    }

    public static void swapRemove(Integer[] coins, int indexRemove, int number) {
        coins[indexRemove] = coins[indexRemove] - number;
    }*/
}
