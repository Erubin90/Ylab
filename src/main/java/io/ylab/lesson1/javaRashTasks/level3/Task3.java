package io.ylab.lesson1.javaRashTasks.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Уровень 3 8. Диего
public class Task3 {

    //1	Как захватить мир
    //Ввести с клавиатуры число и имя, вывести на экран строку: «имя» захватит мир через «число» лет. Му-ха-ха!
    //( Последовательность вводимых данных имеет большое значение.)
    //Пример:
    //Вася захватит мир через 8 лет. Му-ха-ха!
    public void howTakeOverWorld() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int year = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.printf("%s захватит мир через %d лет. Му-ха-ха!", line, year);
    }

    //2 Зарплата через 5 лет
    //Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись: «Имя» получает «число1» через «число2» лет.
    //Пример:
    //Коля получает 3000 через 5 лет.
    public void salaryFiveYears() {
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        int salary = scan.nextInt();
        int countYears = scan.nextInt();
        scan.close();

        System.out.printf("%s получает %d через %d лет", name, salary, countYears);
    }

    //3	Скромность украшает человека
    //Ввести с клавиатуры имя и вывести надпись: name зарабатывает $5,000. Ха-ха-ха!
    public void modestyAdornsPerson() {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        scan.close();
        System.out.println(name + " зарабатывает $5,000. Ха-ха-ха!");
    }

    //4	Спонсор - это звучит гордо
    //Ввести с клавиатуры два имени и вывести надпись:
    //name1 проспонсировал name2, и она стала известной певицей.
    public void SponsorItSoundsProud() {
        Scanner scan = new Scanner(System.in);
        String name1 = scan.nextLine();
        String name2 = scan.nextLine();
        scan.close();
        System.out.println(name1 + " проспонсировал  " + name2 + ", и она стала известной певицей.");
    }

    //5	Чистая любовь
    //Ввести с клавиатуры три имени, вывести на экран надпись name1 + name2 + name3 = Чистая любовь, да-да!
    //Пример:
    //Вася + Ева + Анжелика = Чистая любовь, да-да!
    public void pureLove() {
        Scanner scan = new Scanner(System.in);
        String name1 = scan.nextLine();
        String name2 = scan.nextLine();
        String name3 = scan.nextLine();
        scan.close();
        System.out.println(name1 + " + " + name2 + " + " + name3 + " = Чистая любовь, да-да!");
    }
}
