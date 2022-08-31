#####################
time limited Exceed run below code (it is only my thought, maybe not ture)
1. seem it didn't find the first match character under two for loop cause extra time 
2. it didn't reposition after the word is found
3. when mask and unmask with visisted, it seem not thing related to check or not check in board. compare to java solution
#####################


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        ## RC ##
		## APPROACH : TRIE + DFS ##
		## LOGIC ##
		#	1. build trie with all words list
		#	2. start scanning matrix, move in all four directions and check if such combination exists in the trie
		#	3. make sure you donot return when result is found ( case: words = [cat, cattle ] )
		
        ## TIME COMPLEXICITY : O(M(4x3^(L-1))) ## (M is the number of cells in the board and L is the maximum length of words.)
		## SPACE COMPLEXICITY : O(N) ##
	    
        def dfs(i, j, curr, currNode):              #dfs 
            ch = board[i][j]
            if( ch not in currNode.children or (i, j) in visited ):   #base case #1, 2
                return
            if currNode.children[ch].endOfWord:         ##  base #3: find the word
                res.add(curr)
                # return                            # edge case
            visited.add((i,j))                      ##mask
            for x,y in directions:
                if 0 <= i + x < m and 0 <= j + y < n:       #base case 4
                    dfs( i + x, j + y, curr + board[i + x][j + y], currNode.children[ch])  ##4 direction dfs
            visited.remove((i,j))         ##unmask
        
        # buid trie data structure
        my_trie = Trie()
        [ my_trie.insert(word) for word in words ]          ##all words
        rootNode = my_trie.get_rootNode()                   # first rootNode   ????
        
        m, n = len(board), len(board[0])
        directions = [(0,1), (1,0), (0,-1), (-1,0)]
        res = set()                     
        for i in range(len(board)):
            for j in range(len(board[i])):
                visited = set()
                dfs(i, j, board[i][j], rootNode)
        return res
    
class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False
##buildTrie in java
class Trie:
    def __init__(self):
        self.rootNode = TrieNode()
    
    def get_rootNode(self):
        return self.rootNode
    
    # Inserts a word into the trie.   only one word, not words
    def insert(self, word: str) -> None:
        currNode = self.rootNode
        for idx, ch in enumerate(word):
            if( ch not in currNode.children ):
                currNode.children[ch] = TrieNode()
            currNode = currNode.children[ch]        
        currNode.endOfWord = True