package br.com.oddevensort;

public final class OddEvenSort {
	private static Long swapCounter;

	public static Long getSwapCounter() {
		return swapCounter;
	}

	/**
	 * Ordena o array passado por parametro em ordem crescente
	 *
	 * @param array será modificado e ordenado
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {
		swapCounter = Long.valueOf(0);
		if (array != null) {
			boolean sorted = false;
			while (!sorted) {
				sorted = innerSort(array, 1);
				sorted = innerSort(array, 0) && sorted;
			}
		}
	}

	/**
	 * Percorre todo array de dois em dois a partir do index passado por parametro e compara os elementos
	 * quando o elemento seguinte é menor realiza a troca
	 *
	 * @param array compara os elementos e realiza a troca se o elemento seguite for maior
	 * @param index indica o index de onde a iteração deve iniciar
	 *
	 * @return true se nessa iteração não houve nenhuma troca ou false se algum número trocou de posição
	 */
	private static <T extends Comparable<T>> boolean innerSort(T[] array, Integer index) {
		boolean sorted = true;

		for (; index < array.length - 1; index += 2) {
			if (array[index].compareTo(array[index + 1]) > 0) {
				swap(array, index, index + 1);
				sorted = false;
			}
		}

		return sorted;
	}

	/**
	 * Realiza a troca de dois elementos dentro do array
	 *
	 * @param array       é modificado onde o duas posições serão alternadas
	 * @param firstIndex  posição 1 que será alternada
	 * @param secondIndex posição 2 que será alternada
	 */
	private static <T extends Comparable<T>> void swap(T[] array, int firstIndex, int secondIndex) {
		T temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
		swapCounter++;
	}
}
