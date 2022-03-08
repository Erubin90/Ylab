package io.ylab.lesson2.javaRashTasks.level5;

//Уровень 5  5. Задачи на создание своих классов и объектов
public class Task1 {

    /*
1. Создать класс Cat
Создать класс Cat. У кота должно быть имя (name, String),
возраст (age, int), вес (weight, int), сила (strength, int).
 */
    static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat() {

        }

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }

    /*
    2. Реализовать метод fight

    Реализовать метод boolean fight(Cat anotherCat): реализовать механизм драки котов в зависимости от их веса,
    возраста и силы. Зависимость придумать самому. Метод должен определять, выиграли ли мы (this) бой или нет, т.е.
    возвращать true, если выиграли и false - если нет.
    Должно выполняться условие:
    если cat1.fight(cat2) == true , то cat2.fight(cat1) == false
     */

        public boolean fight(Cat anotherCat) {
            int myPower = this.weight * this.strength - this.age;
            int anotherCatPower = anotherCat.getWeight() * anotherCat.getStrength() - anotherCat.getAge();
            return myPower > anotherCatPower;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getWeight() {
            return weight;
        }

        public int getStrength() {
            return strength;
        }
    }

    /*
    3. Геттеры и сеттеры для класса Dog

    Создать class Dog. У собаки должна быть кличка String name и возраст int age.
    Создайте геттеры и сеттеры для всех переменных класса Dog.
     */
    class Dog {
        private String name;

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        /*
        4. Создать три объекта типа Cat

        В методе main создать три объекта типа Cat и заполнить их данными.
        Использовать класс Cat из первой задачи. Класс Cat создавать не надо.
         */
        Cat murka = new Cat("Murka", 1, 6, 10);
        Cat kisa = new Cat("Kisa", 2, 8, 8);
        Cat anchi = new Cat("Anchi", 3, 5, 12);

        /*
        5. Провести три боя попарно между котами
        Создать три кота используя класс Cat.
        Провести три боя попарно между котами.
        Класс Cat создавать не надо. Для боя использовать метод boolean fight(Cat anotherCat).
        Результат каждого боя вывести на экран.
         */
        printFight(murka, kisa);
        printFight(murka, anchi);
        printFight(kisa, murka);
        printFight(kisa, anchi);
        printFight(anchi, kisa);
        printFight(anchi, murka);
    }

    public static void printFight(Cat one, Cat two) {
        System.out.println(one.getName() + " vs " + two.getName());
        Cat winner = one.fight(two) ? one : two;
        System.out.println("Выиграл " + winner.getName());
    }

}

