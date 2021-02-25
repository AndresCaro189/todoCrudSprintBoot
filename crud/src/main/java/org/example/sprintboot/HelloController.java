package org.example.sprintboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	 @GetMapping(value = "api/hello")
	 public String hello(){
	      return "Esto es un servicio web";
	  }
}
