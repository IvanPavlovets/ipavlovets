package ru.job4j.collections.transfers;

import java.util.*;

public class BankController {

    /**
     * Коллекция хранилище пользовательских счетов.
     */
    public static Map<User, List<Account>> usersCollection;

    public BankController() {
        usersCollection = new TreeMap<>();
    }

    /**
     * Метод добавления пользователя.
     * @param user
     */
    public void addUser(User user) {
        this.usersCollection.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод удаления пользователя.
     * @param user
     */
    public void deleteUser(User user) {
        this.usersCollection.remove(user);
    }

    /**
     * Метод добавления 1 счета пользователю.
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        for (User user : this.usersCollection.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.usersCollection.get(user).add(account);
            }
        }
    }

    /**
     * Метод удаляет 1 счет пользователя.
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User user : this.usersCollection.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.usersCollection.get(user).remove(account);
            }
        }
    }

    /**
     * Метод возвращает сиспок счетов для конкретного пользователя.
     * @param passport
     * @return - список счетов пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> accountList = new ArrayList<>();
        for (User user : usersCollection.keySet()) {
            if (user.getPassport().equals(passport)) {
                accountList.addAll(this.usersCollection.get(user));
            }
        }
        return accountList;
    }

    /**
     * Метод перечесления денег с одного счета на другой счет.
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
     * @param passport
     * @param requisites
     * @return
     */
    private Account findAccount(String passport, String requisites) {
        Account actualAccount = new Account();
        for (User user : this.usersCollection.keySet()) {
            if (user.getPassport().equals(passport)) {
                for (Account account : this.usersCollection.get(user)) {
                    if (account.getRequisites().equals(requisites)) {
                        actualAccount = account;
                    }
                }
            }
        }
        return actualAccount;
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

        for (User user : usersCollection.keySet()) {
            System.out.println(String.format("%s : %s", user, bankController.getUserAccounts(user.getPassport())));
        }

        bankController.deleteAccountFromUser("42006286", new Account(200.00, "444"));

        bankController.transferMoney("22222222", "333", "42006286", "111", 40);

        System.out.println();
        for (User user : usersCollection.keySet()) {
            System.out.println(String.format("%s : %s", user, bankController.getUserAccounts(user.getPassport())));
        }
    }

}
