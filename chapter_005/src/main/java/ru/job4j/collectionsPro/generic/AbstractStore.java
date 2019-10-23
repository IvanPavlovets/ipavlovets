package ru.job4j.collectionsPro.generic;

public abstract class AbstractStore<T> implements Store {

    protected SimpleArray<? super T> storeData;

    protected AbstractStore(int size) {
        this.storeData = new SimpleArray(size);
    }

    public SimpleArray<? super T> getStoreData() {
        return storeData;
    }

    @Override
    public void add(Base model) {
        storeData.add((T) model);
    }

    /**
     * Метод замены элемента хранилища.
     * Заменяет обьект в ханилище storeData
     * найденый по id.
     * Вновь вставленым обьектом T,
     *
     * @param id    - аргумент сравниваеться с id элементов ханилища storeData.
     * @param model - новый обьект storeData который замещает найденый id.
     * @return result - результат удаления.
     */
    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        for (int i = 0; i != this.storeData.getPosition(); i++) {
            Base obj = (Base) storeData.get(i);
            if (obj.getId().equals(id)) {
                storeData.set(i, (T) model);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод удаления элемента хранилища.
     * Удаление происходит по индексу совпавшего элемента по id.
     *
     * @param id - аргумент сравниваеться с id элементов коллекции storeData.
     * @return result - результат удаления.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < storeData.getArrayData().length; i++) {
            Base obj = (Base) storeData.get(i);
            if (obj.getId().equals(id)) {
                this.storeData.remove(i);
                result = true;
            }
        }
        return result;
    }

    /**
     * Метод возвращает обьект хранилища по id.
     * Проверяет в цикле все элементы хранилища storeData
     * сравнивая id элемента с аргументом String id.
     *
     * @param id - аргумент сравниваеться с id элементов массива storeData.
     * @return - совпавший по id обьект T.
     */
    @Override
    public Base findById(String id) {
        Base result = null;
        for (int i = 0; i < storeData.getArrayData().length; i++) {
            Base obj = (Base) storeData.get(i);
            if (obj != null && obj.getId().equals(id)) {
                result = (Base) obj;
                break;
            }
        }
        return result;
    }

}

