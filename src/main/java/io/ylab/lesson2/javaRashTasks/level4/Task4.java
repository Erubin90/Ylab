package io.ylab.lesson2.javaRashTasks.level4;

import java.util.Scanner;

//Уровень 4 13. Задачи на for
public class Task4 {

    public static void main(String[] args) {
        Task4 task4 = new Task4();
        task4.drawTriangle();
    }

    /*
    1. Четные числа
    Используя цикл for вывести на экран чётные числа от 1 до 100 включительно.
    Через пробел либо с новой строки.
     */
    public void evenNumbers() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }

    /*
    2. Рисуем прямоугольник
    Ввести с клавиатуры два числа m и n.
    Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.

    Пример: m=2, n=4
    8888
    8888
     */
    public void drawRectangle() {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(8);
            System.out.println();
        }
    }

    /*
    3. Рисуем треугольник
    Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.

    Пример:
    8
    88
    888
    ...
     */
    public void drawTriangle() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(8);
            System.out.println();
        }
    }

    /*
    4. Рисуем линии

    Используя цикл for вывести на экран:
    - горизонтальную линию из 10 восьмёрок
    - вертикальную линию из 10 восьмёрок.
     */
    public void drawLines() {
        for (int i = 0; i < 10; i++)
            System.out.print(8);
        System.out.println();
        for (int i = 0; i < 10; i++)
            System.out.println(8);
    }

    /*
    5. Все любят Мамбу
    Ввести с клавиатуры имя и, используя цикл for 10 раз, вывести: [*имя* любит меня.]

    Пример текста:
    Света любит меня.
    Света любит меня.
    …
     */
    public void everyoneLovesMamba() {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        scan.close();

        for (int i = 0; i < 10; i++)
            System.out.println(name + "меня любит");
    }
}
