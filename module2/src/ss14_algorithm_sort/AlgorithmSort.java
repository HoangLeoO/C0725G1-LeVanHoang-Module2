package ss14_algorithm_sort;

import java.util.Arrays;

public class AlgorithmSort {
    // y tuong chèn phần tử vào mảng đã sắp xếp
    public static int[] insertionSort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                System.out.println("di chuyen " +  arr[i] + " sang" + arr[j+1]);
                j--;
            }
            arr[j + 1] = temp;
            System.out.println("Vong lap " + i + Arrays.toString(arr));
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    System.out.println(arr[j] + " swap " + arr[j - 1]);
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!swapped) break;
        }

        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < size; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 3, 1};
        System.out.println(Arrays.toString(selectionSort(arr)));
        ;
    }

}
