/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCodeChallenge.Solutions;

/**
 *
 * @author tangz
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean bLastNode1 = l1.next == null;
        boolean bLastNode2 = l2.next == null;

        ListNode result = new ListNode();
        int carry = 0;
        if (bLastNode1 && bLastNode2) {
            int value = l1.val + l2.val;
            if (value >= 10) {
                carry = 1;
                value = value % 10;
                ListNode result2 = new ListNode(carry);
                result.val = value;
                result.next = result2;
            } else {
                result.val = value;
            }
            return result;
        }

        int tmpValue = 0;
        int tmpCarry = 0;
        int i = 0;
        ListNode prevNode = new ListNode();
        while (!bLastNode1 || !bLastNode2) {
            int l = (l1 == null) ? 0 : l1.val;
            int r = (l2 == null) ? 0 : l2.val;
            tmpValue = l + r + tmpCarry;
            tmpCarry = 0;
            if (tmpValue >= 10) {
                tmpCarry = 1;
                tmpValue = tmpValue % 10;
            }

            if (i == 0) {
                prevNode.val = tmpValue;
                result = prevNode;
            } else {
                ListNode node = new ListNode();
                node.val = tmpValue;
                prevNode.next = node;
                prevNode = node;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            bLastNode1 = l1 == null;
            bLastNode2 = l2 == null;
            i++;
        }
        //tmpCarry Must be zero if it is not, add tailing node and set val = tmpCarry
        if (tmpCarry != 0) {
            ListNode node = new ListNode();
            node.val = tmpCarry;
            prevNode.next = node;
            prevNode = node;
        }

        return result;
    }

    public String printListNode(ListNode lNode) {
        String strResult = "[";
        while (lNode.next != null) {
            strResult += lNode.val;
            strResult += ",";
            lNode = lNode.next;
        }
        strResult += lNode.val;
        strResult += "]";
        return strResult;
    }

    public static void main(String[] args) {
        ListNode n9 = new ListNode(9);
        ListNode n8 = new ListNode(9, n9);
        ListNode n7 = new ListNode(9, n8);
        ListNode n6 = new ListNode(9, n7);
        ListNode n5 = new ListNode(9, n6);
        ListNode n4 = new ListNode(9, n5);
        ListNode n3 = new ListNode(9, n4);
        ListNode n2 = new ListNode(9, n3);
        ListNode n1 = new ListNode(9, n2);

        ListNode p4 = new ListNode(9);
        ListNode p3 = new ListNode(9, p4);
        ListNode p2 = new ListNode(9, p3);
        ListNode p1 = new ListNode(9, p2);

        AddTwoNumbers a = new AddTwoNumbers();
        ListNode r1 = a.addTwoNumbers(n1, p1);
        System.out.println(a.printListNode(r1));

        ListNode nos5 = new ListNode(5);
        ListNode pos5 = new ListNode(5);
        ListNode r2 = a.addTwoNumbers(nos5, pos5);
        System.out.println(a.printListNode(r2));
    }
}
