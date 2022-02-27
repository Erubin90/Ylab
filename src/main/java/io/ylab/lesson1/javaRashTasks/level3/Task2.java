package io.ylab.lesson1.javaRashTasks.level3;

//Уровень 3 6. Диего
public class Task2 {

    //1	Мама мыла раму
    //Вывести на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
    public void momWashedFrame() {
        String[] words = {"Мама", "Мыла", "Раму"};
        int length = words.length;
        int flag = 0;
        for (int i = 0; i < length; i++) {
            flag = i;
            for (int c = 0; c < length - 1; c++) {
                System.out.print(words[i]);
                flag++;
                for (int j = 0; j < length - 1; j++) {
                    int in = (flag + j) % length;
                    if (in == i)
                        in = ++in % length;
                    System.out.print(words[in]);
                }
                System.out.println();
            }
        }
    }

    //2	Таблица умножения
    //Выведи на экран таблицу умножения 10 на 10 в следующем виде:
    //1 2 3 …
    //2 4 6 …
    //3 6 9 …
    public void multiplicationTable() {
        int count = 10;
        for (int i = 1; i < count + 1; i++) {
            for (int j = 1; j < count + 1; j++) {
                System.out.print(i * j);
                if (j != count)
                    System.out.print(' ');
            }
            System.out.println();
        }
    }

    //3	Семь цветов радуги
    //Создать 7 объектов, чтобы на экран вывелись 7 цветов радуги (ROYGBIV).
    //Каждый объект при создании выводит на экран определенный цвет.
    public void sevenColorsRainbow() {
        new Red();
        new Orange();
        new Yellow();
        new Green();
        new Blue();
        new Indigo();
        new Violet();
    }

    //4	Экранирование символов
    //Вывести на экран следующий текст - две строки:
    //It's Windows path: "C:\Program Files\Java\jdk1.7.0\bin"
    //It's Java string: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"
    public void escapingCharacters() {
        System.out.println("It's Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"");
        System.out.println("It's Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"");
    }

    //5	Изучаем японский
    //Выведи на экран 日本語
    public void learningJapanese() {
        System.out.println("日本語");
    }

}

class Red {
    public Red() {
        System.out.println("Red");
    }
}

class Orange {
    public Orange() {
        System.out.println("Orange");
    }
}

class Yellow {
    public Yellow() {
        System.out.println("Yellow");
    }
}

class Green {
    public Green() {
        System.out.println("Green");
    }
}

class Blue {
    public Blue() {
        System.out.println("Blue");
    }
}

class Indigo {
    public Indigo() {
        System.out.println("Indigo");
    }
}

class Violet {
    public Violet() {
        System.out.println("Violet");
    }
}