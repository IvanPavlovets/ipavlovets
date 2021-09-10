package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Реализация кеша в виде класса который считывает текстовые файлы из системы.
 */
public class DirFileCache extends AbstractCache<String, String> {

    /**
     * Кешируемая директория.
     */
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    /**
     * Реализация метода конкретной фабрики, переопределяет фабричный метод и
     * возвращают из него собственные продукты, в данном случае - загружает
     * содержимое файла, строку, в кеш.
     * @param key - относительный путь к файлу в директории.
     * @return
     */
    @Override
    protected String load(String key) {
        String result = null;
        try {
            result = Files.readString(Paths.get(cachingDir, key));
            this.put(key, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
