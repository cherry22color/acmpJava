package sorted.pupil_1016;
// https://acmp.ru/asp/do/index.asp?main=task&id_course=1&id_section=7&id_topic=126&id_problem=790
/**
 * Первая строка входного файла INPUT.TXT содержит натуральное число N – количество учеников (N ≤ 100).
 * Далее, для каждого ученика определены 4 строки, содержащие фамилию, имя,
 * класс и дату рождения соответственно. Фамилия и имя – строки,
 * не превышающие 20 символов английского алфавита: первая буква заглавная,
 * остальные – строчные. Класс – строка, состоящая из числа (от 1 до 11)
 * и заглавной английской буквы (от «A» до «Z»). Дата рождения – строка в формате «ДД.ММ.ГГ».
 * Гарантируется, что внутри одного класса нет однофамильцев.
 *
 * 9A Ivanov Ivan 10.04.93
 * 9A Sidorov Sidor 20.07.93
 * 10B Petrov Petr 23.10.92
 */

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // считать с файла
        Scanner input = new Scanner(System.in);
        //  вывести в фаил
        PrintWriter output = new PrintWriter(System.out);
        int count = input.nextInt();

        final Pupil[] pupil = new Pupil[count];
        // readInpurArray(input, pupil);
        for (int i = 0; i < pupil.length; i++) {
            pupil[i] = new Pupil(input.next(), input.next(), input.next(), input.next());
        }

        compareObject(pupil);

        for (Pupil pupilObject : pupil) {
            output.println(pupilObject.classroom + " " + pupilObject.lastname + " " + pupilObject.name + " " +
                    pupilObject.date);
        }
        output.flush();
    }

    // метод сортирующий объекты в массиве объектов
    private static void compareObject(Pupil[] pupil) {
        Arrays.sort(pupil, new Comparator<Pupil>() {
            // проверка: номер класса, буква класса, фамилия, имя, год рождения, месяц рождения, день рождения
            @Override
            public int compare(Pupil pupil1, Pupil pupil2) {
                int digit = (pupil1.numberClass - pupil2.numberClass);
                if (digit == 0) {
                    digit = pupil1.nameClass.compareTo(pupil2.nameClass);
                    if (digit == 0) {
                        digit = pupil1.lastname.compareTo(pupil2.lastname);
                        if (digit == 0) {
                            digit = pupil1.name.compareTo(pupil2.name);
                            if (digit == 0) {
                                digit = pupil1.year - pupil2.year;
                                if (digit == 0) {
                                    digit = pupil1.month - pupil2.month;
                                    if (digit == 0) {
                                        digit = pupil1.day - pupil2.day;
                                    }
                                }
                            }
                        }
                    }
                }
                return digit;
            }
        });
    }

}

class Pupil {
    String lastname;
    String name;
    String classroom;
    String date;
    // номер класса
    String nameClass;
    int numberClass;
    // дата рождения
    int day = 0;
    int month = 0;
    int year = 0;

    public Pupil(String lastname, String name, String classroom, String date) {
        this.lastname = lastname;
        this.name = name;
        this.classroom = classroom;
        this.date = date;
        // сохранить номер класса в переменные
        int sizeStr = classroom.length();
        this.nameClass = classroom.substring(sizeStr - 1);
        this.numberClass = Integer.parseInt(classroom.substring(0, sizeStr - 1));
        // сохранить дату рождения
        String[] dateArr = date.split("\\."); // \\ регулярные выражения
        day = Integer.parseInt(dateArr[0]);
        month = Integer.parseInt(dateArr[1]);
        year = Integer.parseInt(dateArr[2]);
    }
}



