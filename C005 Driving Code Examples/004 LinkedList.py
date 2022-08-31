###########Link source###############


#############Python Version###########

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

 # Node Class
class Node:
   
    # Constructor to create a new node
    def __init__(self, d):
        self.data = d
        self.next = None

    
head = None
head = Node(1)
head.next = Node(2)
head.next.next = Node(3)
head.next.next.next = Node(4)
head.next.next.next.next = Node(5)