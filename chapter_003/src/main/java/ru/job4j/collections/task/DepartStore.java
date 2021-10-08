package ru.job4j.collections.task;

import java.util.*;

public class DepartStore {

    /**
     * Очень длинный метод нахождения недостоящих кодов верхнеуровневых
     * подрозделений в codeDepartArr.
     * Состоит из таких операций:
     * - расчленение элементов строк codeDepartArr
     * массив splitList, необходим для поиска максимально длинных строк;
     * <p>
     * - нахождение числа max, длинна самой длинной строчки кодов,
     * max использюеться в последующих циклах;
     * <p>
     * - создание maxList максимально длинных строк;
     * <p>
     * - копируем коды верхнеуровневых подразделений из maxList путем
     * разворачивания массивов и складываем в множество set (что бы исключить дубликаты),
     * также в set складываем строки из arr;
     *
     * @param arr
     * @return
     */
    public String[] departCheck(String[] arr) {
        Set<String> departSet = new TreeSet<>();
        for (String str : arr) {
            String[] line = str.split("/");
            departSet.add(line[0]);
            for (int i = 1; i < line.length; i++) {
                departSet.add(line[0] + "/" + line[1]);
            }
        }
        for (String s : arr) {
            departSet.add(s);
        }
        String[] result = new String[departSet.size()];
        int i = 0;
        for (String s : departSet) {
            result[i] = s;
            i++;
        }
        return result;
    }

    String[] sortByIncrease(String[] arr) {
        String[] arr1 = departCheck(arr);
        Arrays.sort(arr1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return arr1;
    }

    String[] sortByDecrease(String[] arr) {
        String[] arr1 = departCheck(arr);
        Arrays.sort(arr1, new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                int i = 0;
                while (i < Math.min(left.length(), right.length())) {
                    int eq = Character.compare(left.charAt(i), right.charAt(i));
                    if (eq != 0) {
                        return right.charAt(i) - left.charAt(i);
                    }
                    i++;
                }
                return left.length() - right.length();
            }
        });
        return arr1;
    }

    public static final class Org implements Comparable<Org> {
        private final List<String> deps;

        public Org(List<String> deps) {
            this.deps = deps;
        }

        @Override
        public int compareTo(Org o) {
            for (int i = 0; i < Math.min(this.deps.size(), o.deps.size()); i++) {
                int c = this.deps.get(i).compareTo(o.deps.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(this.deps.size(), o.deps.size());
        }

        @Override
        public String toString() {
            return deps.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Org org = (Org) o;
            return Objects.equals(deps, org.deps);
        }

        @Override
        public int hashCode() {

            return Objects.hash(deps);
        }
    }

    public List<Org> convert(List<String> deps) {
        List<String[]> splitList = new ArrayList<>();
        for (String str : deps) {
            splitList.add(str.split("/"));
        }
        int max = splitList.get(0).length;
        for (int i = 1; i < splitList.size(); i++) {
            if (splitList.get(i).length > max) {
                max = splitList.get(i).length;
            }
        }
        List<String[]> maxList = new ArrayList<>();
        for (String[] strArr : splitList) {
            if (strArr.length == max) {
                maxList.add(strArr);
            }
        }

        Set<Org> set1 = new HashSet<>();
        for (String[] str3 : splitList) {
            List<String> arrList2 = new ArrayList<>();
            for (String s : str3) {
                arrList2.add(s);
            }
            set1.add(new Org(arrList2));
        }

        for (int i = 1; i < max; i++) {
            for (int j = 0; j < maxList.size(); j++) {
                String[] rstArr = new String[i];
                System.arraycopy(maxList.get(j), 0, rstArr, 0, i);
                List<String> arrList = new ArrayList<>();
                for (int k = 0; k < rstArr.length; k++) {
                    arrList.add(rstArr[k]);
                }
                set1.add(new Org(arrList));
            }
        }
        List<Org> result = sortAsc(new ArrayList<>(set1));
        return result;
    }

    /**
     * Метод сортировки по возростанию.
     * @param arr - входящмий массив кодов
     * @return
     */
    public List<Org> sortAsc(List<Org> orgs) {
        List<Org> result = orgs;
        Collections.sort(result);
        return result;
    }

    /**
     * Метод сортировки по убыванию.
     * @param arr - входящмий массив кодов
     * @return
     */
    public List<Org> sortDesc(List<Org> orgs) {
        List<Org> result = orgs;
        Collections.sort(result, new Comparator<Org>() {
            @Override
            public int compare(Org o1, Org o2) {
                return o2.deps.toString().compareTo(o1.deps.toString());
            }
        });
        return result;
    }

    public static void main(String[] args) {
        DepartStore departStore = new DepartStore();
        List<String> input = Arrays.asList("K1/SK1", "K1/SK2", "K1/SK1/SSK1",
                "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2");


        String[] codeDepartArr = new String[]{"K1/SK1", "K1/SK2", "K1/SK1/SSK1",
                "K1/SK1/SSK2", "K2", "K2/SK1/SSK1", "K2/SK1/SSK2"};

        System.out.println(" было: " + Arrays.toString(codeDepartArr));
        System.out.println("стало: " +  Arrays.toString(departStore.departCheck(codeDepartArr)));
        System.out.println(" возр: " + Arrays.toString(departStore.sortByIncrease(codeDepartArr)));
        System.out.println(" убыв: " + Arrays.toString(departStore.sortByDecrease(codeDepartArr)));
    }
}
