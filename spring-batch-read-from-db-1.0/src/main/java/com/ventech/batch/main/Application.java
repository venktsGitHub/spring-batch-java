package com.ventech.batch.main;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException, ParseException {
		
		SpringApplication.run(Application.class, args);
		
//		File path = new File("src/main/resources/data.txt");
//		
//		String content = new String(Files.readAllBytes(path.toPath()));
//		
//		System.out.println(content);
		
		//System.out.println(file.canWrite());
//		  
//		   DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
//	       Date d = dateFormat.parse(content);
//	       System.out.println("Resultant Date and Time = " + d.getTime());
	       
//		   
//	        FileWriter wr = new FileWriter(path);
//	        wr.write("rgukt");
//	        wr.flush();
//	        wr.close();
//	       
//	     
//	       
//	        
//	       	String content1 = new String(Files.readAllBytes(path.toPath()));
//			System.out.println(content1);
			
			 
			 
		//System.out.println(new ClassPathResource("").getFile().getAbsolutePath());
	}

}
