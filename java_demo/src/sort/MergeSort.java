package sort;

/**
 * @author dzq
 * @Date 2025/1/5 17:00
 * @Description
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 3, 5, 6, 7, 8, 9, 0};
        mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = 0;
        int j = low, k = mid + 1;  //左边序列和右边序列起始索引
        int[] tmp = new int[high - low + 1];
        while (j <= mid && k <= high) {
            if (arr[j] < arr[k]) {
                tmp[i++] = arr[j++];
            } else {
                tmp[i++] = arr[k++];
            }
        }
        //若左边序列还有剩余，则将其全部拷贝进tmp[]中
        while (j <= mid) {
            tmp[i++] = arr[j++];
        }

        while (k <= high) {
            tmp[i++] = arr[k++];
        }

        for (int t = 0; t < i; t++) {
            arr[low + t] = tmp[t];
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
