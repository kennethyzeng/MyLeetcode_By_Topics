def hash(data):
    """
    data: str
    sum up all values of (mulitplier value * ordinal number of each character), then mod 256
    """
    mul = 1
    hv = 0    #hashing value 
    for ch in data:
        hv += mul * ord(ch)
        mul += 1
    return hv 

items = ['foo', 'bar', 'bim', 'baz', 'quux', 'duux', 'gnn', 'hello world', 'world hello']
for item in items: 
    print("{}:{}".format(item, hash(item)))  


#sum the ordinal value of the character 
res= sum(map(ord,'gello xorld'))
print(res)