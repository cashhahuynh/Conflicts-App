package DataManagement;

public class LinkedListConflicts {

    public LinkedListNode head;

    //if there is nothing head is key; else--while there is no next--replace head with next, and replace next with key
    public static LinkedListNode insertInEnd(Object key, LinkedListNode head) {

        LinkedListNode ll = new LinkedListNode(key);
        LinkedListNode ll1 = head;

        if(ll1 == null) {
            head = ll;
        } else {
            while(!(ll1.next == null)) {
                ll1 = ll1.next;
            }
            ll1.next = ll;
        }
        return head;
    }

    public static void display(LinkedListNode head) {

        LinkedListNode ll = head;
        while(!(ll == null)) {

            System.out.print(ll.data + "\n");
            ll = ll.next;

        }

    }

}
