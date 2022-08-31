###########Link source###############
https://www.geeksforgeeks.org/reverse-sublist-linked-list/
https://www.codegrepper.com/code-examples/whatever/reverse+a+linked+list+-+leetcode
###########Jave Version##############
static void print() 
	{ 
		Node temp = head; 
		while (temp != null) { 
			System.out.print(temp.data + " "); 
			temp = temp.next; 
		} 
		System.out.println(); 
	} 
	static void push(int data) 
	{ 
		Node temp = new Node(data); 
		temp.next = head; 
		head = temp; 
	} /* Driver program to test above function*/
public static void main(String args[]) 
{ 
	/* Start with the empty list */
	push(20); 
	push(4); 
	push(15); 
	push(85); 
	System.out.println("Given linked list"); 
	print(); 
	head = reverse(head); 
	System.out.println("Reversed Linked list"); 
	print(); 
} } // This code is contributed by Prakhar Agarwal 


#############Python Version###########
# Function to add a new node at the
# beginning of the list
def push(head_ref, new_data):
 
    new_node = Node(new_data)
    new_node.data = new_data
    new_node.next = (head_ref)
    (head_ref) = new_node
    return head_ref
 
# Driver code
if __name__=='__main__':
     
    head = None
    head = push(head, 70)
    head = push(head, 60)
    head = push(head, 50)
    head = push(head, 40)
    head = push(head, 30)
    head = push(head, 20)
    head = push(head, 10)
     
    reverseBetween(head, 3, 6)
     
    prints(head)