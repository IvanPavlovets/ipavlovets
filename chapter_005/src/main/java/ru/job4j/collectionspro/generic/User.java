package ru.job4j.collectionspro.generic;

public class User extends Base {
    protected User(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "UserId: " + getId();
    }

}
