package DataStructures;

import java.util.NoSuchElementException;

public class BoundedMinHeap {
    private int[] arr;
    private int size;

    public BoundedMinHeap (int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        this.arr = arr;
        size = arr.length;
        heapify();
    }

    private void heapify() {
        for (int i = size/2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public BoundedMinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("Capacity cannot be smaller or equal to 0");
        }

        arr = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void percolateUp (int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (arr[parentIndex] > arr[index]) {
                swap(arr, parentIndex, index);
            } else {
                break;
            }

            index = parentIndex;
        }
    }

    private void percolateDown (int index) {
        //check if index is legal?
        while (index <= size / 2 - 1) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int swapCandidate = leftChildIndex;//initialize
            //swap if the rightchild index exists and is smaller
            if (rightChildIndex <= size - 1 && arr[leftChildIndex] >= arr[rightChildIndex]) {
                swapCandidate = rightChildIndex;
            }

            //swap if necessary
            if (arr[index] > arr[swapCandidate]) {
                swap(arr, index, swapCandidate);
            } else {
                break;
            }

            index = swapCandidate;

        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        return arr[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }
        int res = arr[0];
        arr[0] = arr[size - 1];
        size--;
        percolateDown(0);
        return res;
    }

    public void offer(int ele) {
        //demo for unbounded PQ implementation
//        if (size == arr.length) {
//            int[] newArr = new int[arr.length*1.5];
//            copy(arr, newArr);
//            arr = newArr;
//        }
        arr[size] = ele;
        size++;
        percolateUp(size - 1);
    }

    //return the original value
    public int update(int index, int ele) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Invalid index range");
        }
        int res = arr[index];
        arr[index] = ele;
        if (res > ele) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return res;
    }
}
