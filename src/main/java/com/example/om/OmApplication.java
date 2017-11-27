package com.example.om;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.om.pojo.Person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 实体类 --> Json -->Pojo
 * @author seon
 *2017年11月27日19:16:37
 */

@SpringBootApplication
public class OmApplication {

//	@Autowired
//	private static ObjectMapper mapper;
	 public static void main(String args[]){
       ObjectMapper mapper = new ObjectMapper();
		    
	      String jsonString = "{\"name\":\"Seon\", \"age\":21}";
	      System.out.println(jsonString);
	      //map json to student
	      try {
	         Person person = mapper.readValue(jsonString, Person.class);
	         System.out.println(person);
	       
	         //把对象转成json string类型的
	         jsonString = mapper.writeValueAsString(person);
	         System.out.println(jsonString);

	      } catch (JsonParseException e) {
	         e.printStackTrace();
	      } catch (JsonMappingException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }
}
