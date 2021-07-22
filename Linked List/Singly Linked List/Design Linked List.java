class MyLinkedList {
    public int val;
    private MyLinkedList next = null;
    private MyLinkedList prev = null;
    
    /** Initialize your data structure here. */
    
    public MyLinkedList() {
        
    }
    
    private boolean checkIndex(int index) {
        return index >= 0 || index <= 1000;   
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(!checkIndex(index)) return -1;
        MyLinkedList n = at(index);
        return n != null ? n.val : -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        MyLinkedList n = new MyLinkedList();
        n.val = val;
        n.next = this.next;
        if(next != null) next.prev = n;
        this.next = n;  
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(next == null) {
            addAtHead(val);
            return;
        }
        
        MyLinkedList last = next;
        while(last.next != null) {
            last = last.next;
        }
        MyLinkedList n = new MyLinkedList();
        n.val = val;
        last.next = n;
        n.prev = last;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(!checkIndex(index)) return;
        if(index == 0) {
            addAtHead(val);      
            return;
        }
        MyLinkedList located = at(index - 1);
        if(located != null) {
            MyLinkedList n = new MyLinkedList();
            n.val = val;
            n.next = located.next;
            if(located.next != null) located.next.prev = n;
            n.prev = located;
            located.next = n;
        }
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(!checkIndex(index)) return;
        if(index == 0) {
            next = next.next; 
            return;
        }
        MyLinkedList located = at(index - 1);
        if(located != null && located.next != null) {
            located.next = located.next.next;
            if(located.next != null) located.next.prev = located;
        }    
    }
    
    /** get node value by index. */
    private MyLinkedList at(int index) {
        MyLinkedList n = next;
        for(int i = 0; i < index; i++) {
            if(n.next == null) return null;
            n = n.next;
        }
        return n;
    }
}
