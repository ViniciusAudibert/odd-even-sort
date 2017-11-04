package br.com.oddevensort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static br.com.oddevensort.OddEvenSort.*;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class OddEvenSortTest {
    @Test
    public void sortArrayNull() {
        // ARRANGE
        // ACT
        // ASSERT
        sort(null);
    }

    @Test
    public void sortEmptyArray() {
        // ARRANGE
        Integer[] array = new Integer[0];

        // ACT
        sort(array);

        // ASSERT
        assertTrue(array.length == 0);
    }

}
