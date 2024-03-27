public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}class DSAHeap {
    private DSAHeapEntry[] heap;
    private int count;

    public DSAHeap(int maxSize) {
        heap = new DSAHeapEntry[maxSize];
        count = 0;
    }

    public void add(int priority, Object value) {
        DSAHeapEntry entry = new DSAHeapEntry(priority, value);
        heap[count] = entry;
        trickleUp(count++);
    }

    public DSAHeapEntry remove() {
        DSAHeapEntry root = heap[0];
        heap[0] = heap[--count];
        trickleDown(0);
        return root;
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.println(heap[i].getValue() + " with priority " + heap[i].getPriority());
        }
    }

    private void trickleUp(int index) {
        int parentIdx = (index - 1) / 2;
        DSAHeapEntry bottom = heap[index];
        while (index > 0 && heap[parentIdx].getPriority() < bottom.getPriority()) {
            heap[index] = heap[parentIdx];
            index = parentIdx;
            parentIdx = (parentIdx - 1) / 2;
        }
        heap[index] = bottom;
    }

    private void trickleDown(int index) {
        int largerChildIdx;
        DSAHeapEntry top = heap[index];
        while (index < count / 2) {
            int leftChildIdx = 2 * index + 1;
            int rightChildIdx = leftChildIdx + 1;
            if (rightChildIdx < count && heap[leftChildIdx].getPriority() < heap[rightChildIdx].getPriority())
                largerChildIdx = rightChildIdx;
            else
                largerChildIdx = leftChildIdx;

            if (top.getPriority() >= heap[largerChildIdx].getPriority())
                break;

            heap[index] = heap[largerChildIdx];
            index = largerChildIdx;
        }
        heap[index] = top;
    }
}

class DSAHeapEntry {
    private int priority;
    private Object value;

    public DSAHeapEntry(int priority, Object value) {
        this.priority = priority;
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
