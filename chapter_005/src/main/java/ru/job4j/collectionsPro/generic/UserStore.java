package ru.job4j.collectionsPro.generic;

public class UserStore extends AbstractStore<User> {

    protected UserStore(int size) {
        super(size);
    }

    @Override
    public String toString() {
        return "UserStore{" +
                "userStoreData=" + this.storeData +
                '}';
    }
}
