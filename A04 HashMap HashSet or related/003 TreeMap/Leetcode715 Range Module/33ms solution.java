/*
33 ms treempa

*/ 

class RangeModule {
 
    TreeMap<Integer,Integer> map;
    public RangeModule() {
        map = new TreeMap();
    }
    
    public void addRange(int left, int right) 
    {
        Map.Entry<Integer,Integer> prevEntry = map.floorEntry(right);
        if(prevEntry == null || prevEntry.getValue() < left)
        {
            map.put(left,right);
        }
        else
        {
            map.remove(prevEntry.getKey());
            left = Math.min(left,prevEntry.getKey());
            right = Math.max(right,prevEntry.getValue());
            addRange(left,right);
        }
         
    }
    
    public boolean queryRange(int left, int right) 
    {
       
        Map.Entry<Integer,Integer> prevEntry = map.floorEntry(right);
        if(prevEntry != null && prevEntry.getKey() <= left && prevEntry.getValue() >= right) return true;
        return false;
    }
    
    public void removeRange(int left, int right) 
    {
     
        Map.Entry<Integer,Integer> prevEntry = map.floorEntry(right-1);//[1-2] [3-6]
        if(prevEntry == null || prevEntry.getValue() <= left) return;

        map.remove(prevEntry.getKey());
        if(left <= prevEntry.getKey()  && right >= prevEntry.getValue())
        {
           removeRange(left,right);
        }
        else
        {
            /*
               10 - 15 => remove 0 -  12
               10 - 15 => remove 13 - 25    
               10 - 15 => remove 12 - 14    
            */
            int prevLeft = prevEntry.getKey();
            int prevRight = prevEntry.getValue();
            if(left <= prevLeft)
            {
               map.put(right,prevRight);
               removeRange(left,prevLeft);
            }
            else if(right >= prevRight)
            {
                map.put(prevLeft,left);
            }
            else if(left > prevLeft && right < prevRight)
            {
                map.put(prevLeft,left);
                map.put(right,prevRight);
            }
        }
       
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */


/*
0 -8 10 - 25  7 - 28 => add 0 -  28
0 - 8 10- 28 0 - 28  => search 0 - 28
 
4- 5  6 -  10 ==> remove 8 - 9 search from 13
     left1 right1
 (right right1)
 (left1,left)
 
 left1,left
 right, right1
*/