package ru.job4j.cache;

/**
 * класс для работы с пользователем
 */
public class Emulator {
    private DirFileCache dirFileCache;

    public Emulator(String dir) {
        dirFileCache = new DirFileCache(dir);
    }

    /**
     * получить содержимое файла (строку) из кэша,
     * если содержимого нет в кеше то кеш, сам загрузить
     * файл из системы с помощью load().
     * @param key
     * @return
     */
    public String getFileContent(String key) {
        return dirFileCache.get(key);
    }
}

