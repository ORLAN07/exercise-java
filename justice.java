
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class justice {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String numberInput = null;
        String[] numberEV;
        boolean firstInput = true;
        int numberE = 0;
        int numberEPower = 0;
        int numberV = 0;
        int numberVPower = 0;
        ArrayList<Integer> heroes = new ArrayList<>();
        ArrayList<Integer> villain = new ArrayList<>();
        while (!Objects.equals(numberInput = bufferedReader.readLine(), "0 0")) {
            if (firstInput) {
                numberEV = numberInput.split(" ");
                numberE = Integer.parseInt(numberEV[0]);
                numberV = Integer.parseInt(numberEV[1]);
                heroes.clear();
                villain.clear();
                numberEPower = 0;
                numberVPower = 0;
                firstInput = false;
            } else {
                if (numberEPower < numberE) {
                    heroes.add(Integer.parseInt(numberInput));
                    numberEPower += 1;
                } else if (numberEPower == numberE && numberVPower < numberV) {
                    villain.add(Integer.parseInt(numberInput));
                    numberVPower += 1;

                    if (numberEPower == numberE && numberVPower == numberV) {
                        //restar quitar valor minimo de heroes
                        //restar quitar valor maximo de villanos
                        Collections.sort(heroes);
                        Collections.sort(villain);
                        int minEPower = heroes.get(0);
                        int minVPower = villain.get(0);

                        int maxVPower = villain.get(villain.size() - 1);
                        int maxEPower = heroes.get(heroes.size() - 1);


                        heroes.removeIf(heroeObject -> (heroeObject < minVPower));
                            /*for (int i = 0; i < heroes.size() - 1; i++) {
                                if (heroes.get(i) < minVPower) {
                                    heroes.remove(i);
                                    i--;
                                } else {
                                    break;
                                }
                            }*/


                        villain.removeIf(villainObject -> (villainObject > maxEPower));
                            /*for (int i = villain.size() - 1; i >= 0; i--) {
                                if (villain.get(i) > maxEPower) {
                                    villain.remove(i);
                                } else {
                                    break;
                                }
                            }*/

                        int numberDefeat = 0;
                        /*boolean flag = false;
                        for (int i = heroes.size() - 1; i >= 0; i--) {
                            for (int j = villain.size() - 1; j >= 0; j--) {
                                if (heroes.get(i) > villain.get(j)) {
                                    flag = true;
                                    villain.remove(j);
                                    break;
                                }
                            }
                            if (flag) {
                                numberDefeat += 1;
                                flag = false;
                            }
                        }*/

                        int i = heroes.size() - 1;
                        int j = villain.size() - 1;
                        int temp = 0;
                        while (i >= 0) {
                            //System.out.println("while:1:" + i);

                            while (j >= 0) {
                                //System.out.println("while:2:" + j);
                                if (heroes.get(i) > villain.get(j)) {
                                    numberDefeat += 1;
                                    i--;
                                    j--;
                                    temp += 1;
                                    break;
                                } else {
                                    j--;
                                    temp += 1;
                                }
                            }
                            if (i == -1) {
                                break;
                            }
                            if (j == -1) {
                                break;
                            }
                        }


                        System.out.println(numberDefeat);
                        firstInput = true;
                    }
                }
            }
        }
    }
}
