###########
Time Complexity:
Space Complexity:

need to sort first
ask if two string are sorted in order(ascending order) or not; need to sort it first
if it don't
#############
#########
def diffBetweenTwoStrings(source, target):
  """
  @param source: str
  @param target: str
  @return: str[]
  """
  
  '''
  negative sign is when source has it but target does not
  positive sign is when source does not have it but target does
  0123456
  ABCDEFG     ABDFFGH
         |          |
         i          j
  
  
  - if source == target, i++ j++
  - if source char < target char -> -char, move i++
  - if target char > source char -> +char, move j++
  - remaining chars - just append onto results, but if remaining is source (negative) else target (positive).
  
  A, B, -C, D, -E, F, +F, G, +H
  '''
  i, j = 0, 0
  res = []
  
  while i < len(source) and j < len(target):
    # chars are both equal
    if source[i] == target[j]:
      res.append(source[i])
      i += 1
      j += 1
    # negative case
    elif ord(source[i]) < ord(target[j]):
      res.append("-" + source[i])
      i += 1
    # positive case
    elif ord(source[i]) > ord(target[j]):
      res.append("+" + target[j])
      j += 1
  
  # i depleted j @ last idx of my target
  # either source or target will have remaining items.
  if i < len(source): # append remaining but negative
    while i < len(source):
      res.append("-" + source[i])
      i += 1
    
  if j < len(target): # append remaining but positive
    while j < len(target):
      res.append("+" + target[j])
      j += 1
    
