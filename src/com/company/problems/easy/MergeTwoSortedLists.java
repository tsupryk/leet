package com.company.problems.easy;

import com.company.problems.Test;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // case 1
        var root1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var root2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode result = solution.mergeTwoLists(root1, root2);
        Test.isTrue(
                result.val == 1
                && result.next.val == 1
                && result.next.next.val == 2
                && result.next.next.next.val == 3
                && result.next.next.next.next.val == 4
                && result.next.next.next.next.next.val == 4
                && result.next.next.next.next.next.next == null
        );

        // case 2
        var root3 = new ListNode(1);
        var root4 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result2 = solution.mergeTwoLists(root3, root4);
        Test.isTrue(
                result2.val == 1
                        && result2.next.val == 1
                        && result2.next.next.val == 3
                        && result2.next.next.next.val == 4
        );
        Test.equals(result2.next.next.next.next, null);

        // case 4
        ListNode result3 = solution.mergeTwoLists(null, root4);
        Test.isTrue(
                result3.val == 1
                        && result3.next.val == 3
                        && result3.next.next.val == 4
        );
        Test.equals(result3.next.next.next, null);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) { return list2; }
        if (list2 == null) { return list1; }

        ListNode root = null;
        ListNode currentNode = null;

        if (list1.val > list2.val) {
            root = list2;
            list2 = list2.next;
        } else {
            root = list1;
            list1 = list1.next;
        }

        currentNode = root;
        while (currentNode != null) {
            if (list1 == null) {
                currentNode.next = list2;
                return root;
            } else if (list2 == null) {
                currentNode.next = list1;
                return root;
            } else if (list1.val > list2.val) {
                currentNode.next = list2;
                list2 = list2.next;
            } else {
                currentNode.next = list1;
                list1 = list1.next;
            }
            currentNode = currentNode.next;
        }
        return root;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" + val + '}';
        }
    }

}
