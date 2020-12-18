package lab9;

import java.io.IOException;
import java.util.*;

public class Task1 {
    public static ArrayList<String> autoNums = new ArrayList<>();
    final static List<Character> symbols = Arrays.asList('А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р','С', 'Т', 'У', 'Х');

    public static void main(String[] args) throws IOException {
        for (int a = 0; a < symbols.size(); a++)
            for (int b = 1; b < 10; b++)
                for (int c = 0; c < symbols.size(); c++)
                    for (int d = 0; d < symbols.size(); d++)
                        for (int e = 1; e < 200; e++)
                            if (a != c && a != d && c != d)
                                autoNums.add("" + symbols.get(a) + b + b + b
                                    + symbols.get(c) + symbols.get(d) + modif(e));

                            //Collections.sort(autoNums);
        Task2.test();
    }

    static String modif(int a){
        if (a < 10) return 0 + "" + a;
        return "" + a;
    }
}
