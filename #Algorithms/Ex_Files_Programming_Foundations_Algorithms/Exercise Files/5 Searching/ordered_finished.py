items = ["apple", "pear", "orange", "banana", "apple",
         "orange", "apple", "pear", "banana", "orange",
         "apple", "kiwi", "pear", "apple", "orange"]


Filter = dict{}

For item in items: 
	filter[item] = 0 

Res = set(filter.keys())
print(res)