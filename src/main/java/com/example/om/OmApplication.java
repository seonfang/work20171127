package com.example.om;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.om.pojo.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 实体类 --> Json -->Pojo
 * @author seon
 *2017年11月27日19:16:37
 */

@SpringBootApplication
public class OmApplication {

	@Autowired
	private  ObjectMapper mapper;
	
	 public static void main(String[] args) {
			SpringApplication.run(OmApplication.class, args);
		}
		
		@Bean
		public CommandLineRunner runner() {
			 String jsonString = "{\"name\":\"Seon\", \"age\":21}";
			return args -> {
				 System.out.println(jsonString);
				 System.out.println(mapper.readValue(jsonString, Person.class));
				System.out.println(mapper.writeValueAsString(mapper.readValue(jsonString, Person.class)));
			};
		}
		@Bean
		public  ObjectMapper objectMapper() {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper;
		}
	 
}
