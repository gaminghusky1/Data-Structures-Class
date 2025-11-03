public class IntNode {
    public IntNode next;
    public int val;

    public IntNode(int val, IntNode next) {
        this.val = val;
        this.next = next;
    }

    public IntNode(int val) {
        this(val, null);
    }

    public IntNode() {
        this(0, null);
    }
}
