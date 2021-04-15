package ru.job4j.serial;

public class Contact1 {
    private final String phone;

    public Contact1(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact1{"
                +
                "phone='" + phone + '\'' + '}';
    }
}
