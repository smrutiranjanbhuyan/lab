package lab_pratice_ad2;

public class MergeSortWithInversions {

    private static long inversionCount = 0; 

    public static void mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);
            merge(arr, l, mid, h);
        }
    }

    public static void merge(int[] arr, int l, int mid, int h) {
      
        int n1 = mid - l + 1;
        int n2 = h - mid;

        
        int[] L = new int[n1];
        int[] R = new int[n2];

      
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

      
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
               
                arr[k++] = R[j++];
                inversionCount += (mid - l + 1 - i); 
            }
        }

     
        while (i < n1) {
            arr[k++] = L[i++];
        }

     
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array:");
        printArray(arr);

        System.out.println("\nNumber of inversions: " + inversionCount);
    }
}
