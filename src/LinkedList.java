class LinkedList{
    Node head;  // head of list
 
    class Node{
        int data;
        Node next;

        Node(int d) {data = d; next = null; }
    }
 
    /* Inserts a new Node at front of the list. */
    public void push(Node node, int new_data){
        
        Node new_node = new Node(new_data); // 1 & 2: Allocate the Node & Put in the data*/
 
        new_node.next = head; // 3. Make next of new Node as head */
 
        node = new_node;  // 4. Move the head to point to new Node */
        head=node;
    }
 
    /* Inserts a new node after the given prev_node. */
    public void insertAfter(Node prev_node, int new_data) {
        /* 1. Check if the given Node is null */
        if (prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
 
        /* 2 & 3: Allocate the Node & Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 4. Make next of new Node as next of prev_node */
        new_node.next = prev_node.next;
 
        /* 5. make next of prev_node as new_node */
        prev_node.next = new_node;
    }
    
    /* Appends a new node at the end. This method is 
       defined inside LinkedList class  */
    public Node append(Node node, int new_data)
    {
        /* 1. Allocate the Node 2. Put in the data 3. Set next as null */
        Node new_node = new Node(new_data);
 
        /* 4. If the Linked List is empty, then make the new node as head */
        if (node == null) {
        	node = new_node;
        	head=node;
            return head;
        }
 
        /* 4. This new node is going to be the last node, so
              make next of it as null */
        //new_node.next = null;
 
        /* 5. Else traverse till the last node */
        Node last = node; 
        while (last.next != null)
            last = last.next;
 
        /* 6. Change the next of last node */
        last.next = new_node;
        head=node;
        return head;
    }
    
    public Node deleteNode(Node node, Node d) {
    	Node temp=node;
    	
    	if (temp.data==d.data) {
    		assert head==node;
    		node=temp.next;
    		temp.next=null;
    		head=node;
    		return temp;
    	}
    	
    	Node del=null;
    	while (temp.next!=null) {
    		if (temp.next.data== d.data) {
    			del = temp.next;
    			temp.next=temp.next.next;
    		}
    		//if it is the last node to be deleted then second last node will already point to null
   			if (temp.next!=null) temp=temp.next;
    	}
    	head=node;
    	return del;
    }
    
    public void delNodeWithoutHead(Node n) {
    	if (n==null || n.next==null) return;
    	Node nextn=n.next;
    	n.data=nextn.data;
    	n.next=nextn.next;
    }
 
    /* This function prints contents of linked list starting from
        the given node */
    public void printList(Node head)
    {
        Node tnode = head;
        while (tnode != null)
        {
            System.out.print(tnode.data+"->");
            tnode = tnode.next;
        }
        System.out.println("\n");
    }
    
    public void nthToLastPrint(Node node, int pos) {
    	Node temp=node;
    	if (temp==null || pos<1) return;
    	
    	for (int i=1;i<pos&&temp!=null;i++) {
    		//System.out.println("i = "+i+" Data = "+n.data);
    		temp=temp.next;
    	}
    	
    	if (temp==null) return;

    	while (temp != null)
        {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    	
    }
    
    public Node reverse(Node node) {
    	if (node==null) return null;
        
        Node prev=node;
        Node curr;
        while(prev.next!=null){
            curr=prev.next;
            prev.next=curr.next;
            curr.next=node;
            node=curr;
        }
        
        head=node;
        
        return head;
			
   	}
    
    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
        
        // Insert 6.  So linked list becomes 6->NUllist
        llist.append(null,6);

        // Insert 7 at the beginning. So linked list becomes
        // 7->6->NUllist
        llist.push(llist.head,7);

        // Insert 1 at the beginning. So linked list becomes
        // 1->7->6->NUllist
        llist.push(llist.head,1);
 
        // Insert 4 at the end. So linked list becomes
        // 1->7->6->4->NUllist
        llist.append(llist.head,4);
 
        // Insert 8, after 7. So linked list becomes
        // 1->7->8->6->4->NUllist
        llist.insertAfter(llist.head.next, 8);
        System.out.println("Created Linked list is: ");
        llist.printList(llist.head);
        
        llist.reverse(llist.head);
        System.out.println("Reversed Linked list is: ");
        llist.printList(llist.head);
        
        System.out.print("Deleted data is "+llist.deleteNode(llist.head,llist.head.next.next).data);
        System.out.println("\nUpdated Linked list is: ");
        llist.printList(llist.head);
        
        
        System.out.println("\nnthToLast Linked list is: ");
        llist.nthToLastPrint(llist.head,2);
        
        llist.delNodeWithoutHead(llist.head.next.next);
        System.out.println("\n\nUpdated Linked list  after delete is: ");
        llist.printList(llist.head);
        
    }
}