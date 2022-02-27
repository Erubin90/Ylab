package io.ylab.lesson1.javaRashTasks.level3;

import java.util.Scanner;

//Уровень 3 12. Дополнительные задания
public class Task4 {

    //1	Жить хорошо, а хорошо жить еще лучше
    //Вывести на экран надпись «Жить хорошо, а хорошо жить еще лучше»
    public void liveWellAndLiveWellSsEvenBetter() {
        System.out.println("Жить хорошо, а хорошо жить еще лучше");
    }

    //2	Я не хочу изучать Java, я хочу большую зарплату
    //Вывести на экран десять раз надпись «Я не хочу изучать Java, я хочу большую зарплату»
    public void iDontWantLearnJavaIWantBigSalary() {
        for (int i = 0; i < 10; i++)
            System.out.println("Я не хочу изучать Java, я хочу большую зарплату");
    }

    //3	Я буду зарабатывать $50 в час
    //Ввести с клавиатуры число n. Вывести на экран надпись «Я буду зарабатывать $n в час».
    //Пример:
    //Я буду зарабатывать $50 в час
    public void iWillEarnFiftyDollarsAnHour() {
        Scanner scan = new Scanner(System.in);
        int salary = scan.nextInt();
        scan.close();
        System.out.println("Я буду зарабатывать $" + salary + " в час");
    }
}
