package ss14_algorithm_sort.bai_tap.bai_tap2;

import ss14_algorithm_sort.AlgorithmSort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1,5,6};
        System.out.println(Arrays.toString(AlgorithmSort.insertionSort(arr)));
    }
}
