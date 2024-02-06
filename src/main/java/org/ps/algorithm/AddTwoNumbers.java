package org.ps.algorithm;

import org.junit.Assert;
import org.junit.Test;
import org.ps.structure.ListNode;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">link</a>
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode start = new ListNode(0);
        ListNode head = start;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int l1Val = (l1 != null) ? l1.val : 0;

            int l2Val = (l2 != null) ? l2.val : 0;

            int sum = l1Val + l2Val + carry;

            carry = sum / 10;

            head.next = new ListNode(sum % 10);
            head = head.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            head.next = new ListNode(carry);
        }

        return start.next;
    }

    public ListNode createLinkedList(int[] nums) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        for (int num : nums) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummyHead.next;
    }

    public void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public String getResultInStr(ListNode head) {

        StringBuilder res = new StringBuilder();

        ListNode current = head;
        while (current != null) {
            res.append(current.val);
            current = current.next;
        }
        return res.toString();
    }

    @Test
    public void test() {
// Test case 1
        int[] nums1 = {2, 4, 3};
        int[] nums2 = {5, 6, 4};
        ListNode l1 = createLinkedList(nums1);
        ListNode l2 = createLinkedList(nums2);
        System.out.print("Input: ");
        printLinkedList(l1); // Input: 2 4 3
        printLinkedList(l2); // Input: 5 6 4
        ListNode result1 = addTwoNumbers(l1, l2);
        System.out.print("Output: ");
        printLinkedList(result1); // Output: 7 0 8

        Assert.assertEquals("708", getResultInStr(result1));

        // Test case 2
        int[] nums3 = {0};
        int[] nums4 = {0};
        ListNode l3 = createLinkedList(nums3);
        ListNode l4 = createLinkedList(nums4);
        System.out.print("Input: ");
        printLinkedList(l3); // Input: 0
        printLinkedList(l4); // Input: 0
        ListNode result2 = addTwoNumbers(l3, l4);
        System.out.print("Output: ");
        printLinkedList(result2); // Output: 0

        Assert.assertEquals(new ListNode(0).val, result2.val);

        Assert.assertEquals("0", getResultInStr(result2));

        // Test case 3
        int[] nums5 = {9, 9, 9, 9, 9, 9, 9};
        int[] nums6 = {9, 9, 9, 9};
        ListNode l5 = createLinkedList(nums5);
        ListNode l6 = createLinkedList(nums6);
        System.out.print("Input: ");
        printLinkedList(l5); // Input: 9 9 9 9 9 9 9
        printLinkedList(l6); // Input: 9 9 9 9
        ListNode result3 = addTwoNumbers(l5, l6);
        System.out.print("Output: ");
        printLinkedList(result3); // Output: 8 9 9 9 0 0 0 1

        Assert.assertEquals("89990001", getResultInStr(result3));
    }
}
