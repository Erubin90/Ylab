package io.ylab.lesson2.javaRashTasks.level4;

import java.util.Scanner;

//Уровень 4 10. Задачи на циклы
public class Task3 {

    /*
    1. 10 чисел
    Вывести на экран числа от 1 до 10, используя цикл while.
     */
    public void tenNumbers() {
        int i = 1;
        while (i <= 10) {
            System.out.println(i++);
        }
    }

    /*
    2. 10 чисел наоборот
    Вывести на экран числа от 10 до 1, используя цикл while.
     */
    public void reverseTenNumber() {
        int i = 10;
        while (i >= 1) {
            System.out.println(i--);
        }
    }

    /*
    3. Хорошего не бывает много
    Ввести с клавиатуры строку и число N.
    Вывести на экран строку N раз, используя цикл while.
    Пример ввода:
    абв
    2
    Пример вывода:
    абв
    абв
     */
    public void thereIsNoSuchThingAsLotOfGood() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.close();

        int i = 0;
        while (i < n) {
            System.out.println(str);
            i++;
        }
    }

    /*
    4. S-квадрат
    Вывести на экран квадрат из 10х10 букв S используя цикл while.
    Буквы в каждой строке не разделять.
     */
    public void  sSquare() {
        int i = 0;
        int j = 0;
        while (i < 10) {
            while (j < 10) {
                System.out.print("S");
                j++;
            }
            System.out.println();
            i++;
        }
    }

    /*
    5. Таблица умноження
    Вывести на экран таблицу умножения 10х10 используя цикл while.
    Числа разделить пробелом.
    Example output:
    1	2	3	4	5	6	7	8	9	10
    2	4	6	8	10	12	14	16	18	20
    3	6	9	12	15	18	21	24	27	30
    ...
     */
    public void multiplicationTable() {
        int i = 1;
        int j = 1;
        while (i <= 10) {
            while (j <= 10) {
                System.out.print(i * j);
                if (j < 10)
                    System.out.print(' ');
                j++;
            }
            System.out.println();
            i++;
        }
    }

}
