package com.cckeep.leetcode.algorithms;

/**
 * @author: jixd
 * @date: 2021/3/2 8:47 上午
 */
public class Offer35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public Node copyRandomList(Node head) {
        if (head == null) return head;
        //插入临时节点
        Node cur = head;
        while(cur != null){
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }
        //临时节点指向random节点
        cur = head;
        while (cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
                cur = cur.next.next;
            }
        }

        Node pre = head;
        cur = head.next;
        Node res = cur;
        while(pre.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }


}
