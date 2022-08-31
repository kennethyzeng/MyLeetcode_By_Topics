########################
https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/

the driver code is little differnt, need to modifty
#######################
public static void main(String[] args)
{
    String s = "ADOBECODEBANC";
    String t = "ABC";
     
      System.out.print("-->Smallest window that contain all character : ");
    System.out.print(MinWindow(s, t));
 
}

#######################
# Driver code
if __name__ == "__main__":
    s = "ADOBECODEBANC"
    p = "ABC"
    result = smallestWindow(s, p)
    print("-->Smallest window that contain all character :", result)
     