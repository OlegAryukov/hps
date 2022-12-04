package algosecon;

import java.util.Arrays;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        int tree_size = (int) (Math.pow(2, depth + 1) - 1);
        this.HeapArray = Arrays.copyOf(a, tree_size);
        // Index of last non-leaf node
        int startIdx = (a.length / 2) - 1;

        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(HeapArray, HeapArray.length, i);
        }
        // создаём массив кучи HeapArray из заданного
        // размер массива выбираем на основе глубины depth
        // ...
    }

    public int GetMax() {
        // вернуть значение корня и перестроить кучу
        if (HeapArray.length == 0)
            return -1; // если куча пуста
        int root = HeapArray[0];
        int possRoot = HeapArray[HeapArray.length - 1];
        int size = HeapArray.length;
        HeapArray[0] = possRoot;
        HeapArray[HeapArray.length - 1] = 0;
//        int[] ints = Arrays.copyOf(HeapArray, size - 1);
//        HeapArray = Arrays.copyOf(ints, size);

        for (int i = 0; i >= 0; i--) {
            heapify(HeapArray, HeapArray.length, i);
        }
        return root;
    }

    public boolean Add(int key) {
        // добавляем новый элемент key в кучу и перестраиваем её
        if (HeapArray[HeapArray.length - 1] != 0)
            return false; // если куча вся заполнена
        for (int i = HeapArray.length - 1; i >= 0; i--) {
            if (HeapArray[i] != 0) {
                HeapArray[i + 1] = key;
                moveUp(HeapArray, i + 1);
                break;
            }
        }
        return true;
    }

    static void moveUp(int heap[], int i) {
        int newable = i;
        int right = (i - 2) / 2;
        if (right >= 0 && heap[i] > heap[right]) {
            int swap = heap[right];
            heap[right] = heap[i];
            heap[i] = swap;
            moveUp(heap, right);
        }
    }

    static void heapify(int heap[], int length, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < length && heap[l] > heap[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < length && heap[r] > heap[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = heap[i];
            heap[i] = heap[largest];
            heap[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(heap, length, largest);
        }
    }

}
