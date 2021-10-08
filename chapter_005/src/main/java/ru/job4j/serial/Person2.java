package ru.job4j.serial;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person2 {
    private final boolean sex;
    private final int age;
    private final Contact3 contact;
    private final String[] statuses;

    public Person2(boolean sex, int age, Contact3 contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Contact3 getContact() {
        return contact;
    }

    public String[] getStatuses() {
        return statuses;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }

    /**
     * 1) JSONObject из json-строки
     * 2) JSONArray из ArrayList
     * 3) JSONObject напрямую методом put
     * 4) формируем jsonObj1
     * 5) формируем jsonObj3
     * 6) Выведем результат в консоль
     * 7) Преобразуем объект person в json-строку
     * @param args
     */
    public static void main(String[] args) {
        JSONObject jsonContact = new JSONObject("{\"phone\":\"12345678910\"}");
        JSONObject jsonEngine = new JSONObject("{\"name\":\"1zz-fe\",\"number\":55}");

        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);
        JSONArray jsonColors = new JSONArray("[\"white\",\"metalic\"]");


        final Person2 pers2 = new Person2(false, 33,
                new Contact3("89233191980"), "Worker", "Married");

        final CarJson car = new CarJson(true, "toyota",
                new EngineJson("1zz-fe", 88), "black", "white");

        JSONObject jsonObj1 = new JSONObject();
        JSONObject jsonObj2 = new JSONObject(pers2);
        JSONObject jsonObj3 = new JSONObject();
        JSONObject jsonObj4 = new JSONObject(car);

        jsonObj1.put("sex", pers2.isSex());
        jsonObj1.put("age", pers2.getAge());
        jsonObj1.put("contact", jsonContact);
        jsonObj1.put("statuses", jsonStatuses);

        jsonObj3.put("iSallWheelDrive", true);
        jsonObj4.put("iSallWheelDrive", true);
        jsonObj3.put("name", car.getName());
        jsonObj3.put("engine", jsonEngine);
        jsonObj3.put("colors", jsonColors);

        System.out.println("jsonObj1: " + jsonObj1.toString());

        System.out.println("jsonObj2: " + jsonObj2.toString());

        System.out.println("jsonObj3: " + jsonObj3.toString());
        System.out.println("jsonObj4: " + jsonObj4.toString());
    }
}
