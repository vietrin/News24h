package test;


import java.util.Date;

public class sss {

	public static void main(String[] args) {
		//int s=Integer.valueOf(LocalDateTime.now().toString());
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
//	    Date date = new Date();
//	    Long s =Long.valueOf(formatter.format(date));
//        System.out.println(s);
		 int i = (int) (new Date().getTime()/1000);
//		    System.out.println("Integer : " + i);
//		    System.out.println("Long : "+ new Date().getTime());
//		    System.out.println("Long date : " + new Date(new Date().getTime()));
		    System.out.println("Int Date : " + new Date(((long)i)*1000L));
		    System.out.println(new Date().getTime());
		    
	}

}
