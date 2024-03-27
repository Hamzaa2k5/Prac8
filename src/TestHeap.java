public class TestHeap {
    public static void main(String[] args) {
        DSAHeap heap = new DSAHeap(10);

        heap.add(10, "A");
        heap.add(5, "B");
        heap.add(15, "C");
        heap.add(20, "D");

        System.out.println("Heap after insertion:");
        heap.display();

        DSAHeapEntry removed = heap.remove();
        System.out.println("Removed element: " + removed.getValue() + " with priority " + removed.getPriority());

        System.out.println("Heap after removal:");
        heap.display();
    }
}
