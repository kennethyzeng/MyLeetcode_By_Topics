###########Link source###############


###########Jave Version##############
public class MyClass {
    public static void main(String args[]) {
        System.out.println(generate(4));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            // 在开头插入1
            list.add(0, 1);
            System.out.print("list: " + list + "\n");
            // 1,2,1 -> 1,1,2,1
            // 1,3,3,1
            for(int j = 1; j < list.size() - 1; j++){
                list.set(j, list.get(j) + list.get(j + 1));
                System.out.println("list inside for loop :" + list);
            }

            res.add(new ArrayList<>(list));
        }
        return res;
    }
}

________output_____
list: [1]
list: [1, 1]
list: [1, 1, 1]
list inside for loop :[1, 2, 1]
list: [1, 1, 2, 1]
list inside for loop :[1, 3, 2, 1]
list inside for loop :[1, 3, 3, 1]
[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]


#############Python Version###########
