package sorted.timeSort_119;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class InsertSortAcmp {
    public static void main(String[] args) {

        // считать с файла
        Scanner input = new Scanner(System.in);
        // вывести в фаил
        PrintWriter output = new PrintWriter(System.out);
        int sizeArr = input.nextInt(); // размер массива
        Time[] times = new Time[sizeArr];

        for (int i = 0; i < times.length; i++) {
            times[i] = new Time(input.nextInt(), input.nextInt(), input.nextInt());
        }

        Arrays.sort(times, new SortSec());
        Arrays.sort(times, new SortMin());
        Arrays.sort(times, new SortHour());


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

    @Override
    public String toString() {
        return hour + " " + min + " " + sec;
    }


}

// класс для сортиртировки по секундам
class SortSec implements Comparator <Time> {

    @Override
    public int compare(Time time1, Time time2) {
       int digit;
        if(time1.sec < time2.sec){
            digit = -1;
        }else if(time1.sec > time2.sec){
            digit = 1;
        } else{
            digit = 0;
        }
        return digit;
    }
}

// класс для сортировки по минутам
class SortMin implements Comparator<Time>{

    @Override
    public int compare(Time time1, Time time2) {
        int digit;
        if(time1.min < time2.min){
            digit = -1;
        }else if(time1.min > time2.min){
            digit = 1;
        } else{
            digit = 0;
        }
        return digit;
    }
}

// класс для сортировки по часам
class SortHour implements Comparator<Time>{

    @Override
    public int compare(Time time1, Time time2) {
        int digit;
        if(time1.hour < time2.hour){
            digit = -1;
        }else if(time1.hour > time2.hour){
            digit = 1;
        } else{
            digit = 0;
        }
        return digit;
    }
}
