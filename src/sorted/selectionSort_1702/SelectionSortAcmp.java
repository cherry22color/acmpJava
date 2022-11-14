package sorted.selectionSort_1702;
// https://acmp.ru/asp/do/index.asp?main=task&id_course=1&id_section=7&id_topic=118&id_problem=726

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * В этой задаче вам предлагается реализовать сортировку выбором.
 * <p>
 * Задан массив целых чисел a0, a1, …, an−1. Отсортируем его следующим образом:
 * <p>
 * выберем наибольший элемент массива и поменяем его местами с последним элементом
 * (если последний и есть найденный максимум, то обмен можно не совершать),
 * исключим из рассмотрения последний элемент и если длина оставшегося участка
 * больше нуля перейдем опять к предыдущему пункту.
 * Таким образом, этот алгоритм состоит их n фаз,
 * на каждой из которых выбирается максимум. Ваша задача реализовать эту сортировку
 * описанным способом и вывести n чисел — индексы максимума на каждой из n фаз.
 * Если максимум встречается более одного раза, то надо всегда выбирать первый из них.
 */

public class SelectionSortAcmp {
    // {40, 30, 20, 40, 20}
    // {1, 2, 3}
    public static void main(String[] args) {

        // считать с файла
        Scanner input = new Scanner(System.in);
        // вывести в фаил
        PrintWriter output = new PrintWriter(System.out);

        int count = input.nextInt();
        int[] unSortedArray = new int[count];
        // считать с консольного окна
        readInputArray(input, unSortedArray);

        int[] countMax = new int[unSortedArray.length]; //  массив для хранения значения индекса максимального числа на каждой итерации
        sort(unSortedArray, countMax);
       // System.out.println(Arrays.toString(countMax));

        for(int num : countMax){
            output.print(num);
            output.print(" ");
        }
        output.flush();
    }

    //  считать в массив числа с консольного окна
    public static void readInputArray(Scanner input, int[] digit) {
        for (int i = 0; i < digit.length; i++)
        {
            digit[i] = input.nextInt();
        }
    }

    // при поиске максимума, происходит замена макс элемента с последним
    // не отсортированная часть массива уменьшается на 1 элемент
    public static void sort(int[] digit, int[] countMax) {

        int sizeArr = digit.length - 1; //   длина массива
        int indexArrDigit = 0;
        for (int i = sizeArr; i >= 0; i--) {
            int indexMax = 0; // для сохранения значения индекса максимума
            // если максимум встречается более 1 раза, то необходимо выбрать первый
            for (int j = 0; j <= i; j++) {
                if (digit[indexMax] < digit[j]) {
                    indexMax = j; //  сохранение индкса макс элемента
                }
            }
            // записать в массив перестановок индекс переставляемого элемента
            countMax[indexArrDigit] = indexMax;
            indexArrDigit++;
            int buffer = digit[i];
            digit[i] = digit[indexMax];
            digit[indexMax] = buffer;
        }
    }
}
