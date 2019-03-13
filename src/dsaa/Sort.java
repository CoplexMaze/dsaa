package dsaa;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] nums = {5, 1, 7, 1, 6, 3, 8, 1, 4};

//        System.out.println(Arrays.toString(nums));
//        insertSort(nums);
//        System.out.println("直接插入排序：" + Arrays.toString(nums));

//        System.out.println(Arrays.toString(nums));
//        binaryInsertSort(nums);
//        System.out.println("折半插入排序：" + Arrays.toString(nums));

//        System.out.println(Arrays.toString(nums));
//        shellSort(nums);
//        System.out.println("希尔排序：" + Arrays.toString(nums));

//        System.out.println(Arrays.toString(nums));
//        bubbleSort(nums);
//        System.out.println("冒泡排序：" + Arrays.toString(nums));

//        System.out.println(Arrays.toString(nums));
//        quickSort(nums);
//        System.out.println("快速排序：" + Arrays.toString(nums));

//        System.out.println(Arrays.toString(nums));
//        selectionSort(nums);
//        System.out.println("简单选择排序：" + Arrays.toString(nums));

//        System.out.println(Arrays.toString(nums));
//        heapSort(nums);
//        System.out.println("堆排序：" + Arrays.toString(nums));

        System.out.println(Arrays.toString(nums));
        mergeSort(nums);
        System.out.println("归并排序：" + Arrays.toString(nums));
    }

    /**
     * 直接插入排序
     */
    public static void insertSort(int[] nums) {
        int len = nums.length, temp, j;
        for (int i = 1;i < len;i++) {
            temp = nums[i];
            j = i - 1;
            while (j >= 0 && nums[j] > temp)
            {
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
    }

    /**
     * 折半插入排序
     */
    public static void binaryInsertSort(int[] nums) {
        int len = nums.length;
        int left, mid, right, p;
        for (p = 1;p < len;p++) {
            int temp = nums[p];
            left = 0;
            right = p -1;
            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] > temp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int i = p-1;i >= left;i-- ) {
                nums[i+1] = nums[i];
            }
            nums[left] = temp;
        }
    }

    /**
     * 希尔排序
     */
    public static void shellSort(int[] nums) {
        int len = nums.length;
        int d = len / 2;
        while (d >= 1) {
            for (int k = 0;k < d;k++) {
                for (int i = k+d;i < len;i+=d) {
                    int temp = nums[i];
                    int j = i - d;
                    while (j >= k && nums[j] > temp) {
                        nums[j+d] = nums[j];
                        j -= d;
                    }
                    nums[j+d] = temp;
                }
            }
            d = d / 2;
        }
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] nums) {
       int len = nums.length;
       for (int i = len - 1;i > 0;i--) {
           for (int j = 0;j < i;j++) {
               if (nums[j] > nums[j+1]) {
                   nums[j] += nums[j+1];
                   nums[j+1] = nums[j] - nums[j+1];
                   nums[j] = nums[j] - nums[j+1];
               }
           }
       }
    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }
    public static void quick(int[] nums, int left, int right) {
        if (left < right) {
            int p = partition(nums, left, right);
            quick(nums, left, p-1);
            quick(nums, p+1, right);
        }
    }
    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    /**
     * 简单选择排序
     */
    public static void selectionSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i ++) {
            int k = i - 1;
            for (int j = i; j < len; j++) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            if (k != i-1) {
                int t = nums[k];
                nums[k] = nums[i-1];
                nums[i-1] = t;
            }
        }
    }

    /**
     * 堆排序
     */
    public static void heapSort(int[] nums) {
        int len = nums.length;
        buildHeap(nums, len);
        for (int i = len-1; i > 0; i--) {
            int t = nums[0];
            nums[0] = nums[i];
            nums[i] = t;
            siftDown(nums, 0, i);
         }
    }
    private static void siftDown(int nums[], int i, int n) {
        int l = 2*i + 1, r = 2*i + 2, min = i;
        if (l < n && nums[min] < nums[l]) min = l;
        if (r < n && nums[min] < nums[r]) min = r;
        if (min != i) {
            int t = nums[min];
            nums[min] = nums[i];
            nums[i] = t;
            siftDown(nums, min, n);
        }
    }
    private static void buildHeap(int[] nums, int n) {
        int p = n/2 - 1;
        for (int i = p; i >= 0; i--) {
            siftDown(nums, i, n);
        }
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int[] nums) {
        division(nums, 0, nums.length - 1);
    }
    private static void division(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            division(nums, start, mid);
            division(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }
    private static void merge(int[] nums, int start, int mid, int end) {
        int len1 = mid - start + 1, len2 = end - mid;
        int i,j,k;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (i = 0; i < len1; i++)
            left[i] = nums[i+start];
        for (i = 0; i < len2; i++)
            right[i] = nums[i+mid+1];
        i = 0;
        j = 0;
        for (k = start; k < end; k++) {
            if (i == len1 || j == len2)
                break;
            if (left[i] <= right[j])
                nums[k] = left[i++];
            else
                nums[k] = right[j++];
        }
        while (i < len1)
            nums[k++] = left[i++];
        while (j < len2)
            nums[k++] = right[j++];

    }
}
