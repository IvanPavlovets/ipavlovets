package ru.job4j.collectionspro.map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Класс имитируещий работу HashMap.
 * перваначально создаеться Node из 16 значений.
 * table - массив хеш-таблица.
 * size - количество элементов в коллекции.
 * limit - степень загружености table - при случае загрузки умнажаем на 2 и заново перераспределяем элементы.
 *
 * @param <K>
 * @param <V>
 */
public class SimpleMap<K, V> implements Iterable<V> {
    private Node<K, V>[] table;
    private int size = 0;
    private float limit;

    public SimpleMap() {
        this.table = new Node[16];
        limit = table.length * 0.75f;
    }

    public int getLength() {
        return table.length;
    }

    public int getSize() {
        return size;
    }

    /**
     * Метод добавления элементов - центральное место работы всей Хеш таблицы.
     * Когда количество эл. + 1 больше или равно 3/4 кол-ва ячеек в массиве, то
     * перераспределяем ячейки с умножением на 2 длинны table/
     *
     * @param key
     * @param value
     * @return
     */
    public boolean insert(K key, V value) {
        if (size + 1 >= limit) {
            limit *= 2;
            arrayIncrease();
        }
        Node<K, V> newNode = new Node<>(key, value);
        int index = hash(key);
        if (table[index] == null) {
            return simpleAdd(index, newNode);
        }
        List<Node<K, V>> list = table[index].getNodelist();
        for (Node<K, V> node : list) {
            if (keyExistValueRewrite(node, newNode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод увелечения Хеш-таблицы путем swap-а указателей.
     * двумя циклами распределяем значения в новую увеличиную ХешТаблицу,
     * Вншений for - читает oldTable и каждый раз получаем node в котором listNode
     */
    private void arrayIncrease() {
        Node<K, V>[] oldTable = table;
        table = new Node[oldTable.length * 2];
        size = 0;
        for (Node<K, V> node : oldTable) {
            if (node != null) {
                for (Node<K, V> n : node.getNodelist()) {
                    insert(n.key, n.value);
                }
            }
        }
    }

    private boolean simpleAdd(int index, Node<K, V> newNode) {
        table[index] = new Node<>(null, null);
        table[index].getNodelist().add(newNode);
        size++;
        return true;
    }

    /**
     * Метод ситуации с переписыванием значения.
     *
     * @param nodeFromList
     * @param newNode
     * @param value
     * @return
     */
    private boolean keyExistValueRewrite(final Node<K, V> nodeFromList, final Node<K, V> newNode) {
        if (newNode.getKey().equals(nodeFromList.getKey())
                && !newNode.getValue().equals(nodeFromList.getValue())
        ) {
            nodeFromList.setValue(newNode.getValue());
            return true;
        }
        return false;
    }

    public boolean delete(K key) {
        int index = hash(key);
        if (table[index] == null) {
            return false;
        }
        if (table[index].getNodelist().size() == 1
                && key.equals(table[index].getNodelist().get(0).getKey())) {
            table[index] = null;
            size--;
            return true;
        }
        List<Node<K, V>> nodeList = table[index].getNodelist();
        for (Node<K, V> node : nodeList) {
            if (key.equals(node.getKey())) {
                nodeList.remove(node);
                size--;
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        int index = hash(key);
        if (index < table.length) {
            if (table[index] != null) {
                if (table[index].getNodelist().size() == 1
                        && key.equals(table[index].getNodelist().get(0).getKey())) {
                    return table[index].getNodelist().get(0).getValue();
                }

                List<Node<K, V>> list = table[index].getNodelist();
                for (Node<K, V> node : list) {
                    if (key.equals(node.getKey())) {
                        return node.getValue();
                    }
                }
            }
            return null;
        }
        throw new ArrayIndexOutOfBoundsException("Ключ вне диапозона хеш таблицы.");
    }

    /**
     * Хеш функция - алгоритм получения номера для ячейки(Node) в table.
     * Вся математика сдесь - алгоритм распределения случайного числав в перделах table.
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        return hash % table.length;
    }

    /**
     * Итератор для hashMap.
     * counterTable - Счетчик идет по ячейкам table.
     * valuesCounter - счетчик идет по количеству значений, сравнивается с size.
     * subIterator - указатель на итератор nodelist (внутрений list содержит все ключи, значения).
     *
     * @return
     */
    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int counterTable = -1;
            int valuesCounter = 0;
            Iterator<Node<K, V>> subIterator = null;

            @Override
            public boolean hasNext() {
                if (valuesCounter == size) {
                    return false;
                }
                if (subIterator == null || !subIterator.hasNext()) {
                    if (moveToNextCell()) {
                        subIterator = table[counterTable].getNodelist().iterator();
                    } else {
                        return false;
                    }
                }
                return subIterator.hasNext();
            }

            private boolean moveToNextCell() {
                counterTable++;
                while (counterTable < table.length && table[counterTable] == null) {
                    counterTable++;
                }
                return counterTable < table.length && table[counterTable] != null;
            }

            @Override
            public V next() {
                valuesCounter++;
                return subIterator.next().getValue();
            }
        };
    }

    /**
     * Внутрений класс структура - хранит внешние - ключ и значение (заглушки)
     * а также содержит внутрений nodelist в котором содержаться истиные ключи и значения
     *
     * @param <K>
     * @param <V>
     */
    private class Node<K, V> {
        public List<Node<K, V>> nodelist;
        public K key;
        public V value;
        public int hash;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodelist = new LinkedList<Node<K, V>>();
        }

        public List<Node<K, V>> getNodelist() {
            return nodelist;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        /**
         * вычисленый хеш код node делим, по модулю (%), на длинну таблицы.
         *
         * @param node
         * @return - число которое будет ячейкой массива.
         */
        private int hash() {
            return hashCode() % table.length;
        }

        /**
         * Определяет равенство обьектов по определеным критириям.
         * Равенстов  определяеться исходя из полей обьекта.
         * Колизия - ситуация когда hashCode равны и обьекты(поля) разные.
         * Значит не хватило диапозона значений int.
         *
         * @param o входящий обьект.
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true; // смотрим не одинаковы ли ссылки
            }
            if (o instanceof Node) {
                Node<K, V> node = (Node) o; // проверяем поля не равны ли они по хешкоду
                return (Objects.equals(key, node.getKey())
                        &&
                        Objects.equals(value, node.getValue())
                        ||
                        Objects.equals(hash, node.hashCode())); //проверяем хешкоды обьектов
            }
            return false;
        }

        // число 31 для лучшего распределения случайных значений хешкодов.
        @Override
        public int hashCode() {
            hash = 31;
            hash = hash * 17 + key.hashCode();
            hash = hash * 17 + value.hashCode();
            return hash;
        }
    }
}


