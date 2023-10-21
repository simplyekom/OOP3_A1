package application;
import java.util.Arrays;
import java.util.Comparator;

public class Utilities {

    public static <T extends Comparable<? super T>> void bubbleSort(T[] arr) {
    	int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) < 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
    
    public static <T> void bubbleSort(T[] array, Comparator<? super T> c) {
    	int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (c.compare(array[j], array[j + 1]) < 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
    	int n = arr.length;
        for (int i = 1; i < n; ++i) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) < 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    public static <T> void insertionSort(T[] array, Comparator<? super T> c) {
    	int n = array.length;
        for (int i = 1; i < n; ++i) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && c.compare(array[j], key) < 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static <T extends Comparable<? super T>> void selectionSort(T[] arr) {
    	int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            T temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static <T> void selectionSort(T[] array, Comparator<? super T> c) {
    	int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (c.compare(array[j], array[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            T temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
    }
    
    public static <T extends Comparable<? super T>> void mergeSort(T[] arr) {
    	
    }
    
    public static <T> void mergeSort(T[] array, Comparator<? super T> c) {
    	
    }
    
    public static <T extends Comparable<? super T>> void quickSort(T[] arr) {
    	
    }
    
    public static <T> void quickSort(T[] array, Comparator<? super T> c) {
    	
    }
    
    public static <T extends Comparable<? super T>> void shellSort(T[] arr) {
    	
    }
    
    public static <T> void shellSort(T[] array, Comparator<? super T> c) {
    	
    }
    
    // Need to make a method that will measure the time taken by a sorting algorithm
    
    public static <T> void printSortedValues(T[] arr) {
    	/*The program should also print the first sorted value and last sorted value,
    	and every thousandth value in between */
        System.out.println("First sorted value: " + arr[0]); //Prints first element of the array
        System.out.println("Last sorted value: " + arr[arr.length - 1]); //Prints last element of the array
        for (int i = 1; i < arr.length - 1; i += 1000) {
            System.out.println("Value at index " + i + ": " + arr[i]);
        }
    }
}