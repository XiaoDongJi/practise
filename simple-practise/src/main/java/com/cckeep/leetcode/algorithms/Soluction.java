package com.cckeep.leetcode.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Soluction {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        System.out.println(func(node));
    }


    public static class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }

    public static List<Integer> func(Node head){
        if(head == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<Node> list = new LinkedList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        int n = list.size();
        int m = n / 2;
        if(n % 2 == 1) m -= 1;
        res.add(list.get(m).val);

        int i = m,j = m;
        while(i >= 0 || j <= n -1){
            if(--i >= 0){
                res.add(list.get(i).val);
            }
            if(++j <= n -1){
                res.add(list.get(j).val);
            }
        }
        return res;
    }

}
