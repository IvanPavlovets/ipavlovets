package ru.job4j.collections.transfers;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static ru.job4j.collections.transfers.BankController.usersCollection;

public class BankControllerTest {

    @Test
    public void whenAddUserThenItWillAdd() {
        BankController bankController = new BankController();
        bankController.addUser(new User("Ivan", "42006286"));

        Set<User> userSet = new TreeSet<>();
        userSet.add(new User("Ivan", "42006286"));

        MatcherAssert.assertThat(usersCollection.keySet(), is(userSet));
    }

    @Test
    public void whenAddAccountToUserThenItWillAdd() {
        BankController bankController = new BankController();
        bankController.addUser(new User("Ivan", "42006286"));
        bankController.addAccountToUser("42006286", new Account(100.00, "111"));

        List<Account> accountList2 = new ArrayList<>();
        Account account = new Account(100.00, "111");
        accountList2.add(account);

        MatcherAssert.assertThat(usersCollection.get(new User("Ivan", "42006286")), is(accountList2));
    }

    @Test
    public void whenDeleteUserAccountThenItWillDelete() {
        BankController bankController = new BankController();
        bankController.addUser(new User("Ivan", "42006286"));

        bankController.addAccountToUser("42006286", new Account(100.00, "111"));
        bankController.addAccountToUser("42006286", new Account(200.00, "444"));

        bankController.deleteAccountFromUser("42006286", new Account(200.00, "444"));

        List<Account> accountList2 = new ArrayList<>();
        Account account = new Account(100.00, "111");
        accountList2.add(account);

        MatcherAssert.assertThat(usersCollection.get(new User("Ivan", "42006286")), is(accountList2));
    }

    /**
     * В тесте проверяеться метод transferMoney.
     * После перевода средств на обоих счетах одинаковые суммы.
     */
    @Test
    public void whenTransferMoneyThenItWillBeDone() {
        BankController bankController = new BankController();
        bankController.addUser(new User("Ivan", "42006286"));
        bankController.addUser(new User("Serg", "22222222"));
        bankController.addAccountToUser("42006286", new Account(50.00, "111"));
        bankController.addAccountToUser("22222222", new Account(150.00, "333"));

        bankController.transferMoney("22222222", "333", "42006286", "111", 50);

        double valueIvan = usersCollection.get(new User("Ivan", "42006286")).get(0).getValues();
        double valueSerg = usersCollection.get(new User("Serg", "22222222")).get(0).getValues();

        MatcherAssert.assertThat(valueIvan, is(valueSerg));
    }

}
