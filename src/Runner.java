public class Runner {
    public static void main(String[] args) {
        int[] a = new int[]{100, 1, 2, 45, 12, 1, 1 , 0, -1};
        printArray(a);
        Sort sorter = new MergeSort();
        sorter.sort(a);
        printArray(a);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}