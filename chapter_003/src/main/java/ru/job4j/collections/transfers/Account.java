package ru.job4j.collections.transfers;

import java.util.Objects;

/**
 * Класс банковского счета клиента.
 */
public class Account implements Comparable<Account> {

    private double values;
    private String requisites;

    public Account(double values, String requisites) {
        this.values = values;
        this.requisites = requisites;
    }

    public double getValues() {
        return this.values;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setValues(double values) {
        this.values = values;
    }

    /**
     * В методе организуеться проверка на null, суммы и счета перечесления.
     * Затем происходит вычитание суммы с текущего счета и добавление на счет перечесления.
     * @param destination
     * @param amount
     * @return
     */
    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Double.compare(account.values, values) == 0
                && Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, requisites);
    }

    @Override
    public String toString() {
        return "Account{"
                +
                "requisites='"
                +
                requisites
                +
                "values="
                +
                values
                +
                '\''
                +
                '}';
    }

    @Override
    public int compareTo(Account o) {
        return this.requisites.compareTo(o.requisites);
    }
}
