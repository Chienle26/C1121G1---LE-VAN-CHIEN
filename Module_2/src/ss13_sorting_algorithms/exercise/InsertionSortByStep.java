package ss13_sorting_algorithms.exercise;

public class InsertionSortByStep {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 6, 4, 3, 8, 1, 9};
        System.out.println("Mảng trước khi được sắp xếp:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
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
            System.out.println("Lần đổi thứ " + i + ": Lấy vị trí của " + x + " đi so sánh với các phần tử trước nó (nếu nhỏ hơn thì đổi chỗ, nếu lớn hơn thì qua lấy phần tự sau nó so sánh)");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + "\t");
            }
            System.out.println();
            while (pos > 0 && x < arr[pos - 1]) {
                System.out.print("Đổi vị trí của " + x + " cho " + arr[pos - 1]);
                System.out.println();
                arr[pos] = arr[pos - 1];
                pos--;
            }
            arr[pos] = x;
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + "\t");
            }
            System.out.println("\n" + "---------------------------------->");
        }
        return arr;
    }
}
