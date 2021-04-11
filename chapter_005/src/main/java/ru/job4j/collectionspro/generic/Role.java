package ru.job4j.collectionspro.generic;

public class Role extends Base {
    protected Role(String id) {
        super(id);
    }

    @Override
    public String toString() {
        return "RoleId: " + getId();
    }
}
