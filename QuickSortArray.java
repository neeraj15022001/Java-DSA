import java.util.Scanner;

public class QuickSortArray {
    public void quickSort(int[] arr, int startingIndex, int endingIndex) {
        if (startingIndex >= endingIndex)
            return;
        int partition = partition(arr, startingIndex, endingIndex);
        quickSort(arr, startingIndex, partition);
        quickSort(arr, partition + 1, endingIndex);
    }

    public int partition(int[] arr, int startingIndex, int endingIndex) {
        int pivotElement = arr[startingIndex];
        int countOfSmallerElements = 0;
        for (int i = startingIndex; i <= endingIndex; i++) {
            if (arr[i] < pivotElement)
                countOfSmallerElements++;
        }
        int pivotIndex = startingIndex + countOfSmallerElements;
        swap(arr, pivotIndex, startingIndex);
        int k = 0, j = 0;
        k = startingIndex;
        j = endingIndex;
        while (k <= pivotIndex && j <= pivotIndex) {
            if (arr[k] > arr[j]) {
                swap(arr,k,j);
                j--;
                k++;
            } else {
                k++;
            }
        }
        return pivotIndex;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] takeInput() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        QuickSortArray qs = new QuickSortArray();
        int[] arr = qs.takeInput();
        qs.quickSort(arr, 0, arr.length - 1);
        qs.printArray(arr);

    }
}
