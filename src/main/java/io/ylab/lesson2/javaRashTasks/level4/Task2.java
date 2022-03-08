package io.ylab.lesson2.javaRashTasks.level4;

import java.util.*;

//Уровень 4  6. Задачи на условные операторы
public class Task2 {

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        task2.sortingThreeNumbers();
    }

    /*
    Задача 1. Минимум двух чисел
    Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
     */
    public void minimumTwoNumbers() {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        scanner.close();
        int min = num1; // = Math.min(num1, num2);

        if (num1 > num2)
            min = num2;
        System.out.println(min);
    }

    /*
    Задача 2. Максимум четырех чисел
    Ввести с клавиатуры четыре числа, и вывести максимальное из них.
     */
    public void maximumFourNumbers() {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int num4 = scanner.nextInt();
        scanner.close();

        int max; // = Math.max(Math.max(num1, num2), Math.max(num3, num4);
        int max1 = num1;
        int max2 = num3;

        if (max1 < num2)
            max1 = num2;
        if (max2 < num4)
            max2 = num4;

        max = max1;
        if (max < max2)
            max = max2;

        System.out.println(max);
    }

    /*
    Задача 3. Сортировка трех чисел
    Ввести с клавиатуры три числа, и вывести их в порядке убывания.
     */
    public void sortingThreeNumbers() {
        int[] nums = new int[3];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        int count = nums.length;
        while (count == nums.length) {
            count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    int min = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = min;
                }
                else
                    count++;
            }
        }

        for (var num : nums) {
            System.out.println(num);
        }
    }

    /*
    Задача 4. Сравнить имена
    Ввести с клавиатуры два имени, и если имена одинаковые, вывести сообщение «Имена идентичны».
    Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
     */
    public void compareNames() {
        Scanner scanner = new Scanner(System.in);
        String name1 = scanner.nextLine();
        String name2 = scanner.nextLine();
        scanner.close();

        if (name1.equals(name2))
            System.out.println("Имена идентичны");
        else {
            if(name1.length() == name2.length())
                System.out.println("Длины имен равны");
        }
    }

    /*
    Задача 5. 18+
    Ввести с клавиатуры имя и возраст. Если возраст меньше 18 вывести надпись «Подрасти еще»
     */
    public void isFullAge() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        scanner.close();

        if (age < 18)
            System.out.println("Подрасти еще");
    }

    /*
    Задача 6. И 18-ти достаточно
    Ввести с клавиатуры имя и возраст.
    Если возраст больше 20 вывести надпись «И 18-ти достаточно»
     */
    public void andEighteenIsEnough() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = scanner.nextInt();
        scanner.close();

        if (age > 20)
            System.out.println("И 18-ти достаточно");
    }
}
