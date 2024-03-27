import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        // Test with random list of varying sizes
        int[][] testCases = {
                {10, 20, 15, 7, 9, 30},
                {4, 10, 3, 5, 1},
                {100, 90, 80, 70, 60, 50, 40, 30, 20, 10},
                {5, 4, 3, 2, 1},
                {1, 3, 5, 7, 9, 2, 4, 6, 8, 10}
        };

        for (int[] arr : testCases) {
            System.out.print("Original array: ");
            printArray(arr);

            heapSort(arr);

            System.out.print("Sorted array: ");
            printArray(arr);
            System.out.println();
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max element) with last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
