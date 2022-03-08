package io.ylab.lesson2.javaRashTasks.level4;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {

    /*
    1. Я никогда не буду работать за копейки
    Используя цикл вывести на экран сто раз надпись:
    «Я никогда не буду работать за копейки. Амиго»
     */
    public void one() {
        for(int i = 0; i < 100; i++)
            System.out.println("Я никогда не буду работать за копейки. Амиго");
    }

    /*
    2. Среднее такое среднее
    Ввести с клавиатуры три числа, вывести на экран среднее из них, т.е. не самое большое и не самое маленькое.
     */
    public void two() {
        int[] nums = new int[3];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++)
            nums[i] = scan.nextInt();
        scan.close();
        Arrays.sort(nums);
        System.out.println(nums[1]);
    }

    /*
    3. Посчитать сумму чисел
    Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1,
    вывести на экран сумму и завершить программу. -1 должно учитываться в сумме.
     */
    public void three() {
        int sum = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            int num = scan.nextInt();
            sum += num;
            if (num == -1)
                break;
        }
        scan.close();
        System.out.println(sum);
    }

    /*
    4. Меня зовут 'Вася'...

    Ввести с клавиатуры строку name.
    Ввести с клавиатуры дату рождения (три числа): y, m, d.
    Вывести на экран текст:
    «Меня зовут name
    Я родился d.m.y»
    Пример:
    Меня зовут Вася
    Я родился 15.2.1988
     */
    public void four() {
        int[] date = new int[3];
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        for (int i = 0; i < date.length; i++)
            date[i] = scan.nextInt();
        scan.close();

        System.out.printf("Меня зовут %s\n Я родился %d.%d.%d\n", name, date[0], date[1], date[2]);
    }
}
