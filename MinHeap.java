/*
 * Written by Jones Vicinus
 */

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {
    private List<T> heap;

    // Constructor
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Add an element to the heap
    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    // Remove and return the element from the top of the heap
    public T remove() {
        if (heap.isEmpty()) {
            return null;
        }

        T root = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return root;
    }

    // Helper method to maintain heap property after adding an element
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index).compareTo(heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // Helper method to maintain heap property after removing an element
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heap.size() && heap.get(leftChild).compareTo(heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Helper method to swap elements in the heap
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Method to check if the heap is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
