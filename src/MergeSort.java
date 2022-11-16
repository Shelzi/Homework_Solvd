public class MergeSort implements Sort {
    private void mergeCompare(int[] a, int beg, int mid, int end) {
        int sizeLeftArray = mid - beg + 1;
        int sizeRightArray = end - mid;

        int[] LeftArray = new int[sizeLeftArray];
        int[] RightArray = new int[sizeRightArray];

        for (int i = 0; i < sizeLeftArray; i++) {
            LeftArray[i] = a[beg + i];
        }
        for (int i = 0; i < sizeRightArray; i++) {
            RightArray[i] = a[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = beg;

        while (i < sizeLeftArray && j < sizeRightArray) {
            if (LeftArray[i] <= RightArray[j]) {
                a[k] = LeftArray[i];
                i++;
            } else {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < sizeLeftArray) {
            a[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j < sizeRightArray) {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }

    private void mergeDivide(int[] a, int beg, int end) {
        if (beg < end) {
            int mid = (end + beg) / 2;
            mergeDivide(a, beg, mid);
            mergeDivide(a, mid + 1, end);
            mergeCompare(a, beg, mid, end);
        }
    }

    @Override
    public void sort(int[] array) {
        int begIndex = 0;
        int endIndex = array.length - 1;
        mergeDivide(array, begIndex, endIndex);
    }
}