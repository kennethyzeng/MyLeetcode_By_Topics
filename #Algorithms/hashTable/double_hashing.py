"""
double hashing technique to slove problem of collision 
    -

#1 hashitem 
#2 hastable class
    -hash function for hash value
    -additional h2 function which for computer ordinal value     #modification; don't need to mode self.size
    -put() method     #modification for next avaiable slot formula
    -get() method      #modification for next avaiable slot formula
    -check_growth()     
    -growth()      #modification one line; change the namem of class call
Note: add self.prime_num

something to think:(refer from book)
Linear probing leads to primary clustering, while quadratic probing may lead to secondary clus-
tering, whereas the double hashing technique is one of the most effective methods for collision
resolution since it does not yield any clusters. The advantage of this technique is that it produces
a uniform distribution of records in the hash table.
    
"""
#step 1
class HashItem: 
    def __init__(self,key, value):
        self.key = key
        self.value = value

class DoubleHashing_HashTable:
    #step 1
    def __init__(self):
        #self.size = 256
        self.size = 10
        self.slots =[None for i in range(self.size)]
        self.count = 0   #track how many slots are filled
        self.MAXLOADFACTOR = 0.65 
        self.prime_num = 5      #modification

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
        New_Hash_Table=DoubleHashing_HashTable()    #modification
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
    

    def h2(self, key):
        """compute the sum of the ordinal values; don't use _hash() function above"""
        mult = 1 
        hv = 0 
        for ch in key: 
            hv += mult * ord(ch)
            mult +=1
        return hv 


    #step 3:
    def put(self, key, value):
        """storing elements in the hash table""" 
        item = HashItem(key, value)
        h = self._hash(key)
        j = 1           #modification
        #condition 1: if the slot is not empty, keep adding 1 to hashing value 
        while self.slots[h] != None:
            if self.slots[h].key == key:
                break
            h = (h + j*(self.prime_num - (self.h2(key) % self.prime_num))) % self.size   #next free slot number  #modification
            j = j +1     #modification
        #condition 2:  when slot is empty
        if self.slots[h] == None:
            self.count +=1 
        self.slots[h] = item    #[{key, value}, {key,value}...]  
        self.check_growth()

    #step 6: 
    def get(self,key): 
        """retrive data from matched key"""
        h = self._hash(key)
        j = 1     #modification
        while self.slots[h] != None: 
            if self.slots[h].key == key: 
                return self.slots[h].value 
            h = (h + j * (self.prime_num - (self.h2(key) % self.prime_num))) % self.size   #modification
            j = j + 1     #modificatioin
        #codition for no match key
        return None 


####cases validations 
ht = DoubleHashing_HashTable()
ht.put("good", "eggs")
ht.put("better", "ham")
ht.put("best", "spam")
ht.put("ad", "do not")
ht.put("ga", "collide")
ht.put("awd", "do not" )
ht.put("add", "do not")
ht.check_growth()

#get validation 
for key in ("good", "better", "best", "worst", "ad", "ga"):
    res=ht.get(key)
    print(res)
    