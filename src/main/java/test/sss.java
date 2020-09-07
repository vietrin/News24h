package test;


import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class sss {

	public static void main(String[] args) {
//		 int i = (int) (new Date().getTime()/1000);
////		    System.out.println("Integer : " + i);
////		    System.out.println("Long : "+ new Date().getTime());
////		    System.out.println("Long date : " + new Date(new Date().getTime()));
//		    System.out.println("Int Date : " + new Date(((long)i)*1000L));
//		    System.out.println(new Date().getTime());
//		    
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
	System.out.println(formatter.format(date));
	System.out.println(formatter.format(date));
	Calendar cal = Calendar.getInstance();
	System.out.println(formatter.format(cal.getTime()));
	System.out.println(ZonedDateTime.now());
	}

}
