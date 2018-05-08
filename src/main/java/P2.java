import java.math.BigInteger;

/**
 * Created by qilongji on 18/5/9.
 */
public class P2 {
    /**
     * Definition for singly-linked list.
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;

            return getList(getValue(l1).add(getValue(l2)));

        }

        BigInteger getValue(ListNode l) {
            BigInteger value =null;
            BigInteger multi = BigInteger.TEN;

            do {
                if( value == null) {
                    value = BigInteger.valueOf(l.val);
                } else {
                    value = multi.multiply(BigInteger.valueOf(l.val)).add(value);
                    multi = multi.multiply(BigInteger.TEN);
                }

                l = l.next;
            } while(l != null);

            return value;
        }

        ListNode getList(BigInteger value) {
            ListNode l = null;
            ListNode lastNode = null;

            while(true) {
                long mod = value.mod(BigInteger.TEN).longValue();
                value = value.divide(BigInteger.TEN);

                ListNode node = new ListNode((int)mod);
                if(l == null) {
                    l = node;
                } else {
                    lastNode.next = node;
                }
                lastNode = node;

                if(value.equals(BigInteger.ZERO)) break;
            }

            return l;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String s = "";
            ListNode node = this;
            while(node.next != null) {
                s = s+ String.valueOf(node.val);
                node = node.next;
            }

            s = s + node.val;
            return s;
        }
    }

    public static void main(String[] args) {
        //

        System.out.println(new Solution().getValue(new Solution().getList(BigInteger.valueOf(753865680l))));
      //  System.out.println(new Solution().getList(BigInteger.valueOf(753865680l)));
    }
}
