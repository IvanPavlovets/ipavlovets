package ru.job4j.cache;

/**
 * класс для работы с пользователем
 */
public class Emulator {
    private DirFileCache dirFileCache;

    public Emulator(String dir) {
        dirFileCache = new DirFileCache(dir);
    }

    public static void main(String[] args) {
        Emulator emulator = new Emulator("C:\\ipavlovets\\ipavlovets");
        String str = emulator.getFileContent("Names.txt");
        System.out.println(str);
        str = null;
        String str1 = emulator.getFileContent("Names.txt");
        System.out.println(str);
        System.out.println(str1);
    }

    /**
     * получить содержимое файла из кэша,
     * если содержимого нет в кеше то загрузить
     * файл из системы.
     * @param key
     * @return
     */
    public String getFileContent(String key) {
        String fileContent;
        if (dirFileCache.cache.containsKey(key)) { // если есть в кеше
            fileContent = dirFileCache.get(key);
        } else {
            fileContent = dirFileCache.load(key);
        }
        return fileContent;
    }
}

