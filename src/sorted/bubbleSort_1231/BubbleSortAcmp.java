package sorted.bubbleSort_1231;
// https://acmp.ru/asp/do/index.asp?main=task&id_course=1&id_section=7&id_topic=118&id_problem=727

import java.io.PrintWriter;
import java.util.Scanner;

public class BubbleSortAcmp {
    public static void main(String[] args) {
        // {12, 7, 92, 5 ,18, 4, 32, 48, 11, 74} - 18
        // {7, 2, 5} - 2

        // решение для acmp
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);

        int count = input.nextInt();
        int[] digit = new int[count];
        //считать с консольного окна
        readInputArray(input, digit);


        // вывести в консоль
        output.println(sort(digit));
        output.flush();

    }

    //  считать в массив числа с консольного окна
    private static void readInputArray(Scanner input, int[] digit) {
        for (int i = 0; i < digit.length; i++)
        {
            digit[i] = input.nextInt();
        }
    }

    //  отсортировать пузырьком и вернуть число инверсий
    public static int sort(int[] digit) {
        int invers = 0;
        // переменная для повторного прохождения по массиву
        boolean needIterator = true;
        while (needIterator) {
            // прохождение по циклу пока  изменяется переменная
            needIterator = false;
            for (int i = 0; i < digit.length - 1; i++) {
                // digit.length-1  для того чтобы не вышел за пределы массива
                // <  поставить, если нужно отсортировать в убывание
                if (digit[i] > digit[i + 1]) {
                    // 1 < 1 исключает массив в 1 элемент
                    int buffer = digit[i];
                    digit[i] = digit[i + 1];
                    digit[i + 1] = buffer;
                    needIterator = true;
                    invers++;
                }
            }
        }
        return invers;
    }
}
