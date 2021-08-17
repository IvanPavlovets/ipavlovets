package ru.job4j.gc;

public class User {
    private int number;
    private String name;

    public User(int i, String s) {
        this.number = i;
        this.name = s;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %d %s%n", number, name);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
