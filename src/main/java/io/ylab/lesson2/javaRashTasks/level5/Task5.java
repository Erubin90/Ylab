package io.ylab.lesson2.javaRashTasks.level5;

import java.util.Arrays;
import java.util.Scanner;

//Уровень 5 12. Джон 2
public class Task5 {

    /*
    2. Нужно добавить в программу новую функциональность.

    Старая Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
    Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
     */
    public void two() {
        int[] nums = new int[5];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++)
            nums[i] = scan.nextInt();

        scan.close();

        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min)
                min = num;
        }
        System.out.println(min);
    }

    /*

    3. Задача по алгоритмам.

    Задача: Написать программу, которая:
    1. вводит с консоли число N > 0
    2. потом вводит N чисел с консоли
    3. выводит на экран максимальное из введенных N чисел.
     */
    public void three() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = scan.nextInt();

        scan.close();

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        System.out.println(max);
    }
}
