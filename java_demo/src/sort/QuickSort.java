package sort;

/**
 * @author dzq
 * @Date 2025/1/5 16:52
 * @Description
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 5, 6, 7, 8, 9, 0};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left - 1, j = right + 1;
        int pivot = arr[left];
        while (i < j) {
            do i++; while (arr[i] < pivot);
            do j--; while (arr[j] > pivot);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, j + 1, right);
    }
}
