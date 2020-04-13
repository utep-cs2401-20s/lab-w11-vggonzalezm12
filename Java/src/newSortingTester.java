import org.junit.Test;


import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class newSortingTester
{

        @Test
        public void newSortingTest() // Test will simply test if the method works with positive numbers.
        // The expected value is a sorted array with no expected problems

        {
            int [] array = new int [] {5,8,1,3,12,2,4,9,6,7};
            int[] expected = new int[] {1,2,3,4,5,6,7,8,9,12}; // expected result
            newSorting test1 = new newSorting();
            test1.newSorting(array, 4);
            assertArrayEquals(expected, array);

        }

    @Test
    public void newSortingTest2() // Test if the method works with negative numbers
    // The expected value is a sorted array with no problems
                                    //
    {
        int [] array = new int [] {-5,-8,-1,-3,-12,-2,-4,-9,-6,-7};
        int[] expected = new int[] {-1,-2,-3,-4,-5,-6,-7,-8,-9,-12}; // expected result
        newSorting test1 = new newSorting();
        test1.newSorting(array, 4);
        assertArrayEquals(expected, array);


    }

    @Test
    public void newSortingTest3() // Test if the method works with negative numbers mixed with positive mumbers.
    // The expected value is a sorted array with any problem.
    {
        int [] array = new int [] {-5,8,-1,3,-12,2,-4,9,-6,-7};
        int[] expected = new int[] {-1,-4,-5,-6,-7,-12, 2, 3,8, 9}; // expected result
        newSorting test1 = new newSorting();
        test1.newSorting(array, 4);
        assertArrayEquals(expected, array);


    }

    @Test
    public void newSortingTest4() // Test if the method works with an array that has uneven number of elements and with size of number 1.
            // the array will be divided 9 times
    // The expected value is a sorted array with facing no problems.

    {
        int [] array = new int [] {5,8,1,3,2,4,9,6,7};
        int[] expected = new int[] {1,2,3,4,5,6,7,8,9}; // expected result
        newSorting test1 = new newSorting();
        test1.newSorting(array, 1);
        assertArrayEquals(expected, array);


    }
    @Test
    public void newSortingTest5() // Test if the method works with the same value en every index and with a single pass directly to quick sort
    // the expected value would be the same array since it has nothing to sort without problems
    {
        int [] array = new int [] {0,0,0,0,0,0,0,0};
        int[] expected = new int[] {0,0,0,0,0,0,0,0}; // expected result
        newSorting test1 = new newSorting();
        test1.newSorting(array, 8);
        assertArrayEquals(expected, array);


    }
}
