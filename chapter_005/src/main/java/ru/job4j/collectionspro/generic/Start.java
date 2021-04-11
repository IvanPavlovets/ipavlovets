package ru.job4j.collectionspro.generic;

public class Start {

    public static void main(String[] args) {
        UserStore store = new UserStore(5);
        store.add(new User("001"));
        store.add(new User("002"));
        store.add(new User("003"));
        store.add(new User("004"));
        store.add(new User("005"));

        System.out.println(store);
        System.out.println(store.findById("002"));

        System.out.println(store.delete("002"));
        System.out.println(store);

        System.out.println(store.replace("001", new User("003")));
        System.out.println(store);


        RoleStore store1 = new RoleStore(5);
        store1.add(new Role("001"));
        store1.add(new Role("002"));
        store1.add(new Role("003"));
        store1.add(new Role("004"));
        store1.add(new Role("005"));

        System.out.println(store1);
        System.out.println(store1.findById("002"));

        System.out.println(store1.delete("002"));
        System.out.println(store1);

        System.out.println(store1.replace("001", new Role("003")));
        System.out.println(store1);

    }

}
