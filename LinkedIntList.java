import java.util.List;

public class LinkedIntList {
    protected IntNode head;
    protected int size;

    public LinkedIntList() {
        head = null;
        size = 0;
    }

    public LinkedIntList(List<Integer> list) {
        this();
        this.addAll(list);
    }

    public void addAll(List<Integer> list) {
        for (Integer i : list) {
            this.add(i);
        }
    }

    public void add(int val) {
        this.add(size, val);
    }

    public void add(int idx, int val) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for size %d.", idx, size));
        }
        size++;
        if (idx == 0) {
            head = new IntNode(val, head);
            return;
        }
        IntNode temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        temp.next = new IntNode(val, temp.next);
    }

    public void addSorted(int val) {
        if (head == null || head.val >= val) {
            head = new IntNode(val, head);
        }
        IntNode temp = head;
        while (temp.next != null && temp.next.val < val) {
            temp = temp.next;
        }
        temp.next = new IntNode(val, temp.next);
    }

    public int get(int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for size %d.", idx, size));
        }
        IntNode temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public int set(int idx, int val) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for size %d.", idx, size));
        }
        IntNode temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        int oldVal = temp.val;
        temp.val = val;
        return oldVal;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int remove(int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for size %d.", idx, size));
        }
        size--;
        if (idx == 0) {
            int oldVal = head.val;
            head = head.next;
            return oldVal;
        }
        IntNode temp = head;
        for (int i = 0; i < idx - 1; i++) {
            temp = temp.next;
        }
        int oldVal = temp.next.val;
        temp.next = temp.next.next;
        return oldVal;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int indexOf(int val) {
        IntNode temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.val == val) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public boolean contains(int val) {
        IntNode temp = head;
        while (temp != null) {
            if (temp.val == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void sort() {
        head = mergeSort(head, size);
    }

    private IntNode mergeSort(IntNode head, int size) {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            return new IntNode(head.val, null);
        }
        int mid = size / 2;
        IntNode right = head;
        for (int i = 0; i < mid; i++) {
            right = right.next;
        }
        return merge(mergeSort(head, mid), mergeSort(right, size - mid), mid, size - mid);
    }

    private IntNode merge(IntNode leftHead, IntNode rightHead, int leftSize, int rightSize) {
        IntNode head = new IntNode();
        IntNode temp = head;
        int leftIdx = 0, rightIdx = 0;
        while (leftIdx < leftSize && rightIdx < rightSize) {
            if (leftHead.val <= rightHead.val) {
                temp.next = new IntNode(leftHead.val, null);
                temp = temp.next;
                leftHead = leftHead.next;
                leftIdx++;
            } else {
                temp.next = new IntNode(rightHead.val, null);
                temp = temp.next;
                rightHead = rightHead.next;
                rightIdx++;
            }
        }
        while (leftIdx < leftSize) {
            temp.next = new IntNode(leftHead.val, null);
            temp = temp.next;
            leftHead = leftHead.next;
            leftIdx++;
        }
        while (rightIdx < rightSize) {
            temp.next = new IntNode(rightHead.val, null);
            temp = temp.next;
            rightHead = rightHead.next;
            rightIdx++;
        }
        return head.next;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        IntNode temp = head;
        sb.append(temp.val);
        temp = temp.next;
        while (temp != null) {
            sb.append(", ").append(temp.val);
            temp = temp.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
