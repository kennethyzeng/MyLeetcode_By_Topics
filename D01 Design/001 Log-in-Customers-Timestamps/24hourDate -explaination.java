import java.util.*;
import java.text.*;
import java.util.Date;
import java.time.LocalDate;
//for file class
import java.io.File; 

//for open file
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//handle Arrays to List
import java.util.Arrays;
import java.util.List;
import java.lang.*;   //for Integer.parseInt()

public class MyClass {
    private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
    
    public static void main(String args[]) {
        List<List<Integer>> logInData = New ArrayList<>();
        
        //SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        
        Date date = new Date(System.currentTimeMillis());   //Sun Apr 17 01:48:37 GMT 2022.     //currentTimeMillis()  => 1580897313933
        String CurrTime = formatter1.format(date);  //2022-04-17-01:57
        String CurrDate = formatter2.format(date);  //2022-04-17
        String oneDateBefore = formatter2.format(new Date(date.getTime() - MILLIS_IN_A_DAY));  //2022-04-17
        
        String[] timeWords = CurrTime.split(":");  //split the minutes
        String[] dateWords = timeWords[0].split("-");
        int currHour = Integer.parseInt(timeWords[0].split("-")[3]);  //timeWords[0].split("-")[3]= >02.   //parseInt => 2
        String currDateDirectory = "/logs/"+ CurrDate +"/" ;
        String prevDateDirectory = "/logs/"+ oneDateBefore +"/" ;
        
        //open file and handle data for current date
        String[] pathnames;
        File f = new File(currDateDirectory);
        pathnames = f.list();    //get aall file name under current directory
        for (String pathname : pathnames) {
            BufferedReader reader;
		    try {
			    reader = new BufferedReader(new FileReader(currDateDirectory + pathname));
			    String line = reader.readLine();
			    while (line != null) {
			        String[] StrArray = line.split(","); 
			        Int[] IntArray = new int[]{Integer.parseInt(StrArray[0], Integer.parseInt(StrArray[1])}
			        List<Integer> subList = Arrays.asList(IntArray);
			        LogInData.add(subList);
				    // read next line
				    line = reader.readLine();
			    }
			    reader.close();
		    } catch (IOException e) {
			    e.printStackTrace();
		    }

        }
       
       
        if (currHour < 24){
            int remainHour = 24 - currHour;
        }
                                                                
        while(remainHour >=0){
            
            BufferedReader reader;
		    try {
			    reader = new BufferedReader(new FileReader(currDateDirectory + pathname2));
			    String line = reader.readLine();
			    while (line != null) {
			        String[] StrArray = line.split(","); 
			        Int[] IntArray = new int[]{Integer.parseInt(StrArray[0], Integer.parseInt(StrArray[1])};
			        List<Integer> subList = Arrays.asList(IntArray);
			        LogInData.add(subList);
				    // read next line
				    line = reader.readLine();
			    }
			    reader.close();
		    } catch (IOException e) {
			    e.printStackTrace();
		    }

        }
            
        
    }
}