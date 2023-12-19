public class BinaryHeap {

    private int[] heap;
    private int capacity;
    private int size;

    public BinaryHeap() {
        this.heap = new int[16];
        this.capacity = 16;
        this.size = 0;
    }

    private int leftChild(int pos) {
        return 2 * pos + 1;
    }

    private int rightChild(int pos) {
        return 2 * pos + 2;
    }

    private void siftDown(int pos) {
        int largest = pos;
        int left = leftChild(pos);
        int right = rightChild(pos);
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != pos) {
            swap(pos, largest);
            siftDown(largest);
        }
    }

    private void siftDownSort(int pos, int size) {
        int largest = pos;
        int left = leftChild(pos);
        int right = rightChild(pos);
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != pos) {
            swap(pos, largest);
            siftDownSort(largest, size);
        }
    }

    public void add(int value) {
        ensureCapacity();
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        siftUp(size);
        size++;
    }

    private void ensureCapacity() {
        if (size + 1 == capacity) {
            int[] newHeap = new int[capacity * 2];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
            capacity *= 2;
        }
    }

    private void siftUp(int pos) {
        while (pos > 0 && heap[pos] > heap[parent(pos)]) {
            swap(pos, parent(pos));
            pos = parent(pos);
        }
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    private void swap(int pos1, int pos2) {
        int tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    public void sort() {
        int n = size;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            siftDown(i);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(0, i);
            siftDownSort(0, i);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < size; i *= 2) {
            for (int j = i - 1; j < i * 2 - 1 && j < size; j++) {
                sb.append(heap[j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}