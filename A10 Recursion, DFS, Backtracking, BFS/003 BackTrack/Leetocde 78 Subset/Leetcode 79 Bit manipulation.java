/*
Time Complexity: n* 2^n
Space Complexity:

EX: 1, 2, 3
i        j          i & (1<<j) != 0               set                 collectiton
i = 0    j = 0     i  & (1<<j) = 0 
    0    j = 1       0
    0        2      0                                                   []
-----(0001)
    1        0      1                       nums[0] = 1           
    1       1       0   
    1       2       0                                                   [1]
------(0010)
    2       0       0
    2       1       1                        nums[1] = 2
    2       2       0                                                   [2]
------(0011)

    3       0       1                        nums[0] = 1             
    3       1       2                        1, nums[1] = 2
    3       2       0                                                   [1, 2]

-------(0100)
    4       0       0
    4       1       0                        
    4       2       4                          nums[2] = 3              [3]
--------(0101)
    5       0       1                           1
    5       1       0                        
    5       2       4                           1,3                     [1,3]
--------(0110)
    6       0       0
    6       1       2                        2
    6       2       4                        2, 3                       [2,3]
---------(0111)
    7       0       1                         1
    7       1       1                         1, 2
    7       2       1                          1, 2, 3                  [1, 2, 3]
---------(1000)    ==> not count this because < total Numaber
    8       0       0
    8       1       0                                       
    8       2       0                                                   []

*/ 
public List<List<Integer>> subsets(int[] S) {
	Arrays.sort(S);
	int totalNumber = 1 << S.length;        //1 shift left ==> 1000 (8)
	List<List<Integer>> collection = new ArrayList<List<Integer>>(totalNumber);
	for (int i=0; i<totalNumber; i++) {
		List<Integer> set = new LinkedList<Integer>();
		for (int j=0; j<S.length; j++) {
			if ((i & (1<<j)) != 0) {
				set.add(S[j]);
			}
		}
		collection.add(set);
	}
	return collection;
