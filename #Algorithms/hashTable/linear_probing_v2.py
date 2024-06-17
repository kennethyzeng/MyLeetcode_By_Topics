"""
linear problingn technique to slove problem of collision 
    -add 1 to previous hash value where we get collision for next avaiable slot

#1 hashitem 
#2 hastable class
    -hash function for put method
    -put() method 
    -get() method 
    -check_growth() 
    -growth()

something to think:
when grow the hash table and copy the data from old hash table to double size table, the index position of old hash table and 
new hash table are same ==> it meant it may be not efficients for searching adding parts. 
When large data, it maybe not efficients
    
"""
#step 1
class HashItem: 
    def __init__(self,key, value):
        self.key = key
        self.value = value

class LinearProbing_HashTable:
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
        New_Hash_Table=LinearProbing_HashTable()
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
        #condition 1: if the slot is not empty, keep adding 1 to hashing value 
        while self.slots[h] != None:
            if self.slots[h].key == key:
                break
            h = (h +1) % self.size   #next free slot number

        #condition 2:  when slot is empty
        if self.slots[h] == None:
            self.count +=1 
        self.slots[h] = item    #[{key, value}, {key,value}...]  
        self.check_growth()

    def get(self,key): 
        h = self._hash(key)
        while self.slots[h] != None: 
            if self.slots[h].key == key: 
                return self.slots[h].value 
            h=( h + 1) % self.size 
        #codition for no match key
        return None 
    
    #special method
    def __setitem__(self,key,value):
        self.put(key,value)

    def __getitem__(self,key): 
        return self.get(key)

####cases validations 
ht = LinearProbing_HashTable()
ht["good"]= "eggs"
ht["better"] ="ham"
ht["best"]= "spam"
ht["ad"]= "do not"
ht["ga"]= "collide"
ht["awd"]= "do not" 
ht["add"]= "do not"
ht.check_growth()

#get validation 
for key in ("good", "better", "best", "worst", "ad", "ga"):
    res=ht.get(key)
    print(res)
    