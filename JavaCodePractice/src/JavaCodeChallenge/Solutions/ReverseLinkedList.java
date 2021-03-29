/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * How to reverse a linked list ?
 *
 * @author tangz
 */
public class ReverseLinkedList {

    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;
        
        while(curNode != null){
            nextNode = curNode.next; //Save next node
            curNode.next = preNode;  //Modify pointer of curent to point to the prev node
            preNode = curNode;       //Move prev pointer to current
            curNode = nextNode;      //Move current pointer to next
        }
        
        return preNode;
    }

    public static ListNode reverseLinkedNode2 (ListNode head){
        
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;
        
        while(curNode.next != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        
        return preNode;
    }
    
    
    public static String printListNode(ListNode n) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while (n.next != null) {
            sb.append(n.val);
            sb.append(", ");
            n = n.next;
        }
        sb.append(n.val);
        sb.append(" ");
        sb.append(" ]");
        return sb.toString();
    }

    public static void main(String[] args) {

        ListNode n9 = new ListNode(18, null);//Tail
        ListNode n8 = new ListNode(17, n9);
        ListNode n7 = new ListNode(16, n8);
        ListNode n6 = new ListNode(25, n7);
        ListNode n5 = new ListNode(15, n6);
        ListNode n4 = new ListNode(14, n5);
        ListNode n3 = new ListNode(13, n4);
        ListNode n2 = new ListNode(12, n3);
        ListNode n1 = new ListNode(11, n2);//Head

        System.out.println("Orginal Linked List: " + printListNode(n1));
        ListNode head = reverseListNode(n1);
        System.out.println("Reversed Linked List: " + printListNode(head));
        
    }
}
