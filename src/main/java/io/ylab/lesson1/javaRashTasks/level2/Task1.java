package io.ylab.lesson1.javaRashTasks.level2;

import io.ylab.lesson1.javaRashTasks.level2.lib.Cat;
import io.ylab.lesson1.javaRashTasks.level2.lib.Dog;
//Уровень 2 3. Что такое объекты.
public class Task1 {

    public static void main(String[] args) {
        //1.Создать объект типа Cat 2 раза.
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();

        //2.Создать 3 объекта типа Dog (собака) и присвоить им имена "Max", "Bella", "Jack".
        Dog max = new Dog("Max");
        Dog bella = new Dog("Bella");
        Dog jack = new Dog("Jack");

        //3.Напиши программу, которая выводит на экран надпись: «Мне так плохо! Хочу, чтобы все умерли!».
        System.out.println("Мне так плохо! Хочу, чтобы все умерли!");
    }
}
