###########Link source###############


###########Jave Version##############

import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        List<List<Integer>> triList = new ArrayList<>(); 
        
        List<Integer> list1 = new ArrayList<>(); 
        list1.add(2); 
        triList.add(list1);
        
        List<Integer> list2 = new ArrayList<>(); 
        list2.add(3);
        list2.add(4); 
        triList.add(list2);
        
        List<Integer> list3 = new ArrayList<>(); 
        list3.add(6);
        list3.add(5); 
        list3.add(7); 
        triList.add(list3);
        
        List<Integer> list4 = new ArrayList<>(); 
        list4.add(4); 
        list4.add(1);
        list4.add(8); 
        list4.add(3); 
        triList.add(list4);
      //System.out.println(triList);
      
      System.out.println(minimumTotal(triList));
    }
    
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        System.out.println(A.length);
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                System.out.println("A[j] and A[j+1] before exe: " + A[j] +"  &  "+ A[j+1] + ";      i and j: " + i+ " &  " +j);
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
                System.out.println("A[j] and triangle.get(i).get(j):   " + A[j] +" &  "+ triangle.get(i).get(j) + "\n");
            }
        }
        return A[0];
    }
}

#############Python Version###########
