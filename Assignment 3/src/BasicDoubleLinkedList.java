import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

    protected Node head;
    protected Node tail;
    int size; //the number of entries

    public BasicDoubleLinkedList() {

        head = null;
        tail = null;
        size = 0;
    }


    /**
     * This method returns the size
     * @return
     */
    public int getSize() {
        return size;
    }


    /**
     * Adds an element to the end of the list
     *
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToEnd(T data) {
    	if (tail == null) {
        	
            tail = new Node(data);
            head = tail;
        } else {
        	
            Node newNode = new Node(data);
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
        return this;
    }

    /**
     * Adds element to the front of the list
     *
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToFront(T data) {
    	 if (head == null) {
             head = new Node(data);
             tail = head;
         } else {
         	
             Node newNode = new Node(data);
             head.previous = newNode;
             newNode.next = head;
             head = newNode;
         }
         size++;
         return this;
    }

    /**
     * Returns but does not remove the first element from the list.
     *  
     * @return the data element or null
     */
    public T getFirst() {

        return head.data;
    }

    /**
     * Returns but does not remove the last element from the list.
     *
     * @return the data element or null
     */
    public T getLast() {

        return tail.data;
    }

   /**
    * 
    */
    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        return new myIterr();
    }


    /**
     * @param targetData - the data element to be removed
     * @param comparator - the comparator to determine equality of data elements
     * @return data element or null
     */
    public BasicDoubleLinkedList<T> remove(T targetData,
                                           java.util.Comparator<T> comparator) {
    	Node targetNode = head;
        while(targetNode != null) {
            if (comparator.compare(targetNode.data, targetData) == 0) {
            	
                if (targetNode == head) {
                    if (head.next != null) {
                    	
                        head = head.next;
                        head.previous = null;
                    } else {
                    	
                        head = tail = null;
                    }
                } else if (targetNode == tail) {
                	
                    if (tail.previous != null) {
                    	
                        tail = tail.previous;
                        tail.next = null;
                    } else {
                    	
                        head = tail = null;
                    }
                } else {
                	
                    targetNode.previous.next = targetNode.next;
                    targetNode.next.previous = targetNode.previous;
                }
                break;
            }
            targetNode = targetNode.next;
        }
        size--;
        return this;
    }

    /**
     * Removes and returns the first element from the list.
     * @return data element or null
     */
    public T retrieveFirstElement() {
    	if (head != null) {
        	
            Node first = head;
            if (head.next != null) {
            	
                head = head.next;
                head.previous = null;
            } else {
            	
                head = tail = null;
            }
            return first.data;
        } else {
        	
            return null;
        }
        
    }


    /**
     * Removes and returns the last element from the list
     * @return data element or null
     */
    public T retrieveLastElement() {
    	if (tail != null) {
        	
            Node last = tail;
            if (tail.previous != null) {
            	
                tail = tail.previous;
                tail.next = null;
            } else {
            	
                head = tail = null;
            }
            return last.data;
        } else {
        	
            return null;
        }
    }

    /**
     * @return an arraylist of the items in the list
     */
    public ArrayList<T> toArrayList() {
    	
        ArrayList<T> list = new ArrayList<>();
        Node temp = head;
        
        while(temp != null) {
        	
            list.add(temp.data);
            temp = temp.next;
        }
        return list;    
    }


    /**
     * Node inner class
     */
    protected class Node {

        T data;
        Node next;
        Node previous;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node nextNode, Node previousNode) {
            this.data = data;
            this.next = nextNode;
            this.previous = previousNode;
        }
    }


    private class myIterr implements ListIterator<T> {

        private Node next;
        private Node previous;

        public myIterr() {
            this.next = head;
            this.previous = null;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
            	previous = next;
                next = previous.next;
                return previous.data;
            } else
                throw new NoSuchElementException();
        }

        @Override
        public boolean hasPrevious() {
            return previous != null;
        }

        @Override
        public T previous() {
            if (hasPrevious()) {
            	next = previous;
                previous = next.previous;
                return next.data; 
            } else
                throw new NoSuchElementException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }

}