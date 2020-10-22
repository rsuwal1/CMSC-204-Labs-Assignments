import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
   
    protected Comparator<T> comp = null;
        
    public SortedDoubleLinkedList(Comparator<T> comparator) {
       this.comp = comparator;
    }
    
    public SortedDoubleLinkedList<T> add(T data) {
        Node n = new Node(data);
        
        if (size == 0) {
        	
            head = tail = n;
        } else if (comp.compare(head.data, data) > 0) {
        	
            head.previous = n;
            n.next = head;
            head = n;
        } else if (comp.compare(tail.data, data) < 0) {
        	
            tail.next = n;
            n.previous = tail;
            tail = n;
        } else {
        	
            Node find = head;
            while (find != null) {
            	
                if (comp.compare(find.data, data) <= 0) {
                	
                    Node before = find;
                    Node after = find.next;
                    after.previous = before.next = n;
                    n.next = after;
                    n.previous = before;   
                }
                find = find.next;
            }
        }
        
        size++;
        return this;
    }
      
    @Override
    public BasicDoubleLinkedList<T> addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list"); 
    }
    
    @Override
    public BasicDoubleLinkedList<T> addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        return super.iterator();
    }

    @Override
    public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
        super.remove(data, comparator);
        return this;
    }
    
}