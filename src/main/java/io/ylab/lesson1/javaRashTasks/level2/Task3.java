package io.ylab.lesson1.javaRashTasks.level2;
//Уровень 2 8. Задачи на вызов функций.
public class Task3 {

    //1	Минимум двух чисел - Написать функцию, которая возвращает минимум из двух чисел.
    public int min(int a, int b) {
        if (a > b)
            return b;
        else
            return a;
    }

    //2	Максимум двух чисел - Написать функцию, которая вычисляет максимум из двух чисел.
    public int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    //3	Минимум трёх чисел - Написать функцию, которая вычисляет минимум из трёх чисел.
    public int min(int a, int b, int c) {
         return min(min(a, b), c);
    }

    //4	Минимум четырёх чисел - Написать функцию, которая вычисляет минимум из четырёх чисел.
    //  Функция min(a,b,c,d) должна использовать (вызывать) функцию min(a,b)
    public int min(int a, int b, int c, int d) {
        return min(min(a, b), min(c, d));
    }

    //5	Дублирование строки - Написать функцию, которая выводит переданную строку на экран три раза,
    //  каждый раз с новой строки.
    public void printTextNewLine(String text) {
        for (int i = 0; i < 3; i++) {
            System.out.println(text);
        }
    }

    //6	Вывод текста на экран - Написать функцию, которая выводит переданную строку (слово) на экран
    //  три раза, но в одной строке. Слова должны быть разделены пробелом и не должны сливаться в одно.
    public void printTextOneLine(String text) {
        for (int i = 0; i < 3; i++) {
            System.out.print(text);
            if (i < 2) {
                System.out.print(" ");
            }
        }
    }
}
