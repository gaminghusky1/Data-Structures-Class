import java.util.Arrays;

public class ArrayIntList {
    private int[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayIntList(int capacity) {
        list = new int[capacity];
        size = 0;
    }

    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
        size = 0;
    }

    public void add(int val) {
        this.add(size, val);
    }

    public void add(int idx, int val) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int k = size; k > idx; k--) {
            list[k] = list[k - 1];
        }
        list[idx] = val;
        size++;
        if (size == list.length) {
            int[] temp = new int[size * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = list[i];
            }
            list = temp;
        }
    }

    public int get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        return list[idx];
    }

    public int set(int idx, int val) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        return list[idx] = val;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        int temp = list[idx];
        size--;
        for (int i = idx; i < size; i++) {
            list[i] = list[i + 1];
        }
        list[size] = 0;
        return temp;
    }

    public int indexOf(int val) {
        for (int i = 0; i < size; i++) {
            if (list[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int val) {
        for (int i = 0; i < size; i++) {
            if (list[i] == val) {
                return true;
            }
        }
        return false;
    }

    public void sort() {
        int[] toSort = Arrays.copyOf(list, size);
        System.arraycopy(mergeSort(toSort), 0, list, 0, size);
    }

    private int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        int leftIdx = 0, rightIdx = 0;
        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] <= right[rightIdx]) {
                res[leftIdx + rightIdx] = left[leftIdx];
                leftIdx++;
            } else {
                res[leftIdx + rightIdx] = right[rightIdx];
                rightIdx++;
            }
        }
        while (leftIdx < left.length) {
            res[leftIdx + rightIdx] = left[leftIdx];
            leftIdx++;
        }
        while (rightIdx < right.length) {
            res[leftIdx + rightIdx] = right[rightIdx];
            rightIdx++;
        }
        return res;
    }

    public int binarySearch(int val) {
        return binarySearch(0, size, val);
    }

    public int binarySearch(int fromIdx, int toIdx, int val) {
        if (toIdx < fromIdx || fromIdx >= size || toIdx < 0) {
            throw new IllegalArgumentException();
        }
        int lo = fromIdx, hi = toIdx;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list[mid] == val) {
                return mid;
            } else if (list[mid] < val) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (lo == size) return - size - 1;
        else if (list[lo] == val) return lo;
        return - lo - 1;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append(list[0]);
        for (int i = 1; i < size; i++) {
            sb.append(String.format(", %d", list[i]));
        }
        sb.append("]");
        return sb.toString();
    }
}
