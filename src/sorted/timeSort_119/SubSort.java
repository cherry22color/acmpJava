package sorted.timeSort_119;

import java.io.PrintWriter;
import java.util.*;
// https://acmp.ru/asp/do/index.asp?main=task&id_course=1&id_section=7&id_topic=118&id_problem=728

/**
 * Во входном файле INPUT.TXT в первой строке записано число N (1 ≤ N ≤ 100), а в последующих
 * N строках N моментов времени. Каждый момент времени задается 3 целыми числами
 * - часы (от 0 до 23), минуты (от 0 до 59) и секунды (от 0 до 59).
 * <p>
 * 4
 * 10 20 30
 * 7 30 00
 * 23 59 59
 * 13 30 30
 */

public class SubSort {
    public static void main(String[] args) {

        // считать с файла
        Scanner input = new Scanner(System.in);
        // вывести в фаил
        PrintWriter output = new PrintWriter(System.out);
        int sizeArr = input.nextInt(); // размер массива
        ArrayList<Time> times = new ArrayList<Time>();

        for (int i = 0; i < sizeArr; i++) {
            times.add(new Time(input.nextInt(), input.nextInt(), input.nextInt()));
        }

        // Сортировка коллекции по нескольким полям с использованием лямбда выражений
        Collections.sort(times, Comparator.comparing(Time::getHour)
                .thenComparing(Time::getMin)
                .thenComparing(Time::getSec));

        for (Time timeObj : times) {
            output.println(timeObj);
        }
        output.flush();
    }
}

// класс для создания объектов фиксированного времени
class Time {
    int sec;
    int min;
    int hour;

    public Time(int hour, int min, int sec) {
        this.sec = sec;
        this.min = min;
        this.hour = hour;
    }

    public int getSec() {
        return sec;
    }

    public int getMin() {
        return min;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return hour + " " + min + " " + sec;
    }
}

// класс для сортировки по минутам
class SortMin implements Comparator<Time> {

    @Override
    public int compare(Time time1, Time time2) {
        int digit;
        if (time1.min < time2.min) {
            digit = -1;
        } else if (time1.min > time2.min) {
            digit = 1;
        } else {
            digit = 0;
        }
        return digit;
    }
}

// класс для сортировки по часам
class SortHour implements Comparator<Time> {

    @Override
    public int compare(Time time1, Time time2) {
        int digit;
        if (time1.hour < time2.hour) {
            digit = -1;
        } else if (time1.hour > time2.hour) {
            digit = 1;
        } else {
            digit = 0;
        }
        return digit;
    }
}
