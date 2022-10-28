package sorted.selectionSort_1702;
// https://acmp.ru/asp/do/index.asp?main=task&id_course=1&id_section=7&id_topic=118&id_problem=726

import java.util.Arrays;

/**
 * В этой задаче вам предлагается реализовать сортировку выбором.
 *
 * Задан массив целых чисел a0, a1, …, an−1. Отсортируем его следующим образом:
 *
 * выберем наибольший элемент массива и поменяем его местами с последним элементом
 * (если последний и есть найденный максимум, то обмен можно не совершать),
 * исключим из рассмотрения последний элемент и если длина оставшегося участка
 * больше нуля перейдем опять к предыдущему пункту.
 * Таким образом, этот алгоритм состоит их n фаз,
 * на каждой из которых выбирается максимум. Ваша задача реализовать эту сортировку
 * описанным способом и вывести n чисел — индексы максимума на каждой из n фаз.
 * Если максимум встречается более одного раза, то надо всегда выбирать первый из них.
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] unSortedArray = {2, 1, 4, 8, 7, 5, 6, 3};
        sort(unSortedArray);
        System.out.println(Arrays.toString(unSortedArray));
    }

    public static void sort(int[] digit){
        int size = digit.length-1; // -1 т.к. хранит длину массива, а не число с учетом 0
        // т.е. если в массиве 8 элементов, то сохранит число 8, а не 7
        int indexMax; // переменная для хранения макс индекса

        for(int iArr = size; iArr >= 0; iArr-- ){
            indexMax = iArr; //  считаем, что первый элемент максимум
            for(int currentIndex = iArr; currentIndex > 0; currentIndex--){
                // iArr  исключает рассматрение отсортированного элемента
                if(digit[indexMax] < digit[currentIndex]){
                    indexMax = currentIndex;
                }
            }
            // поменять местами элементы
            int buffer = digit[iArr];
            digit[iArr] = digit[indexMax];
            digit[indexMax] = buffer;
        }
    }
}
