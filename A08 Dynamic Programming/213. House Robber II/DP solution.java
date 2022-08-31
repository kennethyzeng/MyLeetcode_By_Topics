/*
Time Complexity:
Space Complexity:

*/ 

int len = nums.length;
        if (len == 0)
            return 0;
        if (len < 2)
            return nums[0];

        int[] startFromFirstHouse = new int[len];
        int[] startFromSecondHouse = new int[len];

        startFromFirstHouse[0] = nums[0];
        startFromFirstHouse[1] = Math.max(nums[0], nums[1]);
        
        startFromSecondHouse[0] = 0;
        startFromSecondHouse[1] = nums[1];

        for (int i = 2; i < len - 1; i++) {
            startFromFirstHouse[i] = Math.max(startFromFirstHouse[i - 1], startFromFirstHouse[i - 2] + nums[i]);
        }
        for (int i = 2; i < len; i++) {
            startFromSecondHouse[i] = Math.max(startFromSecondHouse[i - 1], startFromSecondHouse[i - 2] + nums[i]);
        }
//        System.out.println(Arrays.toString(startFromFirstHouse));
//        System.out.println(Arrays.toString(startFromSecondHouse));

        return Math.max(startFromFirstHouse[len - 2], startFromSecondHouse[len - 1]);