package lab9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

public class Task2 {
    public static void test() throws IOException {
        System.out.println("Введите номер, который необходимо найти");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String num = reader.readLine();
        long time1, time2;
        boolean test;

        time1 = System.nanoTime();
        test = Task1.autoNums.contains(num);
        time2 = System.nanoTime();
        System.out.print("Поиск перебором: номер ");
        if (!test) System.out.print("не ");
        System.out.println("найден, поиск занял " + (time2 -time1) + " нс");

        //Collections.sort(Task1.autoNums);
        time1 = System.nanoTime();
        test = (Collections.binarySearch(Task1.autoNums, num) > 0 || test);
        time2 = System.nanoTime();
        System.out.print("Бинарный поиск: номер ");
        if (!test) System.out.print("не ");
        System.out.println("найден, поиск занял " + (time2 -time1) + " нс");

        HashSet<String> hashSet = new HashSet<>(Task1.autoNums);
        time1 = System.nanoTime();
        test = hashSet.contains(num);
        time2 = System.nanoTime();
        System.out.print("Поиск в HashSet: номер ");
        if (!test) System.out.print("не ");
        System.out.println("найден, поиск занял " + (time2 -time1) + " нс");

        TreeSet<String> treeSet = new TreeSet<>(Task1.autoNums);
        time1 = System.nanoTime();
        test = treeSet.contains(num);
        time2 = System.nanoTime();
        System.out.print("Поиск в TreeSet: номер ");
        if (!test) System.out.print("не ");
        System.out.println("найден, поиск занял " + (time2 -time1) + " нс");
    }
}
