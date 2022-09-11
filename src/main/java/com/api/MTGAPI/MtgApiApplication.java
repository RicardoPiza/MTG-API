package com.api.MTGAPI;

import com.api.MTGAPI.controllers.CardController;
import com.api.MTGAPI.repositories.CardRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class MtgApiApplication {
	public CardRepository cardRepository;

	public static void main(String[] args) {SpringApplication.run(MtgApiApplication.class, args);}

//	@RequestMapping("/")
//	public ModelAndView index(){
//		return new ModelAndView("index");
//	}

}
