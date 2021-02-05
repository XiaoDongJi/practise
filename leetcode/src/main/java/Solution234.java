/**
 * @author: jixd
 * @date: 2021/1/24 10:42 上午
 */
public class Solution234 {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(1);
        isPalindrome(root);
    }


    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null) {
            slow = slow.next;
        }
        fast = head;
        ListNode node = revert(slow);

        while(node != null){
            if(fast.val != node.val){
                return false;
            }
            fast = fast.next;
            node = node.next;
        }
        return true;
    }

    public static ListNode revert(ListNode root){
        ListNode pre = null,cur = root;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
