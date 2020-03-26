package ru.job4j.collectionsPro.tree;

import java.util.LinkedList;
import java.util.List;
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
        Node<E> adddNode = new Node<>(child);
        Optional<Node<E>> parentNode = findBy(parent);
        Optional<Node<E>> childNode = findBy(child);
        if (!(parentNode.get().value.equals(parent) &&
                parentNode.get().children.contains(adddNode)
        )) {
            parentNode.get().children.add(adddNode);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод проверки дерева на бинарность, не путать с бинарным деревом поиска!
     * @return
     */
    @Override
    public boolean isBinary() {
        boolean rsl = false;
        List<Node<E>> childrenList = root.children;
        return loop(childrenList, rsl);
    }

    private boolean loop(List<Node<E>> childrenList, boolean rsl) {
        if (childrenList.size() <= 2) {
            for (Node<E> node : childrenList) {
                if (!(node.children.size() <= 2)) {
                    rsl = false;
                    break;
                }
                rsl = true;
                rsl = loop(node.children, rsl);
            }
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
}
