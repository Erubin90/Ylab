package io.ylab.lesson1.javaRashTasks.level1;
//Уровень 1  4. Знакомство с типами int и String
public class Task1 {

    //3. Раскоментируйте часть кода, чтобы на экран вывелось сообщение "Happy New Year"
    public static void main(String[] args) {
        //1 Объявите переменные name1, name2, name3 типа String. Сразу же в строке объявления присвойте им
        //  какие-нибудь значения. Значениями могут быть любые строки.
        String name1 = "Alisa";
        String name2 = "Gerald";
        String name3 = "Jamal";

        //2 Напиши программу, которая выводит на экран надпись: «Когда я вырасту, то хочу
        //  быть паровым экскаватором!» 10 раз.
        for (int i = 0; i < 10; i++) {
            System.out.println("Когда я вырасту, то хочу быть паровым экскаватором!");
        }
    }
}
