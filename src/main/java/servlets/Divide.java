package servlets;

import java.util.ArrayList;

public class Divide {
    public static void main(String[] args) {
        Divide divide = new Divide();
        divide.dzielniki(-20);
    }

    public ArrayList<Integer> dzielniki(int liczba) throws ArithmeticException {
        ArrayList<Integer> liczby = new ArrayList<>();
        if (liczba > 0) {
            int tab []= new int [liczba];
            for (int i = 1; i <= liczba; i++) {
                if (liczba % i == 0) {
                   liczby.add(i);
                }
            }
        } else {
            try {
                int minusowa = liczba * (-1);
                for (int i = liczba; i <= minusowa; i++) {
                    if (i==0){
                        i+=i+1;
                    }
                    if (liczba % i == 0) {
                        liczby.add(i);

                    }
                }
            } catch (ArithmeticException e) {
                System.out.println("nie dzielimy przez 0");
            }
        }
        return liczby;
    }
}
