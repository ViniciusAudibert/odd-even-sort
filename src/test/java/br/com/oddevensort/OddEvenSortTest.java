package br.com.oddevensort;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OddEvenSortTest {

	private final int arraySize = 10000;

	@Test
	public void sortArrayNull() {
		// ARRANGE
		Integer[] nullArray = null;

		// ACT
		OddEvenSort.sort(nullArray);

		// ASSERT
		assertNull(nullArray);
	}

	@Test
	public void sortEmptyArray() {
		// ARRANGE
		Integer[] emptyArray = new Integer[0];

		// ACT
		OddEvenSort.sort(emptyArray);

		// ASSERT
		assertEquals(OddEvenSort.getSwapCounter(), Long.valueOf(0));
		assertEquals(emptyArray.length, 0);
	}

	@Test
	public void sortSortedArray() {
		// ARRANGE
		Integer[] sortedArray = this.generateSortedArray(arraySize);
		long startTime = System.nanoTime();

		// ACT
		OddEvenSort.sort(sortedArray);
		long endTime = System.nanoTime();
		printInfo("Sorted Array (Best case)", endTime - startTime);

		// ASSERT
		assertEquals(OddEvenSort.getSwapCounter(), Long.valueOf(0));
		assertTrue(isArraySorted(sortedArray));
	}

	@Test
	public void sortReverseSortedArray() {
		// ARRANGE
		Integer[] reverseSortedArray = this.generateReverseSortedArray(arraySize);
		long startTime = System.nanoTime();

		// ACT
		OddEvenSort.sort(reverseSortedArray);
		long endTime = System.nanoTime();
		printInfo("Reverse Sorted Array (Worst case)", endTime - startTime);

		// ASSERT
		assertTrue(isArraySorted(reverseSortedArray));
	}

	@Test
	public void sortRandomArray() {
		// ARRANGE
		Integer[] ramdomArray = this.generateRandomArray(arraySize);
		long startTime = System.nanoTime();

		// ACT
		OddEvenSort.sort(ramdomArray);
		long endTime = System.nanoTime();
		printInfo("Random Array", endTime - startTime);

		// ASSERT
		assertTrue(isArraySorted(ramdomArray));
	}

	// Aux functions
	private void printInfo(String title, long totalTime) {
		System.out.println(title);
		System.out.print("Número de trocas = ");
		System.out.println(OddEvenSort.getSwapCounter());
		System.out.print("Número de comparações = ");
		System.out.println(OddEvenSort.getComparatorCounter());
		System.out.print("Total time = ");
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.println(formatter.format(totalTime / 1000000000d) + " seconds");
		System.out.println();

	}

	private boolean isArraySorted(Integer[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}

		return true;
	}

	private Integer[] generateSortedArray(int size) {
		Integer[] array = new Integer[size];

		for (int i = 0; i < size; i++) {
			array[i] = i;
		}

		return array;
	}

	private Integer[] generateReverseSortedArray(int size) {
		Integer[] array = new Integer[size];
		int value = size;

		for (int i = 0; i < size; i++) {
			array[i] = value;
			value--;
		}

		return array;
	}

	private Integer[] generateRandomArray(int size) {
		Integer[] array = new Integer[size];

		for (int i = 0; i < size; i++) {
			array[i] = ThreadLocalRandom.current().nextInt(0, size + 1);
		}

		return array;
	}
}
