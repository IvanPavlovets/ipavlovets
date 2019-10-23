package ru.job4j.collectionsPro.generic;

public class RoleStore<Role> extends AbstractStore  {
    protected RoleStore(int size) {
        super(size);
    }

    @Override
    public String toString() {
        return "RoleStore{" +
                "roleStoreData=" + this.storeData +
                '}';
    }

}

