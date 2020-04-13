public class newSorting
{

    public static void newSorting (int[] arr, int size)
    {
        newSortingHelper(arr, 0, arr.length - 1, size);
    }

    private static void newSortingHelper (int[] arr, int first, int last, int size)
    {

        if (last - first  <= size && last - first > 1)   //Base case quick sort
        {
            quickSort(arr, 0, arr.length - 1);
            return;
        }
        if(last - first== 0) // one element on the array
            return;

        newSortingHelper(arr, first, (first +last)/2, size); //sort right half
        newSortingHelper(arr, (first + last)/2 + 1, last, size); // sort left half
        mergeSortedHalves(arr, first, (first+ last)/2, (first+ last)/2 + 1, last); // merge 2 halves
    }

    private static void quickSort (int[] arr, int first, int last)
    {
        if (last - first == 1) // base case
        {
            if(arr[last] < arr[first])
            {
                int temp = arr[first];
                arr[first] = arr[last];
                arr[last] = temp;
            }
        }
        if (last - first < 2)
            return;


        int pivot = arr[first];


        int less = first + 1; // less is the current index that must have a value lower than the pivot
        int more = last; // more is current index on the other side of the array that its value must be greater than the pivot

        while(less < more) // while less values are in the left  side of the array and more values on the right
        {
            while(less <= more && arr[less] <= pivot) // advance through the array until less is greater than pivot
                less++;
            while(less <=  more && arr[more] > pivot)// advance through the array until more is lower than pivot
                more--;

            if(arr[less] > arr[more]) //Switch less and more to keep advancing through the array if the value of less is grater than the value of moore
            {
                int temp = arr[less];
                arr[less] = arr[more];
                arr[more] = temp;
            }
        }

        arr[first] = arr[more];
        arr[more] = pivot;

        quickSort(arr, first, more); // recursion for the first part
        quickSort(arr, less, last); // recursion ofr the second part
    }

    private static void mergeSortedHalves (int[] arr, int first1, int last1, int first2, int last2) //  first and last indexes of the 2 arrays
    {

        int[] newArr = new int [last2 - first1 + 1]; // sorting in this array

        int index1 = first1; // iterator 1  for comparison
        int index2 = first2; // iterator 2 for comparison
        for (int i = 0; i < newArr.length; i++)
        {
            if (index2 > last2 && index1 <= last1) // sort left half
            {
                newArr[i] = arr[index1];
                index1++;
            }
            if (index1 > last1 && index2 <=first2) // sort right half
            {
                newArr[i] = arr[index2];
                index2++;
            }

           if (index1 <= last1 && index2 <= last2) // sort in the new array
            {
                if (arr[index1] < arr[index2])
                {
                    newArr[i] = arr[index1];
                    index1++;
                }
                else
                {
                    newArr[i] = arr[index2];
                    index2++;
                }
            }
        }

        for (int i = first1; i <= last2; i++) // pass arranged values from the new array
        {
            arr[i] = newArr[i - first1];
        }
    }
}
