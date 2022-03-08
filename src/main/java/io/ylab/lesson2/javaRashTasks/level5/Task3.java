package io.ylab.lesson2.javaRashTasks.level5;

//Уровень 5 9. Задачи на конструкторы
public class Task3 {

    /*
    1. Создать класс Friend

    Создать класс Friend (друг) с тремя конструкторами:
    - Имя
    - Имя, возраст
    - Имя, возраст, пол
     */
    class Friend {
        private String name;

        private int age;

        private String gender;

        public Friend(String name) {
            this.name = name;
        }

        public Friend(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Friend(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }
    }

    /*
    2. Создать класс Cat

    Создать класс Cat (кот) с пятью конструкторами:
    - Имя,
    - Имя, вес, возраст
    - Имя, возраст (вес стандартный)
    - вес, цвет, (имя, адрес и возраст – неизвестные. Кот - бездомный)
    - вес, цвет, адрес ( чужой домашний кот)

    Задача конструктора – сделать объект валидным. Например, если вес не известен,
    то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста.
    А вот имени может и не быть (null). То же касается адреса: null.
     */
    class Cat {
        private String name;

        private int age = 2;

        private int weight = 8;

        private String color;

        private String address;

        public Cat(String name) {
            this.name = name;
        }

        public Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Cat(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Cat(int weight, String color, String address) {
            this.weight = weight;
            this.color = color;
            this.address = address;
        }
    }


    /*
    3. Создать класс Dog

    Создать класс Dog (собака) с тремя конструкторами:
    - Имя
    - Имя, рост
    - Имя, рост, цвет
     */
    class Dog{

        private String name;

        private int height;

        private String color;

        public Dog(String name) {
            this.name = name;
        }

        public Dog(String name, int height) {
            this.name = name;
            this.height = height;
        }

        public Dog(String name, int height, String color) {
            this.name = name;
            this.height = height;
            this.color = color;
        }
    }

    /*
    4. Создать класс Circle

    Создать класс (Circle) круг, с тремя конструкторами:
    - centerX, centerY, radius
    - centerX, centerY, radius, width
    - centerX, centerY, radius, width, color
     */
    class Circle {
        private int centerX, centerY, radius, width, color;

        public Circle(int centerX, int centerY, int radius) {
            this.centerX = centerX;
            this.centerY = centerY;
            this.radius = radius;
        }

        public Circle(int centerX, int centerY, int radius, int width) {
            this.centerX = centerX;
            this.centerY = centerY;
            this.radius = radius;
            this.width = width;
        }

        public Circle(int centerX, int centerY, int radius, int width, int color) {
            this.centerX = centerX;
            this.centerY = centerY;
            this.radius = radius;
            this.width = width;
            this.color = color;
        }
    }

    /*
    5. Создать класс прямоугольник (Rectangle)

    Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше конструкторов:

    Примеры:
    - заданы 4 параметра: left, top, width, height
    - ширина/высота не задана (оба равны 0)
    - высота не задана (равно ширине) создаём квадрат
    - создаём копию другого прямоугольника (он и передаётся в параметрах)
     */
    class Rectangle {
        private int top, left, width, height;

        public Rectangle(int top, int left, int width, int height) {
            this.top = top;
            this.left = left;
            this.width = width;
            this.height = height;
        }

        public Rectangle(int top, int left) {
            this.top = top;
            this.left = left;
        }

        public Rectangle(int top, int left, int width) {
            this.top = top;
            this.left = left;
            this.width = width;
            this.height = width;
        }

        public Rectangle(Task2.Rectangle rectangle) {
            this.top = rectangle.getTop();
            this.left = rectangle.getLeft();
            this.width = rectangle.getWidth();
            this.height = rectangle.getHeight();
        }

        public int getTop() {
            return top;
        }

        public int getLeft() {
            return left;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}
