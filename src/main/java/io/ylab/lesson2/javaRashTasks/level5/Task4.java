package io.ylab.lesson2.javaRashTasks.level5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//Уровень 5 12. Джон 1
public class Task4 {

    /*
    2. Man and Woman
    1. Внутри класса Solution создай public static классы Man и Woman.
    2. У классов должны быть поля: name(String), age(int), address(String).
    3. Создай конструкторы, в которые передаются все возможные параметры.
    4. Создай по два объекта каждого класса со всеми данными, используя конструктор.
    5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
     */
    public static class Man {
        String name;
        int age;
        String address;

        public Man(String name) {
            this.name = name;
        }

        public Man(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Man(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    //2. Man and Woman
    public static class Woman {
        String name;
        int age;
        String address;

        public Woman(String name) {
            this.name = name;
        }

        public Woman(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Woman(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    //2. Man and Woman
    public void two() {
        Man igor = new Man("Igor", 25);
        Man sasha = new Man("Sasha", 30, "Moscow");

        Woman natasha = new Woman("Natasha", 20);
        Woman ekaterina = new Woman("Ekaterina", 28);

        System.out.println(igor.name + " " + igor.age + " " + igor.address);
        System.out.println(sasha.name + " " + sasha.age + " " + sasha.address);
        System.out.println(natasha.name + " " + natasha.age + " " + natasha.address);
        System.out.println(ekaterina.name + " " + ekaterina.age + " " + ekaterina.address);
    }

    /*
    4. Вывести на экран сегодняшнюю дату

    Вывести на экран текущую дату в аналогичном виде «21 06 2015».
     */
    public void four() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        System.out.println(format.format(date));
    }

    /*
    5. Вводить с клавиатуры числа и считать их сумму

    Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма».
    Вывести на экран полученную сумму.
     */
    public void five() {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        while (true) {
            String input = scan.nextLine();
            if (input.matches("\\d+"))
                sum += Integer.parseInt(input);
            else if (input.equals("сумма"))
                break;
        }
        scan.close();
        System.out.println(sum);
    }
}


