import javax.swing.*;

public class ChainedHashing {
    public static void main ( String[] args ) {
        ChainedHashSet obj = new ChainedHashSet(5);

        obj.insert(8);
        obj.insert(6);
        obj.insert(64);
        obj.insert(13);
        obj.insert(3);
        obj.insert(24);

        obj.displayData();
        System.out.println(obj.isPresent(3));
        System.out.println(obj.isPresent(33));
    }
}

class HashTable extends LinkedList{
    LinkedList hashedArr[];
    HashTable(int size){
        hashedArr = new LinkedList[size];
    }

//    checks whether the particular index of the hashedArr is null
//    or have a linkedlist present
    private boolean isEmptySlot(int index){
        return hashedArr[index] == null;
    }

    private boolean isCollided(int index){
        return hashedArr[index] == null;
    }

    void insertAsList(int index, int data){
        if (isCollided(index)){
            LinkedList newLinkedListObj = new LinkedList();
            hashedArr[index] = newLinkedListObj;
        }
        hashedArr[index].insert(data);

    }

    void showAll(){
        for (int i = 0; i < hashedArr.length; i++){
            System.out.print("index "+i+" -> ");
            if (hashedArr[i] == null)
                System.out.print("null");
            else
                hashedArr[i].display();
            System.out.println();
        }
    }
}

class ChainedHashSet {
    private HashTable tableObj;
    private int size;
    ChainedHashSet(int size) {
        this.size = size;
        tableObj = new HashTable(size);
    }
    private int getIndex ( int data ){
        return data % size;
    }
    void insert(int data){
        int index = getIndex(data);
        tableObj.insertAsList(index, data);
    }
    void displayData() {
        tableObj.showAll();
    }
    boolean isPresent(int data){
        int index = getIndex(data);
        return tableObj.hashedArr[index].search(data) != null;
    }
}

