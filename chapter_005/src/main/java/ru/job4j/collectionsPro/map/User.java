package ru.job4j.collectionsPro.map;

import java.util.Calendar;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, int dd, int MM, int yyyy) {
        this.name = name;
        this.children = children;
        this.birthday = Calendar.getInstance();
        this.birthday.set(yyyy, MM, dd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children);
    }
}
