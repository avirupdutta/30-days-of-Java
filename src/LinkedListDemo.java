//class LinkedList{
//    static class Node{
//        int data;
//        Node next, prev;
//        Node(int data){
//            this.data = data;
//            this.next = null;
//            this.prev = null;
//        }
//    }
//    Node head = null;
//    Node tail = null;
//    public Node search(int data){
//        if (head == null){
//            System.out.println("There is no data to search!");
//            return null;
//        }
//        Node curNode = head;
//        while (curNode != null){
//            if(curNode.data == data){
//                return curNode;
//            }
//            curNode = curNode.next;
//        }
//        return null;
//    }
//
//    public void insert(int data){
//        if (head == null){
//            head = new Node(data);
//        }
//        else if (search(data) != null){
//            System.out.println(data + " is already in present the list");
//        }
//        else {
//            head = insertRecur(head, data);
//        }
//    }
//    private Node insertRecur( Node curNode, int data){
//        if (curNode == null){
//            curNode = new Node(data);
//        }else{
//            curNode.next = insertRecur(curNode.next, data);
//            curNode.next.prev = curNode;
//        }
//        if (curNode.next == null)
//            tail = curNode;
//        return curNode;
//    }
//
//    public void reverse(){
//        if (head.next == null){
//            System.out.println("Linked List with 1 Node cannot be reversed!");
//            return;
//        }
//        head = reverseRecur(head, head.prev);
//    }
//    private Node reverseRecur(Node curr, Node prev){
//        /* If last node mark it head*/
//        if (curr.next == null) {
//            head = curr;
//
//            /* Update next to prev node */
//            curr.next = prev;
//
//            return head;
//        }
//
//        /* Save curr->next node for recursive call */
//        Node next1 = curr.next;
//
//        /* and update next ..*/
//        curr.next = prev;
//
//        reverseRecur(next1, curr);
//        return head;
//    }
//
//    void display(){
//        Node curNode = head;
//        while (curNode != null){
//            System.out.print(curNode.data + " ");
//            curNode = curNode.next;
//        }
//    }
//
//}
//
//public class LinkedListDemo {
//    public static void main ( String[] args ) {
//        LinkedList linkedListObj = new LinkedList();
////        linkedListObj.head = new LinkedList.Node(10);
////        linkedListObj.head.next = new LinkedList.Node(20);
////        linkedListObj.head.next.next = new LinkedList.Node(30);
////        linkedListObj.head.next.next.next = new LinkedList.Node(40);
////        linkedListObj.head.next.next.next.next = new LinkedList.Node(50);
//
////        System.out.println(linkedListObj.search(50));
//        linkedListObj.insert(10);
//        linkedListObj.insert(20);
//        linkedListObj.insert(30);
//        linkedListObj.insert(40);
//        linkedListObj.insert(50);
//
////        System.out.println(linkedListObj.tail.data);
//
//        linkedListObj.reverse();
//        linkedListObj.display();
////        System.out.println(linkedListObj.tail.data);
//    }
//}
