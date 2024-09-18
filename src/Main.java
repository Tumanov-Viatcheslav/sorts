public class Main {
    public static void main(String[] args) {
        int[] data = {6, 55, 5, 4, 3, 0, 2, 1, 107};
        Sorts.mergeSort(data);
        for (int e :
                data) {
            System.out.println(e);
        }
    }
}