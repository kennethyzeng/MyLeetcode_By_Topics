#! usr/bin/python3
"""
vertex mean the node 

coding flow process: 
#step 1: present a graph(weight graph) with adjacents list
    -use dictionary to presend adjcent nodes with their edge value;   format:   {'A':{adjcent node:edge value, ...},'B'...  }   
#step 2: 
    -build a start table or initial table 
        node, shortest distance from source, previous Node 
    -use dictionary  in format    'A':['0', None]      node:[shortest distance from source, previous node]; float("int") for another node's diestance      
#step 3: build 5 helper functions 
    -get_shortest_distance 
    -set_shortest_distance 
    -set_previous_node 
    -get_distance 
    -get_next_node
#step 4: build main function 
#step 5: build call function for validation


    
 ___________________________   
 The complexity of Dijkstra's algorith depends on how the vertices are stored and retrived
    -generall, min-priproty queue is used to stroe the vertices of the graph, so time coneplexity is depend on how the min-priority queue is implemented 

 each operation for search a vertex from the entire array will take O(V)
 ==>total time complexity is O(V2V^2 +E) = O(V^2)   
-----
if min-priority queue is implented using Fibonacci heap 
    O(|V|) for extracting nthe minium node 
iterate ove all the vertices's adjacent node and updating the shortest distance 
    O(|E|)
each proirty value update take O(log|V|)
==> total time complexity = O(|E| + |V|log|V|)   where |V| is numver of vertices and |E| is the number of edges
       
"""
#Step 3: build helper  functions corresponding to graph and table you draw; observer graph and table to see what you need
def get_shortest_distance(table, vertex):
    """return shortest distance value which stored in the shortest distance column of the table"""
    shortest_distance=table[vertex][DISTANCE]
    return shortest_distance 

def set_shortest_distance(table,vertex, new_distance):
    """only set shortest distance value which stored in the index 0 of the table """
    table[vertex][DISTANCE]=new_distance

def set_previous_node(table,vertex, previous_node):
    """store the value of previous_node at table[vertex][previous_node]"""
    table[vertex][PREVIOUS_NODE]=previous_node

def get_distance(graph, first_vertex, second_vertex):
    """
    to find the distance of the edge tween vertex(unvisted node) and current node
    """
    return graph[first_vertex][second_vertex]

def get_next_node(table, visited_nodes):
    """
    #1 find the unvisted node in table 
        -using visited_nodes to obtain the different difference between two set of lists 
    the very first item in the list of unvisted_nodes is assumed to be the samllest in the shortest distance column of table 

    if a lesser value is found, min_vertex will be updated. it become the shortest distance for unvisted vertex or node 
    """
    unvisted_nodes=list(set(table.keys()).difference(set(visited_nodes)))   ##important: table.keys() is node(first column at table)
    assume_min=table[unvisted_nodes[0]][DISTANCE]  
    min_vertex = unvisted_nodes[0]

    for node in unvisted_nodes:
        if table[node][DISTANCE] < assume_min:
            min_vertex = node 
    return min_vertex    

#Step 4: build main function 
def find_shortest_path(graph, table, origin):
    """
    visisted nodes as list 
    current node: pt to 
    original is the reference point for all other nodes to find the shortest path.  A

    ##breakdown 
    #1 get all the adjacent nodes of the current node 
    #2 use if satement to find out whether all the adjacent nods of current node have been visisted 
    #3 if all nodes have been visisted. move om to the the statement further down the program

    while True:
        if 
            all adjcent node are visisted 
        else:
            unvisted node
            for 
                if 
                    distance for adjacent nodes of start node 
                else 
                    distance for adjancent nodes of no start nodes
                if 
                    update previous node and shortest distance path for table 
        check list length of visisted node for break conditon 
        get next node 
    """
    visited_nodes=[]
    current_node = origin 
    start_node= origin 
    while True: 
        adjacent_nodes=graph[current_node]
        #condition1: all adjacent nodes have been visted
        if set(adjacent_nodes).issubset(set(visited_nodes)):
            #nothing here to do sinve all adjacent nodes have been visted
            pass 
        #condition 2: unvisted nodes
        else: 
            unvisted_nodes = list(set(adjacent_nodes).difference(set(visited_nodes)))   #the loop interates over the list of unvisted nodes
            for vertex in unvisted_nodes:
                distance_from_starting_node=get_shortest_distance(table, vertex)
                #condition2-a: distances for all adjacent nodes of start node; distance between unvisted node and start node
                if distance_from_starting_node == INFINITY and current_node==start_node: 
                    total_distance=get_distance(graph, vertex, current_node)
                #condition 2-b: the distance from the starting node to current node + the distance between currend node and vertex(unvisted node)
                else: 
                    total_distance=get_shortest_distance(table, current_node)+get_distance(graph, current_node, vertex)
                
                #set set shortest distance and previous node for table 
                if total_distance < distance_from_starting_node:
                    set_shortest_distance(table,vertex, total_distance)
                    set_previous_node(table, vertex, current_node)

        visited_nodes.append(current_node)
        #print(vistied_nodes)
        #break for while loop 
        if len(visited_nodes)==len(table.keys()):
            break

        current_node= get_next_node(table, visited_nodes)
    return(table)

#step 1: present graph. represented by the adjacent list
graph=dict()
graph['A']={'B':5, 'D': 9, 'E':2}
graph['B']={'A':5, 'C':2}
graph['C']={'B':2, 'D':3}
graph['D']={'A':9, 'C':3, 'F':2}
graph['E']={'A':2, 'F':3}
graph['F']={'D':2, 'E':3}

#step 2: build initial talbe 
table=dict()
table={
    'A': [0, None],
    'B': [float("inf"), None],
    'C': [float("inf"), None],
    'D': [float("inf"), None],
    'E': [float("inf"), None],
    'F': [float("inf"), None],}

#gloable variable 
DISTANCE =0   #shortest distance; 2nd column at table
PREVIOUS_NODE = 1   #3nd column at table 
INFINITY=float('inf')

###Step 5: Call function for VALIDATION
shortest_distance_table=find_shortest_path(graph, table, 'A')

for k in sorted(shortest_distance_table):
    print("{}-{}".format(k, shortest_distance_table[k]))

"""
something wrong with D: sometime it get 7, and another time it get 9; i think it depend on how unvisted node is listed in list
A-[0, None]
B-[5, 'A']
C-[7, 'B']
D-[9, 'A']
E-[2, 'A']
F-[5, 'E']
"""