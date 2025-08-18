public class MergeSortedArrays {

    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int total = m + n;
        int gap = nextGap(total);

        while (gap > 0) {
            int i, j;
            for (i = 0; i + gap < m; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    swap(arr1, i, arr1, i + gap);
                }
            }
            for (j = (gap > m) ? gap - m : 0; i < m && j < n; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    swap(arr1, i, arr2, j);
                }
            }
            if (j < n) {
                for (j = 0; j + gap < n; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        swap(arr2, j, arr2, j + gap);
                    }
                }
            }

            gap = nextGap(gap);
        }
    }
    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
    private static void swap(int[] arrA, int i, int[] arrB, int j) {
        int temp = arrA[i];
        arrA[i] = arrB[j];
        arrB[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("arr1: " + java.util.Arrays.toString(arr1));
        System.out.println("arr2: " + java.util.Arrays.toString(arr2));

        int[] arr3 = {10, 12, 14};
        int[] arr4 = {1, 3, 5};
        merge(arr3, arr4, arr3.length, arr4.length);
        System.out.println("arr3: " + java.util.Arrays.toString(arr3));
        System.out.println("arr4: " + java.util.Arrays.toString(arr4));

        int[] arr5 = {2, 3, 8};
        int[] arr6 = {4, 6, 10};
        merge(arr5, arr6, arr5.length, arr6.length);
        System.out.println("arr5: " + java.util.Arrays.toString(arr5));
        System.out.println("arr6: " + java.util.Arrays.toString(arr6));

        int[] arr7 = {1};
        int[] arr8 = {2};
        merge(arr7, arr8, arr7.length, arr8.length);
        System.out.println("arr7: " + java.util.Arrays.toString(arr7));
        System.out.println("arr8: " + java.util.Arrays.toString(arr8));
    }
}
