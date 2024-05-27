package utilities;


public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(Integer val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public Integer getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    public String stringifyNode() {
        StringBuilder builder = new StringBuilder();
        ListNode ref = this;
        while (ref != null) {
            builder.append(ref.val);
            ref = ref.next;
            if (ref != null) {
                builder.append("->");
            }
        }
        return builder.toString();
    }

    public static ListNode convertToListNode(int[] arr) {
        ListNode node = new ListNode(arr[0]);
        ListNode cur = node;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return node;
    }
}
