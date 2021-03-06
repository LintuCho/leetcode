/*
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (31.47%)
 * Total Accepted:    138.6K
 * Total Submissions: 440.3K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return head;
        int renum = n-m+1;
        ListNode p = head, q, tmp;
        m--;
        while(m-->0){
            p = p.next;
        } 
        q = p.next;
        while (renum>0) {
            tmp = p.next;
            p.next = q;
            q = q.next;
            p.next.next = tmp;
            p = p.next;
            renum--;
        }
        return head;
    }
}
