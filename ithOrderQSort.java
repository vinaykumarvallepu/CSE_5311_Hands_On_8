public class ithOrderQSort {
    public static int quickSelect(int[] arr, int left, int right, int ithElement) {
        if (left == right) {
            return arr[left];
        }

        int pIndex = partition(arr, left, right);
        if (ithElement== pIndex) {
            return arr[ithElement];
        } else if (ithElement < pIndex) {
            return quickSelect(arr, left, pIndex - 1, ithElement);
        } else {
            return quickSelect(arr, pIndex + 1, right, ithElement);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {90, 20, 40, 30, 25, 0, 10, 50, 35, 45};
        int ithElement = 6;
        System.out.println("The " + ithElement + "th Order element is " + quickSelect(arr, 0, arr.length - 1, ithElement - 1));
    }
}
