package loteria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Loteria {

    private ArrayList<Integer> numbers;

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public static ArrayList<Integer> lotteryNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> lottery6numbers= new ArrayList<>();
        for (int i = 0; i < 49; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < 6; i++) {
            lottery6numbers.add(numbers.get(i));//tworzymy nową liustę z 6 wylosowanymi numerami
        }
        System.out.println(lottery6numbers);
        return lottery6numbers;//zwramcy nową listę
    }

    public static ArrayList<Integer> winNumbers(List<Integer> userNumbers, List<Integer> lotteryNumbers) {
        ArrayList<Integer> wygrane= new ArrayList<>(lotteryNumbers);
        wygrane.retainAll(userNumbers);//tworzymy nową listę która składa się tylko z takich samych liczb
        return wygrane;
    }
}





