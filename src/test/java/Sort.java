/**
 * Created by jiaxiong on 2019-02-15 19:46
 */
public class Sort {

    private void quickSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int baseval = arr[start];
        while (i < j) {

            //从右往左找
            while (i < j && arr[j] >= baseval) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }

            //从左往右找
            while (i < j && arr[i] < baseval) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = baseval;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    public static void main(String args[]) {
        Sort sortTest = new Sort();

        int arr[] = {3, 2, 38, 26, 27, 46, 48, 50, 47, 4};
        sortTest.quickSort(arr, 0, 9);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
