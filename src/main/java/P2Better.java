import java.math.BigInteger;
import java.util.List;

/**
 * Created by laurenceqi on 18/5/9.
 */
public class P2Better {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode list = new ListNode(-1);
            ListNode next = list;

            while (l1 != null || l2 != null || carry != 0) {
                int value = 0;

                if (l1 != null) {
                    value += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    value += l2.val;
                    l2 = l2.next;
                }

                value += carry;

                ListNode node = new ListNode(value % 10);
                next.next = node;
                next = node;

                carry = value / 10;
            }
            return list.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String s = "";
            ListNode node = this;
            while (node.next != null) {
                s = s + String.valueOf(node.val);
                node = node.next;
            }

            s = s + node.val;
            return s;
        }
    }

    public static void main(String[] args) {
    }
}
