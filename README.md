# LinkedList Concept and Problems


- File 1: LinkedList.java    
	Consists:   
		Node class   
		public void push(Node node, int new_data) - Inserts a new Node at front of the list   
		public void insertAfter(Node prev_node, int new_data) - Inserts a new node after the given prev_node   
		public Node append(Node node, int new_data) - Appends a new node at the end   
		public Node deleteNode(Node node, Node d) - Deletes node d from the list if present   
		public void delNodeWithoutHead(Node n) - Deletes node without a head as input   
		public void printList(Node head) - This function prints contents of linked list starting from the given node    
		public void nthToLastPrint(Node node, int pos) - Prints the given list node from pos to end of the list
		public Node reverse(Node node) - Reverses the given list node
		public static void main(String[] args) - contains test cases