/**
 * BinaryTreeDemo
 */
//public class BinaryTreeDemo {
//    public static void main(String[] args) {
//        Tree binarTreeObj = new Tree("10");
//
//        binarTreeObj.root.leftChild = new Node("20");
//        binarTreeObj.root.rightChild = new Node("30");
//        binarTreeObj.root.leftChild.leftChild = new Node("40");
//        binarTreeObj.root.leftChild.rightChild = new Node("50");
//
//        // binarTreeObj.showInOrder(binarTreeObj.root);
//        // binarTreeObj.showPreOrder(binarTreeObj.root);
//        // binarTreeObj.showPostOrder(binarTreeObj.root);
//    }
//
//}
//class Tree{
//    Node root;
//    Tree(String data){
//        root = new Node(data);
//    }
//    void insert(String data){
//        if(root.leftChild == null){
//            root.leftChild = Node(data);
//        }
//        else if(root.rightChild == null){
//            root.rightChild = Node(data);
//        }
//        insert(root, data);
//    }
//    private void insert(Node currNode, String data){
//        if(currNode.leftChild == null){
//            insert(currNode.leftChild, data);
//        }
//        else if(currNode.rightChild == null){
//            insert(currNode.rightChild, data);
//        }
//        else if(currNode.leftChild == null){
//            currNode.leftChild  = new Node(data);
//        }
//        return;
//    }
//
//
//    void showInOrder(Node currNode){
//        if(currNode == null)
//            return;
//        showInOrder(currNode.leftChild);
//        System.out.print(currNode.data+" ");
//        showInOrder(currNode.rightChild);
//    }
//    void showPreOrder(Node currNode){
//        if(currNode == null)
//            return;
//        System.out.print(currNode.data+" ");
//        showPreOrder(currNode.leftChild);
//        showPreOrder(currNode.rightChild);
//    }
//    void showPostOrder(Node currNode){
//        if(currNode == null)
//            return;
//        showPostOrder(currNode.leftChild);
//        showPostOrder(currNode.rightChild);
//        System.out.print(currNode.data+" ");
//    }
//}
//class Node{
//    String data;
//    Node leftChild, rightChild;
//    Node(String data){
//        this.data = data;
//        leftChild = null;
//        rightChild = null;
//    }
//}