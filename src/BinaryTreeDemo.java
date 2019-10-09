/**
 * BinaryTreeDemo
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        Tree binarTreeObj = new Tree(10);

//        binarTreeObj.root.leftChild = new Node(20);
//        binarTreeObj.root.rightChild = new Node(30);
//        binarTreeObj.root.leftChild.leftChild = new Node(40);
//        binarTreeObj.root.leftChild.rightChild = new Node(50);

        binarTreeObj.insert(20);
        binarTreeObj.insert(5);
        binarTreeObj.insert(3);
        binarTreeObj.insert(8);
        binarTreeObj.insert(80);
        binarTreeObj.insert(86);
        binarTreeObj.insert(50);

//         binarTreeObj.showInOrder(binarTreeObj.root);
         binarTreeObj.showPreOrder(binarTreeObj.root);
        // binarTreeObj.showPostOrder(binarTreeObj.root);

        System.out.println("\n"+binarTreeObj.countNodes());
    }

}
class Tree{
    Node root;
    Tree(int data){
        root = new Node(data);
    }
    void insert(int data){
        root = insert(root, data);
    }
    private Node insert(Node currNode, int data){
        if(currNode == null){
            currNode = new Node(data);
        }
        else if(currNode.data < data){
            currNode.rightChild = insert(currNode.rightChild, data);
        }
        else if(currNode.data > data){
            currNode.leftChild = insert(currNode.leftChild, data);
        }
        return currNode;
    }

    int countNodes(){
        return countNodes(root, 0, 0);
    }
    private int countNodes(Node currNode, int leftCount, int rightCount){

        if (currNode == null)
            return 0;
        leftCount = countNodes(currNode.leftChild, leftCount, rightCount);
        rightCount = countNodes(currNode.rightChild, leftCount, rightCount);

        return leftCount + rightCount + 1;
    }

    void showInOrder(Node currNode){
        if(currNode == null)
            return;
        showInOrder(currNode.leftChild);
        System.out.print(currNode.data+" ");
        showInOrder(currNode.rightChild);
    }
    void showPreOrder(Node currNode){
        if(currNode == null)
            return;
        System.out.print(currNode.data+" ");
        showPreOrder(currNode.leftChild);
        showPreOrder(currNode.rightChild);
    }
    void showPostOrder(Node currNode){
        if(currNode == null)
            return;
        showPostOrder(currNode.leftChild);
        showPostOrder(currNode.rightChild);
        System.out.print(currNode.data+" ");
    }
}
class Node{
    int data;
    Node leftChild, rightChild;
    Node(int data){
        this.data = data;
        leftChild = null;
        rightChild = null;
    }
}