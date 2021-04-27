package ru.job4j.serial;

public class Contact3 {
    private final String phone;

    public Contact3(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "phone='" + phone + '\''
                + '}';
    }
}
