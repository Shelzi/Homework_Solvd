public class Runner {
    public static void main(String args[]) {
        int[] a = new int[]{100, 1, 2, 45, 12, 1, 1 , 0, -1};
        printArray(a);
        Sort sorter = new MergeSort();
        sorter.sort(a);
        printArray(a);
    }

    private static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}