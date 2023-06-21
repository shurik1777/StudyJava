package HeapSortTask;

public class SortPyramidal {
    public static void sort(int[] arr) {
        int n = arr.length;

        // Построить кучу (переставить массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлечь элемент из кучи
        for (int i = n - 1; i > 0; i--) {
            // Переместить текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // вызвать max heapify для уменьшенной кучи
            heapify(arr, i, 0);
        }
    }

    // Чтобы создать поддерево с корнем узла i,
    // который является индексом в arr[]. n - размер кучи
    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // Если левый дочерний элемент больше, чем корень
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний больше, чем самый большой до сих пор
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если самый большой не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно увеличить затронутое поддерево
            heapify(arr, n, largest);
        }
    }
}
