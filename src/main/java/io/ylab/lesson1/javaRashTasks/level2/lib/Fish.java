package io.ylab.lesson1.javaRashTasks.level2.lib;

public class Fish {
    private String name;
    private Owner owner;

    public Fish() {
    }

    public Fish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
