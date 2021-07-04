import java.util.Scanner;

public class MergeSortArray {
    public void mergeSort(int[] arr, int staringIndex, int endingIndex) {
        if (staringIndex >= endingIndex) {
            return;
        }
        int mid = (staringIndex + endingIndex) / 2;
        mergeSort(arr, staringIndex, mid);
        mergeSort(arr, mid + 1, endingIndex);
        merge(arr, staringIndex, mid, endingIndex);
    }

    public void merge(int[] arr, int startingIndex, int mid, int endingIndex) {
        int sizeofFirstArray = mid + 1 - startingIndex;
        int sizeofSecondArray = endingIndex - mid;
        int[] array1 = new int[sizeofFirstArray];
        int[] array2 = new int[sizeofSecondArray];
        for (int i = 0; i < sizeofFirstArray; i++){
            array1[i] = arr[i + startingIndex];
        }
        for (int j = 0; j < sizeofSecondArray; j++){
            array2[j] = arr[mid + j + 1];
        }
        int i = 0; int j = 0, k = startingIndex;
        while (i < sizeofFirstArray && j < sizeofSecondArray) {
            if (array1[i] < array2[j]) {
                arr[k] = array1[i];
                i++;
            } else {
                arr[k] = array2[j];
                j++;
            }
            k++;
        }
        while (i < sizeofFirstArray) {
            arr[k] = array1[i];
            i++;
            k++;
        }
        while (j < sizeofSecondArray) {
            arr[k] = array2[j];
            j++;
            k++;
        }
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
        MergeSortArray ms = new MergeSortArray();
        int[] arr = ms.takeInput();
        ms.mergeSort(arr, 0, arr.length - 1);
        ms.printArray(arr);
    }
}
