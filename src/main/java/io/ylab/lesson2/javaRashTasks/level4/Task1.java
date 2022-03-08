package io.ylab.lesson2.javaRashTasks.level4;

//Уровень 4  2. Задачи на видимость переменных
public class Task1 {

    /*
    5. Написать код, который бы подсчитывал количество созданных котов (count) и на экран
    выдавалось правильно их количество.
     */
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        //написать тут ваш код

        /*
        Добавил в конструктор код который увеличивает переменную catsCount на 1
        при каждом создании объекта класса Сat
        */

        Cat cat2 = new Cat();
        //написать тут ваш код

        System.out.println("Cats count is " + Cat.getCatsCount());
    }

}

class Cat {

    private String name;

    private String fullName;

    private static int catsCount = 0;


    public Cat() {
        //При создании объекта класса Cat увеличивает переменную catsCount на 1
        catsCount++;
    }

    /*
    1. Реализовать метод setName, чтобы с его помощью можно было устанавливать значение переменной
    private String name равное переданному параметру String name.
     */
    public void setName(String name) {
        //написать тут ваш код
        this.name = name;
    }

    /*
    2. Реализовать метод addNewCat, чтобы при его вызове (т.е. добавлении нового кота), количество котов
    увеличивалось на 1. За количество котов отвечает переменная catsCount.
     */
    public static void addNewCat() {
        //написать тут ваш код
        catsCount++;
    }

    /*
    3. Реализовать метод setCatsCount так, чтобы с его помощью можно было устанавливать значение
    переменной catsCount равное переданному параметру.
     */
    public static void setCatsCount(int catsCount) {
        //написать тут ваш код
        Cat.catsCount = catsCount;
    }

    /*
    4. Реализовать метод setName, чтобы с его помощью можно было устанавливать значение переменной
    private String fullName равное значению локальной переменной String fullName.
     */
    public void setName(String firstName, String lastName)
    {
        String fullName = firstName + lastName;
        //написать тут ваш код
        this.fullName = fullName;
    }


    public static int getCatsCount() {
        return catsCount;
    }
}
