/*
Complete solution , but need to debug little bit; but main idea is there;

*/ 

import java.util.*;
import java.text.*;
import java.time.*;
import java.io.*; 

public class MyClass {
    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
    public static List<List<Integer>> logInData = New ArrayList<>(); 
    
    public static void min(String args[]) {
        
        int X;  //log in time
        get24LoginData();
        int[] targetCustomer = getCustomersLoggedTimes(logInData,  int X)
        for(int i: targetCustomer){
            System.out.println(i);
        }
        
    }
    
    //Part 1======blow is for get24LoginData()
    public static void get24LoginData(){

        SimpleDateFormat formatter1 = new SimpleDateFormat("HH");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        
        Date date = new Date(System.currentTimeMillis());  
        String CurrDate = formatter2.format(date);  //2022-04-17
        String oneDateBefore = formatter2.format(new Date(date.getTime() - MILLIS_IN_A_DAY));  //2022-04-16
        
        String strCurHour = formatter1.format(date);  //05
        Integer currHour = Integer.parseInt(strCurHour);
        
        
        String currDateDirectory = "/logs/"+ CurrDate +"/" ;
        String prevDateDirectory = "/logs/"+ oneDateBefore +"/" ;
        
        while(currHour >=0){
            String DateTime1 = UpdatedDateTime(CurrDate, currHour){
            handleLogData(currDateDirectory, DateTime1);
            currHour --;
        }
        
        if (currHour < 24){
            remainHour = 24 - currHour; 
            
        }
        while(remainHour >=0){
            int newHour = 24 - remainHour; 
            String DateTime2 = UpdatedDateTime(CurrDate, newHour){
            handleLogData(prevDateDirectory, DateTime2);
            remainHour --;
        }
        return;
    }
    
    public static String UpdatedDateTime(String date, Integer hour){
        String strHour = String.parseString(hour);
        String dateTime = date + "-0" +strHour+":mm";
        return dateTime;
    }
    
    public static List<List<Integer>> handleLogData(String Directory, String dateTime){
            BufferedReader reader;
		    try {
			    reader = new BufferedReader(new FileReader(Directory + dateTime));
			    String line = reader.readLine();
			    while (line != null) {
			        String[] StrArray = line.split(","); 
			        Int[] IntArray = new int[]{Integer.parseInt(StrArray[0]), Integer.parseInt(StrArray[1])};
			        List<Integer> subList = Arrays.asList(IntArray);
			        LogInData.add(subList);   //add data to LogInData
				    // read next line
				    line = reader.readLine();
			    }
			    reader.close();
		    } catch (IOException e) {
			    e.printStackTrace();
		    }
            return LogInData;
    }

    //PArt 2=====below is to handle to get targeted customer who login time match requirement
    static class Person {
        int id;
        List<Integer> timelist;  // list of time stamps
        int count;  // access times

        public Person(int id, int time) {
            this.id = id;
            timelist = new ArrayList<>();
            timelist.add(time);
            count = 1;  
        }
    }


    // return the customer ids whose access time is X
    public static int[] getCustomersLoggedTimes(List<List<Integer>> logs,  int X) {

        // Map(id, Person) key is id, Person is value
        Map<Integer, Person> map = new HashMap<>();
        for (List<Integer> log : logs) {
            int id = log.get(0);
            int time = log.get(1);
            map.putIfAbsent(id, new Person(id, time));
            map.get(id). timelist.add(time);
            map.get(id). timelist.count++;
        }

        // iterate the map to find the customers whose access times is X
        List<Integer> customers = new ArrayList<>();
        for (int id : map.keySet()) {
            if (map.get(id).count == X) customers.add(id);
        }
        int[] res = customers.size();
        int i = 0;
        for (int c : customers) res[i++] = c;
        return res;
    }
}
