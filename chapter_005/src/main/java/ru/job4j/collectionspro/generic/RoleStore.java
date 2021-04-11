package ru.job4j.collectionspro.generic;

public class RoleStore extends AbstractStore<Role>  {
    protected RoleStore(int size) {
        super(size);
    }

    @Override
    public String toString() {
        return "RoleStore{"
                +
                "roleStoreData=" + this.storeData + '}';
    }

}

