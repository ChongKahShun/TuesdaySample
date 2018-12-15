package javaapplication5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 
 * @param <T>
 */
public class sortedList<T extends Comparable<? super T>> implements sortedListInterface<T> , Serializable {

      
   private Node firstNode;
    private int numberOfOrder;
    
    
    public sortedList() {
        firstNode = null;
        numberOfOrder = 0;
    }

    

     public boolean add(T newEntry) {//add newEntry to the end of the sorted list with the position this is sorted
        Node newNode = new Node(newEntry);

        Node nodeBefore = null;// For linked list traversal: to reference the node before the current node
        Node currentNode = firstNode;// For linked list traversal: to reference the current node
        while (currentNode != null && newEntry.compareTo(currentNode.data) > 0) {
            nodeBefore = currentNode;
            currentNode = currentNode.next;
        }

        if (isEmpty() || (nodeBefore == null)) { // CASE 1: add at beginning
            newNode.next = firstNode;
            firstNode = newNode;
        } else {	// CASE 2: add in the middle or at the end
            newNode.next = currentNode;
            nodeBefore.next = newNode;
        }
        numberOfOrder++;
        return true;
    }


    @Override
    public T remove(int index) {
        T result = null;
        if(!isEmpty() && index<numberOfOrder){
            if(index ==0){
                result = firstNode.data;
                if(firstNode.next != null)
                    firstNode = firstNode.next;
                else
                   firstNode=null;
            }else{
                Node currentNode = firstNode;
                for(int i = 0; i< index-1 ;i++)
                    currentNode = currentNode.next;
                result = currentNode.next.data;
                if(currentNode.next.next!=null)
                    currentNode.next = currentNode.next.next;
                else 
                    currentNode.next=null;
            }
            numberOfOrder--;
        }
            
        return result;
    }

    @Override
    public T get(int index) {
        T result = null;
        if(!isEmpty()&&index<numberOfOrder){
            Node currentNode = firstNode;
            for(int i = 0; i<index;i++)
                currentNode=currentNode.next;
            result = currentNode.data; 
        }
            
        return result;
        
    }

    @Override
    public boolean isEmpty() {
       return numberOfOrder==0;
    }


    @Override
    public int size() {
        return numberOfOrder;
    }

        
    public class Node implements Serializable {

    private T data;
    private Node next;

    private Node() {
      this.data = null;
      this.next = null;
    }
    
    private Node(T data) {
      this.data = data;
      this.next = null;
    }
  } // end Node
}
    
    

