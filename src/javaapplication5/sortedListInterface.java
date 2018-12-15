package javaapplication5;

/**
 *
 * @author Chong Zi Yi
 */
public interface sortedListInterface<T> {

    public boolean add(T newEntry); //ok
     
     public T get(int index); //ok
        
     public int size(); //ok 

    public T remove(int givenPosition);

    public boolean isEmpty();

;
    
   
}
