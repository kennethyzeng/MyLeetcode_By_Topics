"""
coding flow process: 
#step 1: present a graph(weight graph) with adjacents list
    -use dictionary to presend adjcent nodes with their edge value;   format:   {'A':{adjcent node:edge value, ...},'B'...  }   
#step 2: 
    -build a start table or initial table 
        node, shortest distance from source, previous Node 
    -use dictionary  in format    'A':['0', None]      node:[shortest distance from source, previous node]; float("int") for another node's diestance      
"""
def get_shortest_distance(table, vertex):
    """return shortest distance value which stored in the index 0 of the table"""
    pass 

def set_shortest_distance(table,vertex, new_distance):
    """only set shortest distance value which stored in the index 0 of the table """
    pass 


#step 1: present graph
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
    'F': [float("inf"), None],

}