package ru.job4j.collectionspro.map;

import java.util.Calendar;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, int dd, int mm, int yyyy) {
        this.name = name;
        this.children = children;
        this.birthday = Calendar.getInstance();
        this.birthday.set(yyyy, mm, dd);
    }

    /**
     * Как происходит проверка в методе equals -
     * if (this == o) return true; - проверяеться условие равенство обьектов по ссылке
     * если ссылаються на одну и ту же ячейку памяти это одни и теже обьекты.
     * if (!(o instanceof User)) return false; - если клас который породил обьекты не одинаков
     * то это разные обьекты
     * User user = (User) o; потом идет привидение типов полученого обьекта и сравнение поочередно полей обьекта
     * return children == user.children &&
     * name.equals(user.name);
     *
     * @param o - входящий параметр сравниваемый обьект.
     * @return - булево значение идентичности обьектов.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children);
    }
}
