package br.com.oddevensort;

import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class OddEvenSortTest {
	
    @Test
    public void sortArrayNull() {
        // ARRANGE
    	Integer[] nullArray = null;
    	
        // ACT
    	OddEvenSort.sort(nullArray);

        // ASSERT
    	assertTrue(nullArray == null);
    }

    @Test
    public void sortEmptyArray() {
        // ARRANGE
    	Integer[] emptyArray = new Integer[0];
    	
        // ACT
    	OddEvenSort.sort(emptyArray);
    	
        // ASSERT
    	assertTrue(OddEvenSort.getSwapCounter() == 0);
        assertTrue(emptyArray.length == 0);
    }
    
    @Test
    public void sortSortedArray() {
        // ARRANGE
    	Integer[] sortedArray = this.generateSortedArray(100);
    	long startTime = System.nanoTime();
    	
        // ACT
    	OddEvenSort.sort(sortedArray);
    	long endTime = System.nanoTime();
    	printInfo("Sorted Array (Best case)", endTime-startTime);
    	
        // ASSERT
    	assertTrue(OddEvenSort.getSwapCounter() == 0);
    }
    
    @Test
    public void sortReverseSortedArray() {
        // ARRANGE
    	Integer[] reverseSortedArray = this.generateReverseSortedArray(100);
    	long startTime = System.nanoTime();
    	
        // ACT
    	OddEvenSort.sort(reverseSortedArray);
    	long endTime = System.nanoTime();
    	printInfo("Reverse Sorted Array (Worst case)", endTime-startTime);
    	
        // ASSERT
    	assertTrue(OddEvenSort.getSwapCounter() == 4950);
    }
    
    @Test
    public void sortRandomArray() {
        // ARRANGE
    	Integer[] ramdomArray = this.generateRandomArray(100);
    	long startTime = System.nanoTime();
    	
        // ACT
    	OddEvenSort.sort(ramdomArray);
    	long endTime = System.nanoTime();
    	printInfo("Random Array", endTime-startTime);
    	
        // ASSERT
    }
    
    // Aux functions
    public void printInfo(String title, long totalTime) {
    	System.out.println(title);
    	System.out.print("Swaps = ");
    	System.out.println(OddEvenSort.getSwapCounter());
    	System.out.print("Total time = ");
    	NumberFormat formatter = new DecimalFormat("#0.00000");
    	System.out.println(formatter.format(totalTime / 1000000000d) + " seconds");

    }
    
    public Integer[] generateSortedArray(int size) {
    	Integer[] array = new Integer[size];
    	
    	for(int i=0; i < size; i++) {
    		array[i] = i;
    	}
    	
    	return array;
    }
    
    public Integer[] generateReverseSortedArray(int size) {
    	Integer[] array = new Integer[size];
    	int value = size;
    	
    	for(int i=0; i < size; i++) {
    		array[i] = value;
    		value--;
    	}
    	
    	return array;
    }
    
    public Integer[] generateRandomArray(int size) {
    	Integer[] array = new Integer[size];
    	
    	for(int i=0; i < size; i++) {
    		array[i] = ThreadLocalRandom.current().nextInt(0, size + 1);
    	}
    	
    	return array;
    }
}
