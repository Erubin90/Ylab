package io.ylab.lesson1.javaRashTasks.level2;

import io.ylab.lesson1.javaRashTasks.level2.lib.Cat;
import io.ylab.lesson1.javaRashTasks.level2.lib.Dog;
import io.ylab.lesson1.javaRashTasks.level2.lib.Fish;
import io.ylab.lesson1.javaRashTasks.level2.lib.Woman;
//Уровень 2 5. Диего
public class Task2 {

    //1.Закоментарь несколько строк, чтобы на экран вывелось число 19
    public static void main(String[] args) {
        //2.Создайте 10 переменных типа Cat и 8 объектов типа Cat.
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4;
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7;
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();
        Cat cat10 = new Cat();

        //3.Создайте объект типа Cat(кот), объект типа Dog (собака), объект типа Fish (рыбка) и объект типа Woman.
        //  Присвойте каждому животному владельца (owner).
        Cat cat = new Cat("кот");
        Dog dog = new Dog("собака");
        Fish fish = new Fish("рыбка");
        Woman woman = new Woman();
        cat.setOwner(woman);
        dog.setOwner(woman);
        fish.setOwner(woman);
    }
}
