package gr.hua.huaproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HuaprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuaprojectApplication.class, args);
	}

	@GetMapping
	public String homePage(){
		return "Welcome, this is our home page";
	}



}
