Algorithm:

We can see that wherever the frequency of letters in a string are same, they can be called anagrams
So, the first thought would be to use Counter to calculate that and then distinguish.
But, for that we would have to use Counter as a key in Dictionary and when we find an equal Counter to that while iterating with strs we will append the list with that element and that cannot happen as Counter object is unhashable.
So, here we first sort every word in that array and make a new array such that they all have the similar index.
Then you use the words in sorted array as key and keep appending the words that are corresponding in the other list.
For this we use dictionary. As anagrams have same letters, their sorted version would also be same, so we keep their sorted version as the key and we keep the elements that are correspondingly in the similar array in the list of their key.
This is possible because whatever operation that we make, the corresponding remains same.
I can't explain better than this please help !!!!!! 😂😅
The longer version. Concise version in below this:

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        sorted_letters_list = []
        for word in strs:
            sorted_letters_list.append(sorted(word))
        
        sorted_letter = []
        for letter_list in sorted_letters_list:
            sorted_letter.append(''.join(letter_list))
        
        out_dict = dict()
        for idx,val in enumerate(sorted_letter):
            if val in out_dict:
                out_dict[val].append(strs[idx])
            else:
                out_dict[val] = [strs[idx]]
        
        return [out_dict[x] for x in out_dict]
This is the concise version of the above code:

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        out = map(''.join ,map(sorted, strs))
        
        out_dict = defaultdict(list)
        for idx,val in enumerate(out):
            out_dict[val].append(strs[idx])
        
        return (out_dict[x] for x in out_dict)
Time: O(N * MLogM)
Space: O(N)
where N is the length of the list and M is the length of largest word.