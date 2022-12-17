/**
Assassin Game
By: Kenton La
*/
//represents a single node in a linked list
//player name, killer name, and reference to the next node

public class AssassinNode
{
    private String data;
    private AssassinNode front;
    private AssassinNode next;
    
    public AssassinNode(){
        this("",null);
    }
    
    public AssassinNode(String data){
        this(data,null);
    }
    
    public AssassinNode(String data, AssassinNode next){
        this.data = data;
        this.next = next;
    }
    
    public void add(String value) { //adds a name to linked list
        if (front == null) {        //if the linked list is empty create a new node
            front = new AssassinNode(value);
            front.next = front;     //points the next element to the front to create a circularly linked list
        } else {
            AssassinNode current = front;
            while (current.next != front) {     //goes to the end of the list right before going back to front
                current = current.next;
            }
            current.next = new AssassinNode(value); //creates a new node at end of list
            current.next.next = front;          //points next value of last node to front
        }
    }
    
    public void remove(int index) { //removes element at specified index
        if (index == 0) {       //removes first element of linked list
            // front = front.next;
            AssassinNode current = front;
            while (current.next != front) {     //goes to the end of the list right before going back to front
                current = current.next;
            }
            current.next = front.next;          //resets the circular link so that our new front value is the node after the current front value
            front = front.next;
        } else {
            AssassinNode current = nodeAt(index - 1);   //uses nodeAt() to set current to the node before removal index
            current.next = current.next.next;           //links the value before removal index to the one after (skips over)
        }
    }
    
    //gets size by going to next node starting from the front until the front is reached again.
    public int size() {
        int counter = 0;
        AssassinNode current = front;
        if(current == null){
            return counter;
        } else{
            current = current.next;
            counter++;
        }
        while(current != front)
        {
            current = current.next;
            counter++;
        }
        return counter;
    }
    
    //used for kill() method in AssassinManager class
    public int indexOf(String name){
        int index = 0;
        while(index < size()){
            if(name.compareToIgnoreCase(get(index)) == 0){
                return index;
            }
            index++;
        }
        return -1;
    }
    
    //returns value at specified index
    public String get(int index) {
        if (index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException("Index: " + index + "is out of bounds.");
        }
        AssassinNode current = nodeAt(index);
        return current.data;
    }
    
    //returns node at specified index
    public AssassinNode nodeAt(int index) {
        AssassinNode current = front;
        for (int i = 0; i < index; i++) {
            if (current.next != null || current.next != front)
            {
                current = current.next;
            } else{
                throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds.");
            }
        }
        return current;
    }
}
