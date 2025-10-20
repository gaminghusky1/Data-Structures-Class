import java.util.Arrays;

public class ArrayIntList {
    private int[] list;
    private int size;
    private int stepCount;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayIntList(int capacity) {
        stepCount = 0;
        list = new int[capacity]; stepCount++;
        size = 0; stepCount++;
        System.out.println("Steps: " + stepCount);
    }

    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    public void add(int val) {
        this.add(size, val);
    }

    public void add(int idx, int val) {
        stepCount = 0;
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int k = size; k > idx; k--) {
            list[k] = list[k - 1]; stepCount++;
        }
        list[idx] = val; stepCount++;
        size++; stepCount++;
        if (size == list.length) {
            int[] temp = new int[size * 2]; stepCount++;
            for (int i = 0; i < size; i++) {
                temp[i] = list[i]; stepCount++;
            }
            list = temp; stepCount++;
        }
        System.out.println("Steps: " + stepCount);
    }

    public int get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.out.println("Steps: 0");
        return list[idx];
    }

    public int set(int idx, int val) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        System.out.println("Steps: 0");
        return list[idx] = val;
    }

    public int size() {
        System.out.println("Steps: 0");
        return size;
    }

    public boolean isEmpty() {
        System.out.println("Steps: 0");
        return size == 0;
    }

    public int remove(int idx) {
        stepCount = 0;
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        int temp = list[idx]; stepCount++;
        size--; stepCount++;
        for (int i = idx; i < size; i++) {
            list[i] = list[i + 1]; stepCount++;
        }
        list[size] = 0; stepCount++;
        System.out.println("Steps: " + stepCount);
        return temp;
    }

    public int indexOf(int val) {
        stepCount = 0;
        for (int i = 0; i < size; i++) {
            stepCount++;
            if (list[i] == val) {
                System.out.println("Steps: " + stepCount);
                return i;
            }
        }
        System.out.println("Steps: " + stepCount);
        return -1;
    }

    public boolean contains(int val) {
        stepCount = 0;
        for (int i = 0; i < size; i++) {
            stepCount++;
            if (list[i] == val) {
                System.out.println("Steps: " + stepCount);
                return true;
            }
        }
        System.out.println("Steps: " + stepCount);
        return false;
    }

    public void sort() {
        stepCount = 0;
        int[] toSort = Arrays.copyOf(list, size); stepCount++;
        System.arraycopy(mergeSort(toSort), 0, list, 0, size); stepCount++;
        System.out.println("Steps: " + stepCount);
    }

    private int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2; stepCount++;
        int[] left = Arrays.copyOfRange(arr, 0, mid); stepCount++;
        int[] right = Arrays.copyOfRange(arr, mid, arr.length); stepCount++;
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length]; stepCount++;
        int leftIdx = 0, rightIdx = 0; stepCount += 2;
        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] <= right[rightIdx]) {
                res[leftIdx + rightIdx] = left[leftIdx]; stepCount++;
                leftIdx++; stepCount++;
            } else {
                res[leftIdx + rightIdx] = right[rightIdx]; stepCount++;
                rightIdx++; stepCount++;
            }
        }
        while (leftIdx < left.length) {
            res[leftIdx + rightIdx] = left[leftIdx]; stepCount++;
            leftIdx++; stepCount++;
        }
        while (rightIdx < right.length) {
            res[leftIdx + rightIdx] = right[rightIdx]; stepCount++;
            rightIdx++; stepCount++;
        }
        return res;
    }

    public int binarySearch(int val) {
        return binarySearch(0, size, val);
    }

    public int binarySearch(int fromIdx, int toIdx, int val) {
        stepCount = 0;
        if (toIdx < fromIdx || toIdx > size || fromIdx < 0) {
            throw new IllegalArgumentException();
        }
        int lo = fromIdx, hi = toIdx - 1; stepCount += 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; stepCount++;
            if (list[mid] == val) {
                System.out.println("Steps: " + stepCount);
                return mid;
            } else if (list[mid] < val) {
                lo = mid + 1; stepCount++;
            } else {
                hi = mid - 1; stepCount++;
            }
        }
        System.out.println("Steps: " + stepCount);
        return - lo - 1;
    }

    public String toString() {
        stepCount = 0;
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("["); stepCount++;
        sb.append(list[0]); stepCount++;
        for (int i = 1; i < size; i++) {
            sb.append(String.format(", %d", list[i])); stepCount++;
        }
        sb.append("]"); stepCount++;
        System.out.println("Steps: " + stepCount);
        return sb.toString();
    }
}
