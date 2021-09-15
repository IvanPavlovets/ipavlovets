package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Абстрактный класс кеша для различных реализаций.
 * Базовый класс фабрики.
 * @param <K>
 * @param <V>
 */
public abstract class AbstractCache<K, V> {
    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    /**
     * добавить обьект в кеш.
     * @param key   относительный путь к файлу в директории.
     * @param value
     */
    public void put(K key, V value) {
        cache.put(key, new SoftReference<>(value)); // помещаем в кеш по ключу
    }

    /**
     * получения обьекта из кеша.
     * если содержимого нет в кеше то загрузить
     * obj из системы.
     * @param key относительный путь к файлу в директории.
     * @return
     */
    public V get(K key) {
        V obj;
        if (cache.get(key) != null) {
            obj = cache.get(key).get();
            if (obj == null) {
                obj = load(key);
                this.put(key, obj);
            }
        } else {
            obj = load(key);
            this.put(key, obj);
        }
        return obj;
    }

    /**
     * абстрактный метод загрузки в кеш.
     * @param key относительный путь к файлу в директории.
     * @return
     */
    protected abstract V load(K key);

}
