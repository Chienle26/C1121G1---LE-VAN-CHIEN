package ss13_sorting_algorithms.exercise;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 6, 4, 3, 8, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\n"+"---------------------------------->");
        arr = insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static int[] insertionSort(int[] arr) {
        int pos;
        int x;
        for (int i = 1; i < arr.length; i++) {
            x = arr[i];
            pos = i;
            while (pos > 0 && x < arr[pos - 1]) {
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
        }
        return arr;
    }
}
