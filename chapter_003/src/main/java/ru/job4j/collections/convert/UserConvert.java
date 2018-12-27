package ru.job4j.collections.convert;

import java.util.*;

public class UserConvert {
    /**
     * Метод принимает список пользователей
     * и конвертирует его в Map с ключом Integer id
     * и соответвующем ему User.
     * @param list - список пользователей.
     * @return - результат конвертации в Map.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userMap = new HashMap<>();
        for (User user : list) {
            userMap.put(user.getId(), user);
        }
        return userMap;
    }

    public static void main(String[] args) {
        List<User> users = Arrays.asList(new User(10, "Ivan", "Zneleznogorsk"),
                new User(20, "Petr", "Briansk"),
                new User(30, "Vadim", "Moscow"));


        Map<Integer, User> userMap = new HashMap<>();


        for (User user : users) {
            userMap.put(user.getId(), user);
        }

        Collection<User> users2 = userMap.values();

        for (User user : users2) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getCity());
        }

        System.out.println(users);
    }
}
