package com.company.problems.easy;

import com.company.problems.Test;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        var root1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        var root2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        ListNode result = solution.mergeTwoLists(root1, root2);

        Test.isTrue(
                result.val == 1
                && result.next.val == 1
                && result.next.next.val == 2
                && result.next.next.next.val == 3
                && result.next.next.next.next.val == 4
                && result.next.next.next.next.next.val == 4
        );
        Test.equals(result.next.next.next.next.next.next, null);

        //
//        var root3 = new ListNode(1);
//        var root4 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        ListNode result2 = solution.mergeTwoLists(root3, root4);
//        ListNode result3 = solution.mergeTwoLists(null, root4);
//        Test.isTrue(true);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) { return list2; }
        if (list2 == null) { return list1; }

        Step step = new Step(list1, list2);
        ListNode root = getSmaller(step);
        ListNode currentNode = root;
        ListNode node = currentNode;
        while (node != null) {
            currentNode.next = node;
            currentNode = node;
            node = getSmaller(step);
        }
        currentNode.next = null;
        return root;
    }

    private ListNode getSmaller(Step step) {
        ListNode result;
        if (step.list1 == null) {
            result = step.list2;
            if (step.list2 != null) {
                step.list2 = step.list2.next;
            }
            return result;
        }
        if (step.list2 == null) {
            result = step.list1;
            step.list1 = step.list1.next;
            return result;
        }
        if (step.list1.val < step.list2.val) {
            result = step.list1;
            step.list1 = step.list1.next;
        } else {
            result = step.list2;
            step.list2 = step.list2.next;
        }
        return result;
    }

    static class Step {
        ListNode list1;
        ListNode list2;

        public Step(ListNode list1, ListNode list2) {
            this.list1 = list1;
            this.list2 = list2;
        }
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
