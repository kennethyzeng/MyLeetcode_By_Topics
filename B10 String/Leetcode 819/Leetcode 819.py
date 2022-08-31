###########


#############
import re

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        d = {}
        paragraph = re.split(" |,|!|'|;|\?|\.", paragraph)
        # paragraph = paragraph.replace(',',' ').replace(';',' ').replace('!',' ').replace('?',' ').replace("'",' ').replace('.',' ').split(' ')
        for i in paragraph:
            x = i.lower()
            if x not in banned and len(x) > 0:
                d[x] = d.get(x,0) + 1
        return [i for i,j in sorted(d.items(), key= lambda x:x[1], reverse=True)][0]



#######3

	punctuation = "!?',;."

    for punc in punctuation:
        if punc in paragraph:
            paragraph = paragraph.replace(punc," ")

    P = paragraph.lower().split()
    mc = 0

    for words in P:
        if words not in banned and P.count(words) > mc:
            mc = P.count(words)
            word = words
    
    return(word)