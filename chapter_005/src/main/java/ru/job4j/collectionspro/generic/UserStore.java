package ru.job4j.collectionspro.generic;

public class UserStore extends AbstractStore<User> {

    protected UserStore(int size) {
        super(size);
    }

    @Override
    public String toString() {
        return "UserStore{"
                +
                "userStoreData=" + this.storeData + '}';
    }
}
