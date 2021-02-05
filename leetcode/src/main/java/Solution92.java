/**
 * @author: jixd
 * @date: 2021/1/4 9:46 上午
 */
public class Solution92 {
    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);

        reverse(root);
        //ListNode listNode = reverseN(root, 3);
        //System.out.println(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    //反转链表
    public static ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    //反转前N个节点
    static ListNode success = null;
    public static ListNode reverseN(ListNode head,int n){
        if(n == 1){
            success = head.next;
            return head;
        }
        ListNode last = reverseN(head.next,n - 1);
        head.next.next = head;
        head.next = success;
        return last;
    }


}
