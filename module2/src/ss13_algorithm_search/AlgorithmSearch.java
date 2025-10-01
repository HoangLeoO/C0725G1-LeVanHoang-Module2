package ss13_algorithm_search;

public class AlgorithmSearch {
    public static int linearSearch(int[] arr, int element) {
        for (int i = 0; i < arr.length; i++) {
            if (element == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int element) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // vị trí giữa

            if (arr[mid] == element) {
                return mid; // tìm thấy
            } else if (arr[mid] < element) {
                left = mid + 1; // bỏ nửa trái
            } else {
                right = mid - 1; // bỏ nửa phải
            }
        }
        return -1; // không tìm thấy
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(arr, 10));
    }
}
