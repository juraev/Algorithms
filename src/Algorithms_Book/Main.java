package Algorithms_Book;


import java.util.ArrayList;

/**
 * Created by user on 8/31/18.
 */
public class Main {
    public static int calls = 0;
    public static void main(String[] args) {
        int[] arr = {-1, 7, 3, 5, 9, 5, 3, 0, 6, 8, 8};
        heapify(arr, arr.length - 1);
        for (int i = 1; i <= arr.length - 1; i++) {
            swap(arr, 1, 11 - i);
            sink(arr, 1, 10 - i);
            System.out.println(arr[11 - i]);
        }

        System.out.println("Number of calls is " + calls);
    }


    public static void heapify(int[] arr, int n) {
        for (int i = n/2; i >= 1; i --) {
            sink(arr, i, n);
        }

    }

    public static void sink(int[] arr, int i, int last) {
        while (2 * i <= last) {
            int j = 2 * i;
            if (j < last && arr[j] < arr[j + 1]) j++;
            if (arr[i] >= arr[j]) break;
            swap(arr, i, j);
            i = j;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int h = arr[i];
        arr[i] = arr[j];
        arr[j] = h;
        calls ++;
    }

    public static void swim(int[] arr, int i) {
        while (i > 1 && arr[i / 2] < arr[i]) {
            swap(arr, i / 2, i);
            i = i / 2;
        }
    }
}
