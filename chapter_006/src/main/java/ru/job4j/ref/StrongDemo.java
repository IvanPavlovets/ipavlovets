package ru.job4j.ref;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StrongDemo {
    public static void main(String[] args) throws InterruptedException {
        //example1();
        //example2();
        example3();
    }

    private static void example1() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            objects[i] = new Object() {
                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            };
        } // зануление ссылки
        for (int i = 0; i < 100; i++) {
            objects[i] = null;
        }
        System.gc(); // очистка
        TimeUnit.SECONDS.sleep(5); // спать через 5
    }

    private static void example2() throws InterruptedException {
        Object[] objects = new Object[100];
        for (int i = 0; i < 100; i++) {
            Object object = new Object() { // буферный обьект, с вложеным обьектом
                Object innerObject = new Object() {
                    @Override
                    protected void finalize() throws Throwable {
                        System.out.println("Remove inner object!"); // удаляем внешний обьект
                    }
                };
            };
            objects[i] = object;
        } // зануление ссылки (удаление, в том числе и внутрених)
        for (int i = 0; i < 100; i++) {
            objects[i] = null;
        }
        System.gc(); // очистка
        TimeUnit.SECONDS.sleep(5); // спать через 5
    }

    private static void example3() {
        List<String> strings = new ArrayList<>();
        while (true) {
            strings.add(String.valueOf(System.currentTimeMillis()));
        }
    }

}
