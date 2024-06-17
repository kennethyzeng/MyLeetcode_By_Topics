"""
quadratic problingn technique to slove problem of collision 
    -The next free slots checks: h +1^2 , h +2^2 ,h +3^2 ,.....  
    -new hash value:
        new-hash(key) = (old-hash-value + i^2)
        here, hash-value = key mod table_size

#1 hashitem 
#2 hastable class
    -hash function for put method
    -put() method 
    -get() method 
    -check_growth() 
    -growth()

The difference between quadratic and linear probling:
    get() method 
    put() method 
    also, one line for growth() to call the class 

I think the quadratic probing is little more efficient than linear probling when searching, but it is not balanacing 
since h +1^2 , h +2^2 ,h +3^2 ,.....     one space for first collision, 4 for 2nd time collision, 9 for 3rd collision
    
"""
#step 1
class HashItem: 
    def __init__(self,key, value):
        self.key = key
        self.value = value

class QuadraticProbing_HashTable:
    #step 1
    def __init__(self):
        #self.size = 256
        self.size = 10
        self.slots =[None for i in range(self.size)]
        self.count = 0   #track how many slots are filled
        self.MAXLOADFACTOR = 0.65 
        #self.prime_num = 5

    #step 4: 
    def check_growth(self):
        """check if loadfactor reach threshold"""
        loadfactor= self.count /self.size 
        if loadfactor > self.MAXLOADFACTOR:
            print("Load factor before growing the hash table", self.count/self.size)
            self.growth()
            print("Load factor after grow the hashing table", self.count/self.size)

    #step 5: 
    def growth(self):
        """grow the hash table. set the value of related parameters"""
        New_Hash_Table=QuadraticProbing_HashTable()      #modification for quadratic 
        New_Hash_Table.size = 2 * self.size 
        New_Hash_Table.slots = [None for i in range(New_Hash_Table.size)]

        #copy data to new hash table 
        for i in range(self.size):
            if self.slots[i] != None: 
                New_Hash_Table.put(self.slots[i].key, self.slots[i].value)

        #set size and slots
        self.size = New_Hash_Table.size 
        self.slots = New_Hash_Table.slots

    #step 2: hashing function
    def _hash(self, key):
        """get hash value"""
        mult = 1 
        hv = 0 
        for ch in key: 
            hv += mult * ord(ch)
            mult +=1
        return hv % self.size

    #step 3:
    def put(self, key, value):
        """storing elements in the hash table""" 
        item = HashItem(key, value)
        h = self._hash(key)
        j = 1                #modification for quadratic 
        #condition 1: if the slot is not empty, keep adding 1 to hashing value 
        while self.slots[h] != None:
            if self.slots[h].key == key:
                break
            h = (h +j*j) % self.size   #next free slot number  #modification for quadratic 
            j +=1    #modification for quadratic 

        #condition 2:  when slot is empty
        if self.slots[h] == None:
            self.count +=1 
        self.slots[h] = item    #[{key, value}, {key,value}...]  
        self.check_growth()

    def get(self,key): 
        h = self._hash(key)
        j = 1    #modification for quadratic 
        while self.slots[h] != None: 
            if self.slots[h].key == key: 
                return self.slots[h].value 
            h = (h + j * j) % self.size   #hash value   #modification for quadratic 
            j = j +1    #modification for quadratic 
        #codition for no match key
        return None 


####cases validations 
ht = QuadraticProbing_HashTable()
ht.put("good", "eggs")
ht.put("better", "ham")
ht.put("best", "spam")
ht.put("ad", "do not")
ht.put("ga", "collide")
ht.put("awd", "do not" )
ht.put("add", "do not")
ht.check_growth()

res = ht.get("ga")
print(res)
    