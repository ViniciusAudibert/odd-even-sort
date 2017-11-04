package br.com.oddevensort;

public final class OddEvenSort {
    private OddEvenSort() {
    }

    /**
     * @param array
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        if (array != null) {
            boolean sorted = false;
            while (!sorted) {
                sorted = innerSort(array, 1);
                sorted = innerSort(array, 0) && sorted;
            }
        }
    }

    /**
     * @param array
     * @param i
     * @return
     */
    private static <T extends Comparable<T>> boolean innerSort(T[] array, Integer i) {
        boolean sorted = true;

        for (; i < array.length - 1; i += 2) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                swap(array, i, i + 1);
                sorted = false;
            }
        }

        return sorted;
    }

    /**
     * Método responsável por realizar a troca entre os arrays
     *
     * @param array
     * @param a
     * @param b
     */
    private static <T extends Comparable<T>> void swap(T[] array, int a, int b) {
        T temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
