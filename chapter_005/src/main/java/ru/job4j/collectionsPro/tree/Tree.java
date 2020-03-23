package ru.job4j.collectionsPro.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E> implements SimpleTree<E> {
    public final Node<E> root;

    Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root + "rootList=" + root.children +
                '}';
    }

    /**
     * Метод поиска и добавления дочернего узла child в родительский узел parent.
     * Проверка на дубликаты - если parent и child уже есть в Tree то вернуть false
     * - если обратное то добавить parent и child в Tree.
     * @param parent
     * @param child
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Node<E> childNode = new Node<>(child);
        if (!(findBy(parent).get().value.equals(parent) &&
                        findBy(parent).get().children.contains(childNode)
        )) {
            Optional<Node<E>> parentNode = findBy(parent);
            parentNode.get().children.add(childNode);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Алгоритм обхода в ширину.
     * @param value
     * @return
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1,2);
        tree.add(1,3);
        tree.add(1,4);
        System.out.println(tree.add(4,5));
        System.out.println(tree.root);
        System.out.println(tree.add(5,6));
        System.out.println(tree.add(5,6));
        System.out.println(tree.add(5,6));
        System.out.println(tree.findBy(6).get());
        System.out.println(tree.findBy(5).get().children);
        System.out.println(tree.findBy(5));
//        System.out.println(tree.root.value);
//        System.out.println(tree.root.children);
        //System.out.println(tree.findBy(7).get());
    }
}
