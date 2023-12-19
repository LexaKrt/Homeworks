public class Main {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        heap.add(16);
        heap.add(11);
        heap.add(9);
        heap.add(10);
        heap.add(5);
        heap.add(6);
        heap.add(8);
        heap.add(1);
        heap.add(2);
        heap.add(4);
        System.out.println(heap);
        heap.sort();
        System.out.println(heap);
    }
}
