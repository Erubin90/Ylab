package io.ylab.lesson1.javaRashTasks.level3;

import io.ylab.lesson1.javaRashTasks.level3.lib.Protoss;
import io.ylab.lesson1.javaRashTasks.level3.lib.Terran;
import io.ylab.lesson1.javaRashTasks.level3.lib.Zerg;
//Уровень 3 4. Хулио
public class Task1 {

    //1	Дата рождения
    //Вывести на экран дату своего рождения в виде: MAY 1 2012
    public void dateBirth() {
        System.out.println("March 6 1997");
    }

    //2	4 скобки Расставить правильно (по другому) скобки, чтобы на экран вывелось число 850

    //3	StarCraft
    //Создать 10 зергов, 5 протосов и 12 терран.
    //Дать им всем уникальные имена.
    public void startCraft() {
        Zerg z1 = new Zerg();
        z1.name = "Zerg 1";
        Zerg z2 = new Zerg();
        z2.name = "Zerg 2";
        Zerg z3 = new Zerg();
        z3.name = "Zerg 3";
        Zerg z4 = new Zerg();
        z4.name = "Zerg 4";
        Zerg z5 = new Zerg();
        z5.name = "Zerg 5";
        Zerg z6 = new Zerg();
        z6.name = "Zerg 6";
        Zerg z7 = new Zerg();
        z7.name = "Zerg 7";
        Zerg z8 = new Zerg();
        z8.name = "Zerg 8";
        Zerg z9 = new Zerg();
        z9.name = "Zerg 9";
        Zerg z10 = new Zerg();
        z10.name = "Zerg 10";

        Protoss p1 = new Protoss();
        p1.name = "Protoss 1";
        Protoss p2 = new Protoss();
        p2.name = "Protoss 2";
        Protoss p3 = new Protoss();
        p3.name = "Protoss 3";
        Protoss p4 = new Protoss();
        p4.name = "Protoss 4";
        Protoss p5 = new Protoss();
        p5.name = "Protoss 5";

        Terran t1 = new Terran();
        t1.name = "Terran 1";
        Terran t2 = new Terran();
        t2.name = "Terran 2";
        Terran t3 = new Terran();
        t3.name = "Terran 3";
        Terran t4 = new Terran();
        t4.name = "Terran 4";
        Terran t5 = new Terran();
        t5.name = "Terran 5";
        Terran t6 = new Terran();
        t6.name = "Terran 6";
        Terran t7 = new Terran();
        t7.name = "Terran 7";
        Terran t8 = new Terran();
        t8.name = "Terran 8";
        Terran t9 = new Terran();
        t9.name = "Terran 9";
        Terran t10 = new Terran();
        t10.name = "Terran 10";
        Terran t11 = new Terran();
        t11.name = "Terran 11";
        Terran t12 = new Terran();
        t12.name = "Terran 12";
    }

    //4	Произведение 10 чисел
    //Вывести на экран произведение чисел от 1 до 10.
    //Подсказка: будет три миллиона с хвостиком
    public void productTenNumbers() {
        long result = 1;
        for (int i = 2; i <= 10; i++) {
            result *= i;
        }
        System.out.println(result);
    }

    //6	Сумма 10 чисел
    //Вывести на экран сумму чисел от 1 до 10 построчно:
    //Пример вывода:
    //1
    //3
    //6
    //10
    //…
    public static void sumTenNumbers() {
        int sum = 1;
        System.out.println(sum);
        for (int i = 2; i < 10; i++) {
            sum += i;
            System.out.println(sum);
        }
    }

}
