package ru.job4j.collections.transfers;

import java.util.*;
import java.util.stream.Collectors;

public class BankController {

    /**
     * Коллекция хранилище пользовательских счетов.
     */
    private Map<User, List<Account>> usersCollection;

    public BankController() {
        usersCollection = new TreeMap<>();
    }

    public Map<User, List<Account>> getUsersCollection() {
        return usersCollection;
    }

    /**
     * Метод добавления пользователя.
     *
     * @param user
     */
    public void addUser(User user) {
        this.usersCollection.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаления пользователя.
     *
     * @param user
     */
    public void deleteUser(User user) {
        this.usersCollection.remove(user);
    }

    /**
     * Метод добавления 1 счета пользователю.
     *
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        this.usersCollection.get((this.usersCollection.keySet().stream().filter(
                user -> user.getPassport().contains(passport)
        ).collect(Collectors.toList())).get(0)).add(account);
    }

    /**
     * Метод удаляет 1 счет пользователя.
     *
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.usersCollection.get(this.usersCollection.keySet().stream().filter(
                user -> user.getPassport().contains(passport)
        ).collect(Collectors.toList()).get(0)).remove(account);
    }

    /**
     * Метод возвращает сиспок счетов для конкретного пользователя.
     *
     * @param passport
     * @return - список счетов пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        return this.usersCollection.get(this.usersCollection.keySet().stream().filter(
                user -> user.getPassport().contains(passport)
        ).collect(Collectors.toList()).get(0));
    }

    /**
     * Метод перечесления денег с одного счета на другой счет.
     *
     * @param srcPassport
     * @param srcRequisites
     * @param dstPassport
     * @param dstRequisites
     * @param amount
     * @return - результат в зависимости от того найден ли счет
     * или достаточно ли средств на счете.
     */
    public boolean transferMoney(String srcPassport, String srcRequisites,
                                 String dstPassport, String dstRequisites,
                                 double amount) {
        Account srcAccount = findAccount(srcPassport, srcRequisites);
        return srcAccount.transfer(findAccount(dstPassport, dstRequisites), amount);
    }

    /**
     * Находит искомый счет пользователя.
     *
     * @param passport
     * @param requisites
     * @return
     */
    private Account findAccount(String passport, String requisites) {
        return this.usersCollection.get(this.usersCollection.keySet().stream().filter(
                user -> user.getPassport().contains(passport)
        ).collect(Collectors.toList()).get(0)).stream().filter(
                account -> account.getRequisites().contains(requisites)
        ).collect(Collectors.toList()).get(0);
    }

    public static void main(String[] args) {
        BankController bankController = new BankController();

        bankController.addUser(new User("Ivan", "42006286"));
        bankController.addUser(new User("Petr", "11111111"));
        bankController.addUser(new User("Serg", "22222222"));

        bankController.addAccountToUser("42006286", new Account(100.00, "111"));
        bankController.addAccountToUser("11111111", new Account(110.00, "222"));
        bankController.addAccountToUser("22222222", new Account(120.00, "333"));
        bankController.addAccountToUser("42006286", new Account(200.00, "444"));

        for (User user : bankController.getUsersCollection().keySet()) {
            System.out.println(String.format("%s : %s", user, bankController.getUserAccounts(user.getPassport())));
        }

        bankController.deleteAccountFromUser("42006286", new Account(200.00, "444"));

        bankController.transferMoney("22222222", "333", "42006286", "111", 40);

        System.out.println();
        for (User user : bankController.getUsersCollection().keySet()) {
            System.out.println(String.format("%s : %s", user, bankController.getUserAccounts(user.getPassport())));
        }
    }

}
