package site.daishuyang;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = addTwoNumbers(l1, l2);
        System.out.print(node.val + "->");
        while (node.next != null) {
            System.out.print(node.next.val + "->");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 第一位计算
        int i1 = l1.val;
        int i2 = l2.val;
        int i = i1 + i2;
        int iv = i % 10;
        int nextAdd = i / 10;
        ListNode result = new ListNode(iv);
        ListNode nextNode = result;
        // 开始后续循环
        while (l1.next != null || l2.next != null || nextAdd > 0) {
            i1 = l1.next == null ? 0 : l1.next.val;
            i2 = l2.next == null ? 0 : l2.next.val;
            i = i1 + i2 + nextAdd;
            iv = i % 10;
            ListNode node = new ListNode(iv);
            nextNode.next = node;
            // 设置下次循环信息
            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
            nextNode = node;
            nextAdd = i / 10;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}