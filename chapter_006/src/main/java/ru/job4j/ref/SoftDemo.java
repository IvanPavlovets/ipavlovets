package ru.job4j.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftDemo {
    public static void main(String[] args) {
        //example1();
        example2();
    }

    /**
     * strong - strong-ссылка;
     * soft.get()) - вернет strong ссылку
     * soft - soft-ссылка (формально это strong-ссылка на soft-ссылку);
     */
    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
        System.out.println(strong);
    }

    private static void example2() {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 10_000; i++) {
            objects.add(new SoftReference<Object>(new Object() {
                String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            }));
        }
        System.gc();
        int liveObject = 0;
        for (SoftReference<Object> ref : objects) {
            Object object = ref.get();
            if (object != null) {
                liveObject++;
            }
        }
        System.out.println(liveObject);
    }

    /**
     * Некорректное использованием безопасных ссылок.
     * Нужна strong ссылка. Потомучто после проверки на null, в промежутках
     * выполнения строк кода, может случиться что памяти не хватает
     * и случиться gc, который удалит наши данные Object = null, внутри списка someData.
     */
    private static void unsafe() {
        List<SoftReference<Object>> someData = new ArrayList<>();
        if (someData.get(0).get() != null) {
            System.out.println("do something");
        } else {
            System.out.println("do something");
        }
        System.out.println("do something");
        someData.get(0).get();
    }

    /**
     * Корректная работа с безопасной ссылкой.
     * Strong ссылка создаеться.
     * В интервалах получения сильной ссылки из
     * безопасной, GC не затрет объект.
     */
    private static void safe() {
        List<SoftReference<Object>> someData = new ArrayList<>();
        Object strong = someData.get(0).get();
        if (strong != null) {
            System.out.println("do something");
        } else {
            System.out.println("do something");
        }
        System.out.println("do something");
    }
}
