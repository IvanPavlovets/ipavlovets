package ru.job4j.collections.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Метод добавления обьектов person в коллекцию persons.
     * @param person - обьект добавления.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, которые содержат key в любых полях.
     * @param key - ключ поиска.
     * @return список подошедших пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (person.getName().toLowerCase().contains(key.toLowerCase())
                    || person.getSurname().toLowerCase().contains(key.toLowerCase())
                    || person.getPhone().toLowerCase().contains(key.toLowerCase())
                    || person.getAddress().toLowerCase().contains(key.toLowerCase())) {
                result.add(person);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        var phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        phoneDictionary.add(new Person("Ivan", "Pavlovets", "111", "Bryansk"));
        phoneDictionary.add(new Person("Dmitriy", "Pavlovets", "111", "Krasnoyark"));


        System.out.println(phoneDictionary.find("PETR"));
    }
}

