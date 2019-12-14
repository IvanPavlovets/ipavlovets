package ru.job4j.collectionsPro.list;

public class SimpleStack<T> {
    private SimpleArrayList<T> store;

    public SimpleStack() {
        this.store = new SimpleArrayList<>();
    }

    /**
     * Метод возвращает значение и удаляет его из коллекции.
     * @param <T>
     */
    public T poll() {
        return store.delete();
    }

    /**
     * метод помещает значение в коллекцию.
     * @param value
     */
    public void push(T value) {
        store.add(value);
    }

    public int getSize() {
        return this.store.getSize();
    }

    @Override
    public String toString() {
        return "SimpleStack{" +
                "store=" + store +
                '}';
    }

    public static void main(String[] args) {
        SimpleStack<Integer> stack = new SimpleStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack);
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
    }
}
