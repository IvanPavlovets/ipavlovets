package ru.job4j.collectionsPro.generic;

public class Role extends Base {
    protected Role(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "RoleId: " + getId();
    }
}
